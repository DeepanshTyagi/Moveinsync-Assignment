package com.example.demo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChefController {
	@Autowired // automatically create  the object of OrderInfoRepositry in IOC Container 
	OrderInfoRepositry orderInfoRepo;
	Queue<Integer> queue = new LinkedList<Integer>(); //Queue for store the id of customer 

	@RequestMapping("/processorder")
	public ModelAndView getProcessOrder(OrderInfoDTO orderinfo) {
		ModelAndView mv = new ModelAndView("process-order"); // Create the object of ModelandView 
		
		// fetch the quantities of items from DTO 
		int sand_quan = orderinfo.getSandwich_Quantity(); 
		int cof_quan = orderinfo.getCoffee_Quantity();
		int cer_quan = orderinfo.getCereal_Quantity();
		int piz_quan = orderinfo.getPizza_Quantity();
		
		// create the array and store the time of each item preparation 
		int Time_Array[] = { sand_quan * 5, cof_quan * 3, cer_quan * 3, piz_quan * 7 };
		int maxtime = Integer.MIN_VALUE; 
		
		// Find the maximum time from the time preparation array 
		for (int i = 0; i < 4; i++) {
			maxtime = Math.max(maxtime, Time_Array[i]);
		}
		
		// Set the Current time to the OrderInfoDTO 
		final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 orderinfo.setTime(sdf.format(timestamp));
		 
		 
		// set the maximum time to prepare the order to DTO 
		orderinfo.setMaxtime(maxtime);
		
		// save in the h2 database 
		orderInfoRepo.save(orderinfo);
		
		//fetch the order id from OrderInfoInfoDTO
		int orderid = orderinfo.getOrderid();
		
		// add the order id to the queue 
		queue.add(orderid);
		
		// add the OrderinfoDTO object to 
		mv.addObject("orderInfo", orderinfo);
		mv.addObject("time", maxtime);
		return mv;
	}
    
	// When customer take his order it remove data from h2 database and order id from queue 
	public int deleteData() {
		int id = queue.poll();
		OrderInfoDTO customerinfo = orderInfoRepo.getOne(id);
		orderInfoRepo.delete(customerinfo);
		return id;
	}
    
	// when customer take the order 
	@GetMapping("/fetchorder")
	public ModelAndView fetchData() {
		int id = deleteData();
	    ModelAndView mv=new ModelAndView("fetch-Order");
	    mv.addObject("orderid", id);
	    return mv;
	}
	
	
	// The Following methods is for postman because from the below methods we return json or XML format data 
	@GetMapping(path="/get") //if we use produces = "application/xml then produces only XML format data for machine 
	@ResponseBody
	public List<OrderInfoDTO> getData() {
		return orderInfoRepo.findAll(); // JPA Repository function that find order details from h2
	}
	 
	// When customer take his order it remove data from h2 database and order id from queue 
	public String TakeOrder() {
		int id = queue.poll();
		OrderInfoDTO orderinfo = orderInfoRepo.getOne(id);
		orderInfoRepo.delete(orderinfo);
		return "Order id "+id+" has Deleverd";
	}
	
	// For get the Data 
	@GetMapping("/takeorder")
	@ResponseBody
	public String takeOrder() 
	{
		String msg = TakeOrder();
	     return msg;
	}
	
	
}

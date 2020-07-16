package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WaiterController {
	@RequestMapping("/waiter") // we use @RequestMapping annotaion to map our handler with web request
	public String getHome() {
		return "home-page"; // from here we return only page name I add prefix and suffix in
							// application.properties file so if later I need to move file from one folder
							// to another then I need to change only prefix name in application.properties
							// file
	}
}

package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class OrderInfoDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderid;
	@NotBlank(message = " *User Name not blank")
	private String userName;
	private String[] items;
	private int sandwich_Quantity;
	private int coffee_Quantity;
	private int cereal_Quantity;
	private int Pizza_Quantity;
	private int maxtime;
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String timestamp) {
		this.time = timestamp;
	}

	public int getMaxtime() {
		return maxtime;
	}

	public void setMaxtime(int maxtime) {
		this.maxtime = maxtime;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String[] getItems() {
		return items;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSandwich_Quantity() {
		return sandwich_Quantity;
	}

	public void setSandwich_Quantity(int sandwich_Quantity) {
		this.sandwich_Quantity = sandwich_Quantity;
	}

	public int getCoffee_Quantity() {
		return coffee_Quantity;
	}

	public void setCoffee_Quantity(int coffee_Quantity) {
		this.coffee_Quantity = coffee_Quantity;
	}

	public int getCereal_Quantity() {
		return cereal_Quantity;
	}

	public void setCereal_Quantity(int cereal_Quantity) {
		this.cereal_Quantity = cereal_Quantity;
	}

	public int getPizza_Quantity() {
		return Pizza_Quantity;
	}

	public void setPizza_Quantity(int pizza_Quantity) {
		Pizza_Quantity = pizza_Quantity;
	}

}

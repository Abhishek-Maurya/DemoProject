package com.demoproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.Random;
import java.util.UUID;

//Main Model Class
@Document(collection = "UserDetails")
public class UserDetails {

	@Id
	private String id;

	private String username;
	private String password;
	private String entryTime;
	private String date;
	private int productStock;
	private static int usercount = 0;
	private int userval;
	private int productCode;
	private int productprice;
	private int productWeight;

	public UserDetails() {

	}

	public UserDetails(String username, String password) {

		usercount += 1;
		LocalTime time = LocalTime.now();
		Random random = new Random();
		this.id = UUID.randomUUID().toString();
		this.username = username;
		this.password = password;
		this.entryTime = time.toString();
		this.date = java.time.LocalDate.now().toString();
		this.productStock = random.nextInt(1000);
		this.userval = UserDetails.usercount;
		this.productCode = random.nextInt(10);
		this.productprice = random.nextInt(500);
		this.productWeight = random.nextInt(1000);

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public static int getUsercount() {
		return usercount;
	}

	public static void setUsercount(int usercount) {
		UserDetails.usercount = usercount;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public int getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(int productWeight) {
		this.productWeight = productWeight;
	}

	public int getUserval() {
		return userval;
	}

	public void setUserval(int userval) {
		this.userval = userval;
	}

}

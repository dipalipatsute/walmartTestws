package com.walmart.inventoryws.bo;

public class Currency {
	
	private int id;
	private String currency;
	private String country;

	public Currency(int id, String currency, String country){
		this.id = id;
		this.currency = currency;
		this.country = country;
	}
	
	public int getId() {
		return id;
	}
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

}

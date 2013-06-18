package com.walmart.testws.bo;

import java.util.Currency;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Store")
@XmlAccessorType(XmlAccessType.FIELD)

public class Store {
	
	private int id;
	private String name;
	private int currencyId;
	private int locId;
	private List<StoreItem> storeItem;
	
	public Store(){}
	
	public Store (int id, String name, int currencyId, int locId){
		this.id = id;
		this.name = name;
		this.currencyId = currencyId;
		this.locId = locId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrency() {
		return currencyId;
	}

	public void setCurrency(int currencyId) {
		this.currencyId = currencyId;
	}

	public List<StoreItem> getStoreItem() {
		return storeItem;
	}

	public void setStoreItem(List<StoreItem> storeItem) {
		this.storeItem = storeItem;
	}

	
	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}	
	
}

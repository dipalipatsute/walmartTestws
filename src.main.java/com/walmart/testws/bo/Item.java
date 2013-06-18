package com.walmart.testws.bo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
	private int id;
	private String description;
	private List<StoreItem> storeItems;
	
	public Item(){}
	public Item(int id, String description){
		this.id = id;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return description;
	}
	public void setName(String description) {
		this.description = description;
	}
	public List<StoreItem> getStoreItems() {
		return storeItems;
	}
	public void setStoreItems(List<StoreItem> storeItems) {
		this.storeItems = storeItems;
	}
}

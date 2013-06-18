package com.walmart.inventoryws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.walmart.inventoryws.bo.Item;
import com.walmart.inventoryws.bo.StoreItem;

@Path("items")
public class ItemService extends BaseService{
//	private static Map<Integer, Item> items = new HashMap<Integer, Item>();
	private static int itemIdGenerator = 4;
	
//	URLPattern: /items
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getItems(@HeaderParam("auth") String authToken){
		if(!validRequest(authToken)){
			throw new WebApplicationException(400);
		}
		return new ArrayList<Item>(DataCache.getItems().values());
	}
	
//	URLPattern: /items/{id}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Item getItem(@HeaderParam("auth") String authToken, @PathParam("id") int id){
		if(!validRequest(authToken)){
			throw new WebApplicationException(400);
		}
		return DataCache.getItem(id);
	}	
	
//	URLPattern: /items/createItem
	@POST
	@Path("createItem")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Item createItem(@HeaderParam("auth") String authToken, Item item){
		if(!validRequest(authToken)){
			throw new WebApplicationException(400);
		} 
		if(item.getId() == 0){
//			Add Request
			int id = itemIdGenerator++;
			item.setId(id);
			List<StoreItem> storeItems = item.getStoreItems();
			for(StoreItem storeItem : storeItems){
				storeItem.setItemId(id);
				DataCache.addToStore(storeItem.getStoreId(), storeItem);
			}
		}else if(item.getId() <0){
//			Update request
		}
		DataCache.addItem(item);
		return item;
	}	
	
//	URLPattern: /items/deleteItem/{id}
	@DELETE
	@Path("deleteItem/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void removeItem(@HeaderParam("auth") String authToken, @PathParam("id") int id){
		if(!validRequest(authToken)){
			throw new WebApplicationException(400);
		}
		DataCache.removeItem(id);
	}	
	

}

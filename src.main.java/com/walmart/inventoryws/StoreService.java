package com.walmart.inventoryws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.walmart.inventoryws.bo.Store;


@Path("stores")
public class StoreService extends BaseService{
	
//	URLPattern: /stores
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Store> getStore(@HeaderParam("auth") String authToken){
		if(!validRequest(authToken)){
			throw new WebApplicationException(400);
		}
		return new ArrayList<Store>(DataCache.getStores().values());
	}
	
//	URLPattern: /stores/{id}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)	
	public Store getStore(@HeaderParam("auth") String authToken, @PathParam("id") int id){
		if(!validRequest(authToken)){
			throw new WebApplicationException(400);
		}
		return DataCache.getStore(id);
	}
	

}

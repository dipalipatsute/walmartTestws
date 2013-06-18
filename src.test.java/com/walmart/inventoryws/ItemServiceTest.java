package com.walmart.inventoryws;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.walmart.inventoryws.bo.Item;
import com.walmart.inventoryws.bo.StoreItem;


@RunWith(PowerMockRunner.class)
@PrepareForTest({DataCache.class})
public class ItemServiceTest {
	 
	@Test
	public void testGetItems(){
		
		// Make sure that webapplication exception is thrown when no authToken is supplied
		ItemService itemService = new ItemService();		
		try{
			itemService.getItems("");
			fail("web application exception was not thrown");
		}catch(WebApplicationException ex){
			// Good Exception!
			ex.printStackTrace();
		}
		
		// Mock the validRequest method, so that we can test the rest without having to suppply the authToken
		itemService = Mockito.spy(new ItemService());
		Mockito.doReturn(new Boolean(true)).when(itemService).validRequest(any(String.class));
		
		Map<Integer, Item> itemsMap = new HashMap<Integer, Item>();		
		PowerMockito.mockStatic(DataCache.class); 
		when(DataCache.getItems()).thenReturn(itemsMap);
		
		List<Item> items = itemService.getItems("");
		assertNotNull(items);
	}
	
	@Test
	public void testGetItem(){
		// Make sure that webapplication exception is thrown when no authToken is supplied
		ItemService itemService = new ItemService();		
		try{
			itemService.getItem("",1);
			fail("web application exception was not thrown");
		}catch(WebApplicationException ex){
			// Good Exception!
			ex.printStackTrace();
		}	
		
		// Mock the validRequest method, so that we can test the rest without having to suppply the authToken
		itemService = Mockito.spy(new ItemService());
		Mockito.doReturn(new Boolean(true)).when(itemService).validRequest(any(String.class));
		
		Map<Integer, Item> itemsMap = new HashMap<Integer, Item>();		
		PowerMockito.mockStatic(DataCache.class); when(DataCache.getItem(Mockito.anyInt())).thenReturn(new Item());
		
		Item item = itemService.getItem("", 1);
		assertNotNull(item);
	}
	
	@Test
	public void testCreateItem(){
		// Make sure that webapplication exception is thrown when no authToken is supplied
		ItemService itemService = new ItemService();		
		try{
			itemService.createItem("", new Item());
			fail("web application exception was not thrown");
		}catch(WebApplicationException ex){
			// Good Exception!
			ex.printStackTrace();
		}	
		
		// Mock the validRequest method, so that we can test the rest without having to suppply the authToken
		itemService = Mockito.spy(new ItemService());
		Mockito.doReturn(new Boolean(true)).when(itemService).validRequest(any(String.class));
		
		PowerMockito.mockStatic(DataCache.class);
		when(DataCache.addItem(Mockito.any(Item.class))).thenReturn(null); 		
		Mockito.doNothing().when(DataCache.addToStore(Mockito.anyInt(), any(StoreItem.class)));
		
		Item newItem = new Item();
		List<StoreItem> storeItems = new ArrayList<StoreItem>();
		storeItems.add(new StoreItem());
		newItem.setStoreItems(storeItems);
		itemService.createItem("", newItem);
		PowerMockito.verifyStatic();

	}
}

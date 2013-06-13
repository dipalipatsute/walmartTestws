package com.walmart.inventoryws;

import org.junit.Test;
import org.mockito.Mockito;

import com.walmart.inventoryws.BaseService;
import com.walmart.inventoryws.ItemService;

public class ItemServiceTest {

	@Test
	public void testGetItems(){
		BaseService baseService = new BaseService();
		ItemService itemService = new ItemService();
		itemService.getItems(null);
		
		//spy base service to fake valid response without auth token.
		BaseService spyBaseService = Mockito.spy(baseService);
		
		//TODO: call itemservice.getItem with spyBaseService mock object.
	}
}



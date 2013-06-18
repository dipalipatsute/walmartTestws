package com.walmart.inventoryws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.walmart.inventoryws.bo.*;


public class DataCache implements ServletContextListener {
    
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static Map<Integer, Store> stores = new HashMap<Integer, Store>();
    private static Map<Integer, Item> items = new HashMap<Integer, Item>();
    private static Map<Integer, Currency> currencies = new HashMap<Integer, Currency>();
    private String language = "English";
    private String country = "United States";
    
    
    //private static Map<Integer, StoreItem> storeItems = new HashMap<Integer, StoreItem>();

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
   	 System.out.print("Loading Masterdata ...");
//   	 populateLocations();
   	 populateStores();
   	 populateItems();
    }
    
    private void populateLocations(){
   	 locations.put(1, new Location(1,"Halford Ave", "Santa Clara", "CA", "USA"));
   	 locations.put(2, new Location(2,"EL Camino", "San Jose","CA", "USA"));
    }
    
    private void populateCurrencies(){
    	currencies.put(1, new Currency(1,"USD", "USA"));
    	currencies.put(2, new Currency(2,"JPY", "JPY"));
       }    
    
    private void populateStores(){   	 
   	 // location #1 (Santa Clara) stores
   	 stores.put(11, new Store(11, "SC Store 1", 1, 11));
   	 stores.put(12, new Store(12, "SC Store 2", 1, 1));
   	 
   	 // location #2 (San Jose) stores
   	 stores.put(21, new Store(21, "SJ Store 1", 1, 2));
   	 stores.put(22, new Store(22, "SJ Store 2", 1, 2));

    }
    
    private void populateItems(){
//    Load items
   	 Item tv = new Item(1, "TV");
   	 List<StoreItem> tvStores = new ArrayList<StoreItem>(); items.put(1, tv);
   	 StoreItem tv11 = new StoreItem(11, 1, 10, 4); tvStores.add(tv11);
   	 StoreItem tv12 = new StoreItem(12, 1, 10, 4); tvStores.add(tv12);
   	 StoreItem tv21 = new StoreItem(21, 1, 10, 4); tvStores.add(tv21);
   	 StoreItem tv22 = new StoreItem(22, 1, 10, 4); tvStores.add(tv22);
   	 tv.setStoreItems(tvStores);
   	 
   	 Item babyFood = new Item(2, "Baby Food"); items.put(2, babyFood);
   	 List<StoreItem> babyFoodStores = new ArrayList<StoreItem>();
   	 StoreItem babyFood11 = new StoreItem(11, 2, 10, 4); babyFoodStores.add(babyFood11);
   	 StoreItem babyFood12 = new StoreItem(12, 2, 10, 4); babyFoodStores.add(babyFood12);
   	 StoreItem babyFood21 = new StoreItem(21, 2, 10, 4); babyFoodStores.add(babyFood21);
   	 StoreItem babyFood22 = new StoreItem(22, 2, 10, 4); babyFoodStores.add(babyFood22);
   	 babyFood.setStoreItems(babyFoodStores);
   	 
   	 Item shoes = new Item(3, "Shoes"); items.put(3, shoes);
   	 List<StoreItem> shoesStores = new ArrayList<StoreItem>();
   	 StoreItem shoes11 = new StoreItem(11, 3, 10, 4); shoesStores.add(shoes11);
   	 StoreItem shoes12 = new StoreItem(12, 3, 10, 4); shoesStores.add(shoes12);
   	 StoreItem shoes21 = new StoreItem(21, 3, 10, 4); shoesStores.add(shoes21);
   	 StoreItem shoes22 = new StoreItem(22, 3, 10, 4); shoesStores.add(shoes22);
   	 shoes.setStoreItems(shoesStores);
   	 
//   	 Load item and store mapping data
   	 List<StoreItem> store11Items = new ArrayList<StoreItem>();
   	 store11Items.add(tv11);
   	 store11Items.add(babyFood11);
   	 store11Items.add(shoes11);
   	 stores.get(11).setStoreItem(store11Items);
   	 
   	 List<StoreItem> store12Items = new ArrayList<StoreItem>();
   	 store12Items.add(tv12);
   	 store12Items.add(babyFood12);
   	 store12Items.add(shoes12);
   	 stores.get(12).setStoreItem(store12Items);
   	 
   	 List<StoreItem> store21Items = new ArrayList<StoreItem>();
   	 store21Items.add(tv21);
   	 store21Items.add(babyFood21);
   	 store21Items.add(shoes21);
   	 stores.get(21).setStoreItem(store21Items);
   	 
   	 List<StoreItem> store22Items = new ArrayList<StoreItem>();
   	 store22Items.add(tv22);
   	 store22Items.add(babyFood22);
   	 store22Items.add(shoes22);
   	 stores.get(22).setStoreItem(store22Items);
    }
    
    public static Item addItem(Item item){
   	 items.put(item.getId(), item);
   	 return item;
    }
    
    public static Map<Integer, Item> getItems(){
   	 return items;
    }
    
    public static Item getItem(int id){
   	 return items.get(id);
    }
    
	public static void removeItem(int id){
		items.remove(id);
	}
    
    public static Map<Integer, Store> getStores(){
   	 return stores;
    }
    
    public static Store getStore(int id){
   	 return stores.get(id);
    }
    
    public static StoreItem addToStore(int storeId, StoreItem storeItem){
   	 	stores.get(storeId).getStoreItem().add(storeItem);
   	 	return storeItem;
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
   	 System.out.print("Unloading Masterdata ...");
   	 locations = null;
   	 stores = null;
   	 items = null;
   	 currencies = null;
    }
}
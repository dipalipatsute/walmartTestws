walmartTestws
=============

Walmart Labs Test


DB Schema Notes:
- Item table has one-to-many realtionship with StoreItem table.
- Store table has one-to-many relationship with StoreItem table.
- steps (1) and (2) are added to create many to many relationship between Item and Store table
- Store table has one-to-one relationship with Location table and with Currency Table.
- Currency table is master table for currency information.


Request flow:
- on sever starup , ServletContextInitializer initializes DataCache. also registers '/services/*' URL pattern.
- DataCache class is used in this application to mimic database as DB creation and DAO layer implementation is not done due to time constraint.(Although schema.sal is attached here to get fair idea about db strucutre).
- All request, goes through SecurityService, which valides a authToken in request Header and then only lets request pass through to execute other business logic.
- Services are talking to BO's (Item, Store, StoreItem and Location).
- For now business objects are interacting with DataCache, but this could easily be extened to DAO layer and thereafter acutal DB.

Integration/Automation test:
Jersey client framework, supports ws integration testing. It has WebResource, ClientResponse etc objects which creates client resource and makes ws call.


Technolgies:
- Apache sever is used as app server.
- Jersey framerwork is used for ws implementation.
- WS request and response is jSON only (MediaType.APPLICATION_JSON)
- Jersey Client is used for integration test.
- Junit - for unit testing.

Below are test case priorities, where low being lowest and critical being highest
LOW, MINOR, MAJOR, CRITICAL.

Test Cases:
- Location currency mismatch. (Priority: Major)
Add india as location and use $ as currency. This test should fail. There should be mapping between countries and currencies.
- Invalid address - (Priority: Major)
Some countries does not have counties, application should make sure no one is entering wrong store addresses. and test should fail.
- Security token validation(Priority: Critical) - This test case is already implemented as a part of integration test.
Error message should be presented when security token is not provided in request header.
- Insufficient data - (Priority: Major)
For POST(createItem) service if store id and quantity is not provided in request, then request should fail.
- Scalability Test - (Priority: Critical)
Write kind of load mini load test code, (use multithreading etc) to create n number of requests at the same time and make sure application is scalable. (Note: this would be only one of the aspects for scalability, please read more of Scalability section)
- Duplicate data validation (Priority: Major)
- POST call is not exposed as GET and vise varsa (Priority: Major)
- Bulk data insert (Priority: Major)
This is mainly to test how database is reacting to connections and load.
- HTTP vs HTTPS availability (Priority: Major)
Services should be secure and only accessible by HTTPS protocol to provide additional level of security. This wasnt in core requirement but i think it is important to have from security point of view.
- Concurrency (Priority: Major)
Concurrent data updates, to make sure application and database is capable of handling mutiple requests. this will be on of the major aspects from scalability point of view.
- Internationalization
  - validate security token
  - locations and currency should vary appropriately. 
	- data should properly fall under search as there is radius search for items.
- Field validation and field limit validation (Priority: low)
	- All fields should accepts valid data (ie. numeric fields should accepts numeric values only etc)
	- Max and min limit validation, all fields should have max and min(quantity shouldn't be -ve) limits on it. 
	

SCALABILITY:
These are the important things to consider to increase scalability.\n
- Use DB indexes wisely. Also use optimal data storage. Might want to consider partitions to improve search response.
- Have multiple services running and available , and control it web server level. Load balancer etc. will play important role here.
	
STEPS I FOLLOWED TO CREATE THIS APPLCIATION:
- In eclipse, i created dynamic webproject
- Updated proper listeners and url patterns in web.xml
- Added jersey and junit jars
- Configured tomcat server
- created src.main.java and src.main.test folders
- added core BO classes, and DataCache class.(this is acting as db for my application)
- DataCache class implements ServletContextListener interface and hence data is loaded at server startup.
- Added services , Security Service generates a token and maintains throughout the application.
- all services are processing JSON only requests and producing json response
- Auth token validation is done before processing all the services.


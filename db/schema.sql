/* WalMartInventoryDB */
/* create tables */

/* table Item */
Drop table if exists Item;
Create table Item
(
Id int(11) primary key not null auto_increment,
Descriiption varchar(25)
);

/* table Location */
Drop table if exists Location;
Create table Location
(
Id int(11) primary key not null auto_increment,
Street varchar(25),
City varchar(25),
State varchar(25),
Country varchar(25)
);

/* table Currency */
Drop table if exists Currency;
Create table Currency
(
Id int(11) primary key not null auto_increment,
Currency varchar(3),
Country varchar(25)
);

/* table Store */
Drop table if exists Store;
Create table Store
(
Id int(11) primary key not null auto_increment,
Name varchar(25),
LocationId int(11) not null,
CurrencyId int(11) not null,
Foreign key (LocationId) references Location(id)
                      On delete cascade,
Foreign key (CurrencyId) references Currency(id)
                      On delete cascade                    
);


/* table Store */
Drop table if exists StoreItem;
Create table Store
(
id int(11) primary key not null auto_increment,
StoreId int(11) not null,
ItemId int(11) not null,
Quantity int(11) not null,
Price Number(19,4) not null,
Foreign key (StoreId) references Store(Id)
                      On delete cascade,
Foreign key (ItemId) references Item(Id)
                      On delete cascade                    
);



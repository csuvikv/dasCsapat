drop table Customer;
drop table Pizza;
drop table Orderr;
drop table Admin;
drop table CustomerToOrder;
drop table PizzaToOrder;
drop table AdminToOrder;
drop table Basket;

create table Customer
(
	id integer primary key,
	name varchar(255),
	eMail varchar(255),
	city varchar(255),
	street varchar(255),
	zipCode Integer,
	houseNumber Integer
);

create table Pizza
(
	id integer primary key,
	name varchar(255),
	size integer,
	cost integer,
	ingredients varchar(255)
);

create table Orderr
(
	id integer primary key,
	date date,
	success varchar(255),
	city varchar(255),
	street varchar(255),
	zipCode Integer,
	houseNumber Integer
);

create table Admin
(
	id integer primary key,
	name varchar(255)
);

create table CustomerToOrder
(
	customerId unique, 
	orderId unique,
	
	FOREIGN KEY(customerId) REFERENCES Customer(id),
	FOREIGN KEY(orderId) REFERENCES Orderr(id)
);


create table PizzaToOrder
(
	id primary key,
	pizzaId integer,
	orderId integer,
	
	FOREIGN KEY(pizzaId) REFERENCES Pizza(id),
	FOREIGN KEY(orderId) REFERENCES Orderr(id)
);

create table AdminToOrder
(
	orderId integer primary key,
	adminId integer,
	
	FOREIGN KEY(orderId) REFERENCES Orderr(id),
	FOREIGN KEY(adminId) REFERENCES Admin(id)
);

create table Basket
(
	id integer primary key,
	pizzaId integer,
	customerId integer,
	
	FOREIGN KEY(pizzaId) REFERENCES Pizza(id),
	FOREIGN KEY(customerId) REFERENCES Customer(id)
);
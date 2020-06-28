

--This is me, registred as Affiliate
insert into shop.users(first_name,last_name,user_type) values ('Kamel','Haddad','AFFILIATE');
--This is you, registred as Employee since more than 3 years
insert into shop.users(first_name,last_name,registration_date,user_type) values ('Amer','Asha',{ts '2017-06-20 18:00:00.00'},'EMPLOYEE');
--This is the Java Inventor, registred as Customer since 2 years
insert into shop.users(first_name,last_name,registration_date,user_type) values ('James','Gosling',{ts '2018-06-20 18:00:00.00'},'CUSTOMER');
--This is the Spring framework Inventor, registred as Customer since 1 year only
insert into shop.users(first_name,last_name,registration_date,user_type) values ('Rod','Johnson',{ts '2019-06-20 18:00:00.00'},'CUSTOMER');


insert into shop.orders(user_id) values (1);
insert into shop.orders(user_id) values (2);
insert into shop.orders(user_id) values (3);
insert into shop.orders(user_id) values (4);


insert into shop.products(name,unit_price) values ('IPhone X',1099.99);
insert into shop.products(name,unit_price) values ('Flash Drive',25.50);
insert into shop.products(name,unit_price) values ('Webcam',29.99);
insert into shop.products(name,unit_price) values ('Laptop',762.00);
insert into shop.products(name,unit_price) values ('Drone Toy',378.25);
insert into shop.products(name,unit_price) values ('Note Book',5.00);

insert into shop.products(name,unit_price,product_type) values ('Nutella',22.20,'GROCERIES');
insert into shop.products(name,unit_price,product_type) values ('Mixed Nuts',15.25,'GROCERIES');
insert into shop.products(name,unit_price,product_type) values ('Nescafe Gold',12.99,'GROCERIES');
insert into shop.products(name,unit_price,product_type) values ('Pringles Chips',8.40,'GROCERIES');
insert into shop.products(name,unit_price,product_type) values ('Green Tea',14.00,'GROCERIES');
insert into shop.products(name,unit_price,product_type) values ('Olive Oil 1 litre',28.50,'GROCERIES');


insert into shop.line_items(order_id,product_id,quantity,unit_price) values (1,1,1,1099.99);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (1,2,2,25.50);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (1,3,1,29.99);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (1,7,1,22.20);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (1,8,3,15.25);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (1,9,2,12.99);

insert into shop.line_items(order_id,product_id,quantity,unit_price) values (2,2,2,25.50);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (2,3,1,29.99);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (2,4,1,762.00);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (2,8,3,15.25);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (2,9,2,12.99);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (2,10,4,8.40);

insert into shop.line_items(order_id,product_id,quantity,unit_price) values (3,3,1,29.99);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (3,4,1,762.00);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (3,5,2,378.25);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (3,9,2,12.99);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (3,10,4,8.40);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (3,11,3,14.00);

insert into shop.line_items(order_id,product_id,quantity,unit_price) values (4,4,1,762.00);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (4,5,2,378.25);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (4,6,4,5.00);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (4,10,4,8.40);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (4,11,3,14.00);
insert into shop.line_items(order_id,product_id,quantity,unit_price) values (4,12,2,28.50);


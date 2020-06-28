CREATE SCHEMA shop AUTHORIZATION sa; 
-----------Drop Tables-----------------
DROP TABLE IF EXISTS shop.discounts;
DROP TABLE IF EXISTS shop.bills;
DROP TABLE IF EXISTS shop.products;
DROP TABLE IF EXISTS shop.line_items;
DROP TABLE IF EXISTS shop.orders;
DROP TABLE IF EXISTS shop.users;
-----------Table USER------------------
CREATE TABLE shop.users(
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  registration_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  user_type VARCHAR(10) NOT NULL DEFAULT 'CUSTOMER',
  check (user_type  in ('EMPLOYEE','AFFILIATE','CUSTOMER'))
);

-----------Table orders-----------------
CREATE TABLE shop.orders(
  order_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  billed Boolean NOT NULL DEFAULT FALSE,
  foreign key (user_id) references users(user_id)
);
-----------Table products-----------------
CREATE TABLE shop.products(
  product_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  unit_price DECIMAL(9, 2) NOT NULL,
  product_type VARCHAR(10) NOT NULL DEFAULT 'OTHERS',
  check (product_type  in ('GROCERIES','OTHERS'))
);
-----------Table line_items-----------------
CREATE TABLE shop.line_items(
  order_id INT NOT NULL,
  product_id INT NOT NULL,
  quantity INT NOT NULL,
  unit_price DECIMAL(9, 2) NOT NULL,
  primary key(order_id , product_id),
  foreign key (order_id) references orders(order_id),
  foreign key (product_id) references products(product_id)
);

-----------Table bills-----------------
CREATE TABLE shop.bills(
  bill_id INT AUTO_INCREMENT PRIMARY KEY,
  order_id INT NOT NULL,
  billing_address VARCHAR(250) NOT NULL,
  shipping_address VARCHAR(250) NOT NULL,
  total_non_groceries_amount DECIMAL(9,2) NOT NULL,
  total_amount DECIMAL(9,2) NOT NULL,
  total_discount DECIMAL(9,2) NOT NULL,
  foreign key (order_id) references orders(order_id)
);

-----------Table discounts-----------------
CREATE TABLE shop.discounts(
  discount_id INT AUTO_INCREMENT PRIMARY KEY,
  bill_id INT NOT NULL,
  description VARCHAR(250) NOT NULL,
  discount_amount DECIMAL(9,2) NOT NULL,
  foreign key (bill_id) references bills(bill_id )
);

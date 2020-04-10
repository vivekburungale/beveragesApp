DROP TABLE IF EXISTS menu_items;
CREATE TABLE menu_items
(
   id INT PRIMARY KEY AUTO_INCREMENT,
   item_name   VARCHAR(255),
   item_price DOUBLE
);


DROP TABLE IF EXISTS ingredients;
CREATE TABLE ingredients
(
   ing_id INT PRIMARY KEY AUTO_INCREMENT,
   ingname   VARCHAR(255),
   price DOUBLE
);





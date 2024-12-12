create database OrderSync ;
show databases;
use ordersync;

CREATE TABLE customer (
    id INT PRIMARY KEY,
    nom VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(15)
);

CREATE TABLE `order` (
    id INT PRIMARY KEY,
    date VARCHAR(255),
    amount DOUBLE,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);
INSERT INTO customer (id, nom, email, phone) VALUES
(101, 'Marouane', 'Marouane@example.com', '0601020304'),
(102, 'Amine', 'Amine@example.com', '0602030405');

SELECT * FROM customer;

SELECT * FROM `order`;
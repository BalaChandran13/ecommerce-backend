drop table product if exists;

CREATE TABLE product (
id int(11) NOT NULL AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
brand VARCHAR(100) NOT NULL,
size VARCHAR(100) NOT NULL,
seller VARCHAR(100) NOT NULL,
price float(11) NOT NULL,
PRIMARY KEY(id)
);

insert into product (name, brand, size, seller, price) values ('Pant', 'Raymond', 'L', 'BalaMurali', 1000);
insert into product (name, brand, size, seller, price) values ('Sock', 'Nike', 'FS', 'Sethu', 2000);
insert into product (name, brand, size, seller, price) values ('Pant', 'Raymond', 'L', 'BalaMurali', 3000);
insert into product (name, brand, size, seller, price) values ('Cap', 'Adidas', 'FS', 'Prabha', 2000.50);
insert into product (name, brand, size, seller, price) values ('Shirt', 'Tommy', 'M', 'Chandru', 1500.75);
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

insert into product (name, brand, size, seller, price) values ('Pant', 'Raymond', 'L', 'Jack', 1000);
insert into product (name, brand, size, seller, price) values ('Sock', 'Nike', 'FS', 'Chandru', 2000);
insert into product (name, brand, size, seller, price) values ('Pant', 'Raymond', 'L', 'Murali', 1000);
insert into product (name, brand, size, seller, price) values ('Cap', 'Adidas', 'FS', 'Bala', 500);
insert into product (name, brand, size, seller, price) values ('Shirt', 'Tommy', 'M', 'Micheal', 1500);
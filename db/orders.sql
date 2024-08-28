CREATE TABLE IF NOT EXISTS customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

CREATE TABLE IF NOT EXISTS orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into customers (first_name, last_name, age, country)
VALUES ('Mike', 'Tyson', 50, 'USA');
insert into customers (first_name, last_name, age, country)
VALUES ('Mike', 'Nelson', 13, 'USA');
insert into customers (first_name, last_name, age, country)
VALUES ('Kirk', 'Duglas', 27, 'USA');
insert into customers (first_name, last_name, age, country)
VALUES ('Yosef', 'Shweik', 41, 'Szchehoslwakia');
insert into customers (first_name, last_name, age, country)
VALUES ('Ivan', 'Drago', 24, 'Russia');
insert into customers (first_name, last_name, age, country)
VALUES ('Roman', 'Zver', 47, 'Russia');
insert into customers (first_name, last_name, age, country)
VALUES ('Oleg', 'Gazmanov', 56, 'Russia');
insert into customers (first_name, last_name, age, country)
VALUES ('Arnold', 'Shwarznegger', 29, 'Austria');

insert into orders (amount, customer_id)
VALUES ( 29, 1);
insert into orders (amount, customer_id)
VALUES ( 1, 1);
insert into orders (amount, customer_id)
VALUES ( 6, 1);
insert into orders (amount, customer_id)
VALUES ( 5, 2);
insert into orders (amount, customer_id)
VALUES ( 5, 2);
insert into orders (amount, customer_id)
VALUES ( 5, 2);
insert into orders (amount, customer_id)
VALUES ( 1, 3);
insert into orders (amount, customer_id)
VALUES ( 9, 3);
insert into orders (amount, customer_id)
VALUES ( 66, 3);
insert into orders (amount, customer_id)
VALUES ( 4, 4);
insert into orders (amount, customer_id)
VALUES ( 3, 4);
insert into orders (amount, customer_id)
VALUES ( 62, 4);
insert into orders (amount, customer_id)
VALUES ( 7, 5);
insert into orders (amount, customer_id)
VALUES ( 71, 6);
insert into orders (amount, customer_id)
VALUES ( 88, 7);
insert into orders (amount, customer_id)
VALUES ( 3, 8);
insert into orders (amount, customer_id)
VALUES ( 51, 8);
insert into orders (amount, customer_id)
VALUES ( 86, 8);

--Выполните запрос, который вернет список клиентов, возраст которых является минимальным.
select * from customers where age = (select min(age) from customers);

--Необходимо выполнить запрос, который вернет список пользователей,
--которые еще не выполнили ни одного заказа. Используйте подзапрос, для реализации Вам понадобится NOT IN.
select * from customers where id not in (select customer_id from orders);


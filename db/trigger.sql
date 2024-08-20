create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

-- 1)  Триггер должен срабатывать после вставки данных, для любого товара и
--просто насчитывать налог на товар (нужно прибавить налог к цене товара).
-- Действовать он должен не на каждый ряд, а на запрос (statement уровень)
create trigger tax_trigger
    after insert
    on products
    for each statement
execute procedure add_tax_statement();

create
    or replace function add_tax_statement()
    returns trigger as
$$
BEGIN
    update products
    set price = price + price * 0.15;
    return null;
END;
$$
    LANGUAGE 'plpgsql';

--   2) Триггер должен срабатывать до вставки данных и
--насчитывать налог на товар (нужно прибавить налог к цене товара). Здесь используем row уровень.
create trigger tax_trigger_row
    before insert
    on products
    for each row
execute procedure add_tax_row();

create
    or replace function add_tax_row()
    returns trigger as
$$
BEGIN
    NEW.price := NEW.price + 0.5 * NEW.price;
    return NEW;
END;
$$
    LANGUAGE 'plpgsql';

--3 Нужно написать триггер на row уровне, который сразу после
--вставки продукта в таблицу products, будет заносить имя, цену и текущую дату в таблицу history_of_price.
create trigger ref_trigger
    after insert
    on products
    referencing new table as inserted
    for each row
execute procedure add_ref();

create
    or replace function add_ref()
    returns trigger as
$$
BEGIN
    insert into history_of_price (name, price, date)
    select name, price, now() from inserted;
    return null;
END;
$$
    LANGUAGE 'plpgsql';

/*
insert into products (name, producer, count, price) VALUES ('product_hh', 'producer_hh', 3, 100);
select * from products
select * from history_of_price
*/

create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

create
    or replace procedure del_product_proc(i_count integer)
    language 'plpgsql'
as $$
BEGIN
    delete from products where count = i_count;
END
$$;

create
    or replace function del_product_fn() RETURNS integer
    language 'plpgsql'
as $$
DECLARE
    null_rows integer :=0;
BEGIN
    select count(id) into null_rows from products where count = 0;
    IF (null_rows > 0) then
        delete from products where count = 0;
    end if;

    RETURN null_rows;
END
$$;

select * from products;
call del_product_proc(9);
select del_product_fn();
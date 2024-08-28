--Используйте в своем курсоре опцию SCROLL, перейдите на последнюю запись в таблице,
--затем перейдите на 15 запись, с 15 на 7, а с 7 на 2 и затем на 1. Двигайтесь по курсору назад с помощью FETCH/MOVE .
BEGIN;
DECLARE
    cursor_products SCROLL cursor for
    select * from products;

FETCH LAST FROM cursor_products;
FETCH FIRST FROM cursor_products;

MOVE FORWARD 15 FROM cursor_products;

MOVE BACKWARD 8 FROM cursor_products;

MOVE BACKWARD 5 FROM cursor_products;

MOVE BACKWARD 1 FROM cursor_products;

CLOSE cursor_products;
COMMIT;
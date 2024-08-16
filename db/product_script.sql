create table product
(
    id    serial primary key,
    name  varchar(255),
    type_id integer,
    expired_date date,
    price float
);
create table type
(
    id   serial primary key,
    name varchar(255)
);
ALTER TABLE "product" ADD FOREIGN KEY ("type_id") REFERENCES "type" ("id");

insert into type (name) values
    ('СЫР');
insert into type (name) values
    ('МОЛОКО');
insert into type (name) values
    ('ВОДА');
insert into type (name) values
    ('САХАР');
insert into type (name) values
    ('МУКА');
insert into type (name) values
    ('МЯСО');

insert into product (name, type_id, expired_date, price) values
    ('мороженое','2','2024-01-01', 98);
insert into product (name, type_id, expired_date, price) values
    ('фруктовое мороженое','2','2024-01-09', 122);
insert into product (name, type_id, expired_date, price) values
    ('гауда','1','2025-01-01', 130);
insert into product (name, type_id, expired_date, price) values
    ('пармезан','1','2025-02-01', 200);
insert into product (name, type_id, expired_date, price) values
    ('лединец','4','2030-01-01', 50);
insert into product (name, type_id, expired_date, price) values
    ('архыз','3','2030-01-01', 130);
insert into product (name, type_id, expired_date, price) values
    ('пирожное','5','2024-06-01', 238);
insert into product (name, type_id, expired_date, price) values
    ('хлеб','5','2024-11-01', 55);
insert into product (name, type_id, expired_date, price) values
    ('свинина','6','2024-11-11', 340);
insert into product (name, type_id, expired_date, price) values
    ('курица','6','2024-11-02', 200);
insert into product (name, type_id, expired_date, price) values
    ('бананина','6','2024-10-10', 500);
insert into product (name, type_id, expired_date, price) values
    ('кролик','6','2024-10-10', 500);

--1. Написать запрос получение всех продуктов с типом "СЫР"
select p.* from type t join product p on t.id=p.type_id
where t.name = 'СЫР'

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
select p.* from product p where p.name like '%мороженое%'

--3. Написать запрос, который выводит все продукты, срок годности которых уже истек
select p.* from product p where p.expired_date < now()

--4. Написать запрос, который выводит самый дорогой продукт.
--Запрос должен быть универсальный и находить все продукты с максимальной ценой.
--Например, если в таблице есть продукт типа СЫР с ценой 200 и продукт типа МОЛОКО с ценой 200,
--и эта цена максимальная во всей таблице, то запрос должен вывести оба этих продукта.
select p.*, t.* from type t join product p on t.id=p.type_id
where p.price=(select max(price) from product)

--5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих.
--В виде имя_типа, количество
select t.name, count(p.id) from type t join product p on t.id=p.type_id
group by t.name

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.* from type t join product p on t.id=p.type_id
where t.name = 'СЫР' or  t.name = 'МОЛОКО'

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
--Под количеством подразумевается количество продуктов определенного типа.
--Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла",
--которые ему принадлежат, то количество продуктов типа "СЫР" будет 2.
select t.name, count(p.id) from type t join product p on t.id=p.type_id
group by t.name having count(p.id) < 10

--8. Вывести все продукты и их тип.
select p.name as "продукт", t.name as "тип" from type t join product p on t.id=p.type_id

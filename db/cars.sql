create table car_bodies
(
    id    serial primary key,
    name  varchar(255)
);

create table car_engines
(
    id    serial primary key,
    name  varchar(255)
);

create table car_transmissions
(
    id    serial primary key,
    name  varchar(255)
);

create table cars
(
    id    serial primary key,
    name  varchar(255),
    body_id integer,
    engine_id integer,
    transmission_id integer
);

ALTER TABLE "cars" ADD FOREIGN KEY ("body_id") REFERENCES "car_bodies" ("id");
ALTER TABLE "cars" ADD FOREIGN KEY ("engine_id") REFERENCES "car_engines" ("id");
ALTER TABLE "cars" ADD FOREIGN KEY ("transmission_id") REFERENCES "car_transmissions" ("id");

insert into car_bodies (name) values
    ('кабриолет');
insert into car_bodies (name) values
    ('седан');
insert into car_bodies (name) values
    ('хэтчбек');
insert into car_bodies (name) values
    ('пикап');
insert into car_bodies (name) values
    ('лифтбек');
insert into car_bodies (name) values
    ('грузовик');

insert into car_engines (name) values
    ('Бензиновый');
insert into car_engines (name) values
    ('Электрический');
insert into car_engines (name) values
    ('Дизельный');
insert into car_engines (name) values
    ('Газовый');
insert into car_engines (name) values
    ('Реактивный');

insert into car_transmissions (name) values
    ('Механическая');
insert into car_transmissions (name) values
    ('Роботизированная');
insert into car_transmissions (name) values
    ('Автоматическая');
insert into car_transmissions (name) values
    ('Бесступенчатая');
insert into car_transmissions (name) values
    ('Электрическая');
insert into car_transmissions (name) values
    ('Гидравлическая');

insert into cars (name,body_id,engine_id,transmission_id) values
    ('Вольво', 1,2,3);
insert into cars (name,body_id,engine_id,transmission_id) values
    ('Шкода', 2,4,1);
insert into cars (name,body_id,engine_id,transmission_id) values
    ('Ваз', 5,5,5);
insert into cars (name,body_id,engine_id,transmission_id) values
    ('Форд', 3,4,1);
insert into cars (name,body_id,engine_id,transmission_id) values
    ('Джили', 4,2,3);
insert into cars (name,body_id,engine_id,transmission_id) values
    ('Хавал', 5,3,3);
insert into cars (name,body_id,engine_id,transmission_id) values
    ('Порш', 1,4,1);

insert into cars (name,engine_id,transmission_id) values
    ('Москвич', 4,1);
insert into cars (name,body_id,transmission_id) values
    ('Тойота', 1,1);
insert into cars (name,body_id,engine_id) values
    ('Зикр', 1,4);
insert into cars (name) values
    ('Черри');

--Вывести список всех машин и все привязанные к ним детали. Нужно учесть,
--что каких-то деталей машина может и не содержать. В таком случае значение может
--быть null при выводе (например, название двигателя null);
--Пример "шапки" при выводе:
--id, car_name, body_name, engine_name, transmission_name
select c.id, c.name as "car_name", cb.name as "body_name",
       ce.name as "engine_name", ct.name as "transmission_name"
from
    cars c left join car_bodies cb on c.body_id = cb.id
           left join car_engines ce on c.engine_id = ce.id
           left join car_transmissions ct on c.transmission_id = ct.id;

--Вывести кузова, которые не используются НИ в одной машине.
--"Не используются" значит, что среди записей таблицы cars отсутствует внешние ключи,
select cb.name as "body_name"
from cars c
         right join car_bodies cb on c.body_id = cb.id
where c.body_id is null;

--Вывести двигатели, которые не используются НИ в одной машине, аналогично п.2;
select ce.name as "engine_name"
from cars c
         right join car_engines ce on c.engine_id = ce.id
where c.engine_id is null;

--Вывести коробки передач, которые не используются НИ в одной машине, аналогично п.2.
select ct.name as "transmission_name"
from cars c
         right join car_transmissions ct on c.transmission_id = ct.id
where c.transmission_id is null;

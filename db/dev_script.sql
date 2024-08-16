create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices (name, price) values
    ('phone', 30000);
insert into devices (name, price) values
    ('pad', 22000);
insert into devices (name, price) values
    ('joistik', 13000);
insert into devices (name, price) values
    ('watch', 16000);
insert into devices (name, price) values
    ('computer', 127000);
insert into devices (name, price) values
    ('tv', 56000);

insert into people (name) values
    ('Mike');
insert into people (name) values
    ('Serge');
insert into people (name) values
    ('Artem');
insert into people (name) values
    ('Kolya');
insert into people (name) values
    ('Roma');
insert into people (name) values
    ('Grisha');
insert into people (name) values
    ('Sveta');
insert into people (name) values
    ('Lena');

insert into devices_people ( people_id, device_id) values
    (1, 2);
insert into devices_people (people_id, device_id) values
    (1, 6);
insert into devices_people (people_id, device_id) values
    (1, 5);
insert into devices_people (people_id, device_id) values
    (2, 2);
insert into devices_people (people_id, device_id) values
    (2, 6);
insert into devices_people (people_id, device_id) values
    (2, 5);
insert into devices_people (people_id, device_id) values
    (3, 3);
insert into devices_people (people_id, device_id) values
    (4, 3);
insert into devices_people (people_id, device_id) values
    (4, 4);
insert into devices_people (people_id, device_id) values
    (5, 4);
insert into devices_people (people_id, device_id) values
    (6, 1);
insert into devices_people (people_id, device_id) values
    (6, 5);
insert into devices_people (people_id, device_id) values
    (7, 6);

--3. Используя агрегатные функции вывести среднюю цену устройств.
select  avg(d.price) as "avg_price" from
    devices d
        join devices_people dp on d.id = dp.device_id
        join people p on p.id = dp.people_id
--4. Используя группировку вывести для каждого человека среднюю цену его устройств.
select  p.name, avg(d.price) as "avg_price" from
    devices d
        join devices_people dp on d.id = dp.device_id
        join people p on p.id = dp.people_id
group by p.name
--5. Дополнить запрос п.4. условием, что средняя стоимость устройств должна быть больше 5000.
select  p.name, avg(d.price) as "avg_price" from
    devices d
        join devices_people dp on d.id = dp.device_id
        join people p on p.id = dp.people_id
group by p.name having avg(d.price) > 5000
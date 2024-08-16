insert into fauna (name, avg_age, discovery_date) values
    ('rat','9','1987-01-01');
insert into fauna (name, avg_age, discovery_date) values
    ('bear','15','1999-09-15');
insert into fauna (name, avg_age, discovery_date) values
    ('cat','11','2000-03-01');
insert into fauna (name, avg_age, discovery_date) values
    ('dog','13','1980-11-01');
insert into fauna (name, avg_age, discovery_date) values
    ('pig','7','1982-04-05');
insert into fauna (name, avg_age, discovery_date) values
    ('hors','16','1993-01-11');
insert into fauna (name, avg_age, discovery_date) values
    ('snake','4','1999-10-12');
insert into fauna (name, avg_age, discovery_date) values
    ('fish','3','2001-05-01');
insert into fauna (name, avg_age, discovery_date) values
    ('Leopard','7','2002-01-13');
insert into fauna (name, avg_age, discovery_date) values
    ('Wolf','9','2003-01-16');
insert into fauna (name, avg_age, discovery_date) values
    ('molusk','170000','1933-01-16');
insert into fauna (name, avg_age, discovery_date) values
    ('lizard','368654','1944-01-16');
insert into fauna (name, avg_age, discovery_date) values
    ('worm','19053','1900-04-16');
insert into fauna (name, avg_age) values
    ('fly','368654');
insert into fauna (name, avg_age) values
    ('mole','19053');

--1) Извлечение данных, у которых имя name содержит подстроку fish
select * from fauna where name like '%fish%'
--2) Извлечение данных, у которых сред. продолжительность жизни находится в диапазоне 10 000 и 21 000
select * from fauna where avg_age > 10000 and  avg_age < 21000
--3) Извлечение данных, у которых дата открытия не известна (null)
select * from fauna where discovery_date is null
--4) Извлечение данных видов, у которых дата открытия раньше 1950 года
select * from fauna where discovery_date < '1950-01-01'

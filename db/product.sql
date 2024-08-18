create table departments
(
    id    serial primary key,
    name  varchar(255)
);
create table employees
(
    id    serial primary key,
    name  varchar(255),
	dep_id integer
);
ALTER TABLE "employees" ADD FOREIGN KEY ("dep_id") REFERENCES "departments" ("id");

create table teens
(
    id    serial primary key,
    name  varchar(255),
	gender character
);

insert into departments (name) values
    ('Dep one');
insert into departments (name) values
    ('Dep two');
insert into departments (name) values
    ('Dep three');
insert into departments (name) values
    ('Dep four');
insert into departments (name) values
    ('Dep five');
insert into departments (name) values
    ('Dep six');

insert into employees (name, dep_id) values
    ('Менеджер 1', 1);
insert into employees (name, dep_id) values
    ('Шофер 1', 1);
insert into employees (name, dep_id) values
    ('Директор 1', 1);
insert into employees (name, dep_id) values
    ('Менеджер 2', 2);
insert into employees (name, dep_id) values
    ('Уборщик 2', 2);
insert into employees (name, dep_id) values
    ('Стажер 2', 2);
insert into employees (name, dep_id) values
    ('Менеджер 3', 3);
insert into employees (name, dep_id) values
    ('Шофер 3', 3);
insert into employees (name, dep_id) values
    ('Рекрутер 3', 3);
insert into employees (name, dep_id) values
    ('Менеджер 4', 4);
insert into employees (name, dep_id) values
    ('Программист 4', 4);
insert into employees (name) values
    ('Безработный');
insert into employees (name) values
    ('Рантье');
insert into employees (name) values
    ('Пенсионер');

insert into teens (name, gender) values
    ('Миша', 'М');
insert into teens (name, gender) values
    ('Вася', 'М');
insert into teens (name, gender) values
    ('Лена', 'Ж');
insert into teens (name, gender) values
    ('Катя', 'Ж');
insert into teens (name, gender) values
    ('Коля', 'М');
insert into teens (name, gender) values
    ('Дима', 'М');
insert into teens (name, gender) values
    ('Света', 'Ж');
insert into teens (name, gender) values
    ('Даша', 'Ж');

--2. Выполнить запросы с left, right, full, cross соединениями
select d.*, e.* from departments d left join employees e on d.id=e.dep_id

select d.*, e.* from departments d right join employees e on d.id=e.dep_id

select d.*, e.* from departments d full join employees e on d.id=e.dep_id

select d.*, e.* from departments d cross join employees e

--3. Используя left join найти департаменты, у которых нет работников
select d.*, e.* from departments d left join employees e on d.id=e.dep_id
where e.dep_id is null

--4. Используя left и right join написать запросы, которые давали бы
--одинаковый результат (порядок вывода колонок в эти запросах также должен быть идентичный).
select d.name, e.name from departments d left join employees e on d.id=e.dep_id
where e.dep_id is not null

select d.name, e.name from departments d right join employees e on d.id=e.dep_id
where d.id is not null

--5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
--Используя cross join составить все возможные разнополые пары.
select t.id, tt.id, t.name, tt.name from teens t cross join teens tt
where t.gender <> tt.gender and t.id < tt.id




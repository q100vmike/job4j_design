create table film (
                      id serial primary key,
                      name varchar(255),
                      director varchar(255),
                      premiere date
);
insert into film (name,director,premiere) values ('Predator', 'McTiernan', '1987-01-01');
insert into film (name,director,premiere) values ('Predator 2', 'Hopkins', '1990-01-01');
insert into film (name,director,premiere) values ('Predator 3', 'Xxxxx', '2018-01-01');
update film set director = 'Black' where name = 'Predator 3';
select * from film;
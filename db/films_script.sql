CREATE TABLE "film" (
                        "id" serial PRIMARY KEY,
                        "name" varchar(255),
                        "director_id" integer,
                        "premiere" date
);

CREATE TABLE "director" (
                            "id" serial PRIMARY KEY,
                            "name" varchar(255),
                            "birth_date" date
);

ALTER TABLE "film" ADD FOREIGN KEY ("director_id") REFERENCES "director" ("id");

insert into director (name,birth_date) values ( 'McTiernan', '1950-01-01');
insert into director (name,birth_date) values ( 'Black', '1955-01-01');
insert into director (name,birth_date) values ('Hopkins', '1958-01-01');
insert into director (name,birth_date) values ('Coppola', '1965-01-01');

insert into film (name,director_id,premiere) values ('Predator', '1', '1987-01-01');
insert into film (name,director_id,premiere) values ('Predator 2', '3', '1990-01-01');
insert into film (name,director_id,premiere) values ('Predator 3', '2', '2018-01-01');

select f.name as "фильм", d.name as "режиссер"
from film f join director d on f.director_id = d.id;

select f.name as "фильм", f.premiere as "дата премьеры", d.name as "режиссер"
from film f join director d on f.director_id = d.id
where d.name = 'Black';

select f.name as "фильм", f.premiere as "дата премьеры", d.name as "режиссер"
from film f join director d on f.director_id = d.id
where d.name = 'Black' or d.name = 'Hopkins';
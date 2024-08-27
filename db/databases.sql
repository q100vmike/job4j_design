CREATE TABLE "databases" (
                             "id" serial PRIMARY KEY,
                             "name" varchar(255),
                             "availability" varchar(1),
                             "tables" integer
);

insert into databases (name,availability,tables) values ( 'mssql', 'Y', 100);
insert into databases (name,availability,tables) values ( 'posgresql', 'Y', 1000);
insert into databases (name,availability,tables) values ( 'oracle', 'Y', 5555);
insert into databases (name,availability,tables) values ( 'excel', 'N', 19);
insert into databases (name,availability,tables) values ( 'acess', 'Y', 754);
insert into databases (name,availability,tables) values ( 'csv', 'Y', 0);
insert into databases (name,availability,tables) values ( 'text', 'Y', 0);


begin transaction;
set session transaction isolation level serializable;
select sum(tables) from databases;
update databases set tables = 1000 where name = 'csv'
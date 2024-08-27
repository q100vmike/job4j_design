CREATE TABLE IF NOT EXISTS "databases" (
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
delete from databases where name = 'posgresql' or name = 'oracle';
savepoint one_delete;
update databases set tables = 3000 where name = 'text';
insert into databases (name,availability,tables) values ( 'h2', 'N', 2999);
savepoint two_upd;
drop table databases;
select * from databases;

rollback to two_upd;
select * from databases;

rollback to one_delete;
select * from databases;

rollback transaction;
select * from databases;
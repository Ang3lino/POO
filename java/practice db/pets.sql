
create database if not exists pets;
use pets;

create table if not exists dogs(
    name varchar(32),
    breed varchar(32), 
    age int unsigned,
    gender varchar(8)
);

insert into dogs(name, breed, age, gender) values("doki", "pikacho", 8, "macho");
insert into dogs(name, breed, age, gender) values("mamut", "gyrados", 8, "macho");
insert into dogs(name, breed, age, gender) values("firulais", "bulbasaur", 5, "macho");
insert into dogs(name, breed, age, gender) values("goyo", "squirtle", 8, "hembra");
insert into dogs(name, breed, age, gender) values("susuzi", "raichu", 9, "hembra");
insert into dogs(name, breed, age, gender) values("???", "missingno", 3, "macho");

select d.* from dogs d order by d.name;

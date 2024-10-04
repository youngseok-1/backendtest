create user ohgiraffers@'%' identified by 'ohgiraffers';

create database drinkdb;

grant all privileges on drinkdb.* to ohgiraffers@'%';

show grants for ohgiraffers@'%';
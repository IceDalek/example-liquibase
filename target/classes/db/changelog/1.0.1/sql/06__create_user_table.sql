create sequence if not exists user_seq start 3;
create table users(
id int primary key,
password varchar(500),
user_name varchar (50),
country varchar (50)
)
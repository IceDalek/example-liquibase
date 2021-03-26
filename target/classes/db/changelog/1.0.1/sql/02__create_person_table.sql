create sequence if not exists person_seq start 1;
create table person
(
    person_id   bigint default nextval('person_seq'::regclass) not null
        constraint person_pk
            primary key,
    first_name  varchar(256)                                   not null,
    last_name   varchar(256)                                   not null,
    middle_name varchar(256)                                   not null,
    birth_date  date,
    gender      varchar(100)                                   not null
);

comment on table person is 'Инфорамция о человеке';

comment on column person.person_id is 'идентификатор.';

comment on column person.first_name is 'Имя';

comment on column person.last_name is 'Фамилия';

comment on column person.middle_name is 'Фамилия';

comment on column person.birth_date is 'Дата рождения';

comment on column person.gender is 'Пол';

--insert into person(person_id, first_name, last_name, middle_name, birth_date, gender) V
,
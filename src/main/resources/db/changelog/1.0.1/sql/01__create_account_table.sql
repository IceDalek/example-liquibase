create sequence if not exists account_entity_liquibase_seq start 1;

CREATE TABLE if not exists account_entity_liquibase
(
    user_id  bigint       not null default nextval('account_entity_liquibase_seq' :: regclass),
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(50)  NOT NULL,
    country  VARCHAR(355) NOT NULL
);

alter table account_entity_liquibase
    add constraint account_entity_liquibase_pk primary key (user_id);

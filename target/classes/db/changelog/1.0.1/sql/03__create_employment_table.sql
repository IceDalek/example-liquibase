create sequence if not exists employment_seq start 1;
create table employment
(
    employment_id        bigint default nextval('employment_seq'::regclass) not null
        constraint employment_pk
            primary key,
    version              integer                                            not null,
    start_dt             date,
    end_dt               date,
    work_type_id         bigint,
    organization_name    varchar(256),
    organization_address text,
    position_name        varchar(256),
    person_id            bigint
);

comment on table employment is 'запись о трудовой деятельности.';

comment on column employment.employment_id is 'идентификатор.';

comment on column employment.version is 'реализация оптимистической блокировки';

comment on column employment.start_dt is 'дата начала трудовой деятельности';

comment on column employment.end_dt is 'дата окончания трудовой деятельности';

comment on column employment.work_type_id is 'тип деятельности';

comment on column employment.organization_name is 'наименование организации.';

comment on column employment.organization_address is 'адрес организации.';

alter table employment
    add constraint person_id_fk foreign key (person_id) references person (person_id);

   insert into employment(employment_id, version, start_dt, end_dt, work_type_id, organization_name, organization_address, position_name, person_id) VALUES
(1, 1, '2019-01-01', '2020-01-01', 1, 'VTB', 'Gde-to tam', 'team lead', 1);


--liquibase formatted sql
--changeset tarancorp:1

create table if not exists employee(
    id SERIAL PRIMARY KEY NOT NULL,
    name varchar(50) NOT NULL,
    surname varchar(50) NOT NULL,
    position varchar(50) NOT NULL,
    phone_number varchar(20),
    birth_date date NOT NULL,
    employment_date date NOT NULL,
    payment decimal
);

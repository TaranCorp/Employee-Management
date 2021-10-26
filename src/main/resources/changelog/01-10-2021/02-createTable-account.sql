--liquibase formatted sql
--changeset tarancorp:1

create table if not exists account (
    id SERIAL PRIMARY KEY NOT NULL,
    login varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    email varchar(50) NOT NULL
);
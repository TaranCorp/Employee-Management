--liquibase formatted sql
--changeset tarancorp:1

create table if not exists task (
    id SERIAL PRIMARY KEY,
    name varchar(255),
    created timestamp
);
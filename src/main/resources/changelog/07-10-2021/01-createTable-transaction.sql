--liquibase formatted sql
--changeset tarancorp:1

create table if not exists transaction(
    id SERIAL NOT NULL PRIMARY KEY,
    created timestamp,
    amount decimal
);
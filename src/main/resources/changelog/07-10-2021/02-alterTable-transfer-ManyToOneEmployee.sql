--liquibase formatted sql
--changeset tarancorp:1

alter table transaction
    add column employee_id int not null
--liquibase formatted sql
--changeset tarancorp:1

alter table account
    add column employee_id int
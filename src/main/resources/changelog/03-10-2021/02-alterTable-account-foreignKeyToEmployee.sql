--liquibase formatted sql
--changeset tarancorp:1

alter table account
    add constraint fk_employee_account
    foreign key (employee_id) references
    employee(id)
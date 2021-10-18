--liquibase formatted sql
--changeset tarancorp:1

alter table transaction
    add constraint transaction_employee_id
    foreign key (employee_id) references employee(id)
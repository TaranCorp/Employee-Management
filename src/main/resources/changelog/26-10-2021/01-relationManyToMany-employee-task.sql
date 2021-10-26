--liquibase formatted sql
--changeset tarancorp:1

create table if not exists todo_employee_task (
    employee_id bigint not null,
    task_id bigint not null,

    unique (employee_id, task_id)
);

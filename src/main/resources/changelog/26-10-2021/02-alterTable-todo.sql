--liquibase formatted sql
--changeset tarancorp:1


alter table todo_employee_task
    add constraint task_id
    foreign key (employee_id)
    references employee(id)

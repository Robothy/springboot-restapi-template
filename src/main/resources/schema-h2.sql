create table if not exists DEPARTMENT
(
    ID          int primary key,
    NAME        varchar2(128),
    CREATE_TIME timestamp,
    UPDATE_TIME timestamp
);

create table if not exists EMPLOYEE
(
    ID            int primary key,
    DEPARTMENT_ID int,
    NAME          varchar2(128),
    SALARY        numeric(20, 2),
    CREATE_TIME   timestamp,
    UPDATE_TIME   timestamp
);
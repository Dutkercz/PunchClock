create table employee (
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    password varchar(100) not null,
    role varchar(100) not null,
    active tinyint(1) not null default 1,

     primary key(id)
);

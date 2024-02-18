create table contact_person
(
    id           bigint       not null auto_increment PRIMARY KEY,
    name         varchar(255) not null,
    position     varchar(20)  not null,
    email        varchar(255) not null,
    phone_number varchar(255),
    customer_id  bigint       not null,
    constraint fk_contact_person_customer foreign key (customer_id) references customer (id)
);
create table contact_person
(
    id           bigint       not null auto_increment PRIMARY KEY,
    name         varchar(255) not null,
    position     varchar(20)  not null,
    email        varchar(255) not null,
    phone_number varchar(255),
    company_id   bigint       not null,
    constraint fk_contact_person_company foreign key (company_id) references company (id)
);
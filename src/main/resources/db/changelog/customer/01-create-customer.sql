create table customer(
    id            bigint       not null auto_increment PRIMARY KEY,
    name          varchar(255) not null,
    postCode      varchar(6)   not null,
    street        varchar(255) not null,
    province      varchar(255),
    country       varchar(255) not null,
    postOffice    varchar(255),
    registerID    varchar(20)  not null,
    taxID         varchar(20)  not null,
    vatRegistered boolean,
    vatEuEnabled  boolean
);
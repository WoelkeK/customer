create table payment_details
(
    id             bigint      not null auto_increment PRIMARY KEY,
    payment_method varchar(50) not null,
    payment_terms  varchar(50) not null,
    currency       varchar(3)  not null,
    company_id     bigint,
    constraint fk_payment_details_company foreign key (company_id) references company (id)

);
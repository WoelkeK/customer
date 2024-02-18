create table payment_details
(
    id             bigint      not null auto_increment PRIMARY KEY,
    payment_method varchar(50) not null,
    payment_terms  varchar(50) not null,
    currency       varchar(3)  not null,
    customer_id    bigint,
    constraint fk_payment_details_customer foreign key (customer_id) references customer(id)

);
create table bank_details
(
    id             bigint       not null auto_increment PRIMARY KEY,
    account_number varchar(255) not null,
    bank_name      varchar(50)  not null,
    notes          varchar(255),
    notesEnabled   boolean,
    customer_id    bigint       not null,
    constraint fk_bank_details_customer foreign key (customer_id) references customer (id)

);
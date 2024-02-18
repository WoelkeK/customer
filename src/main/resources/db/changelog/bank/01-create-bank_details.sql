create table bank_details
(
    id             bigint       not null auto_increment PRIMARY KEY,
    account_number varchar(255) not null,
    bank_name      varchar(50)  not null,
    notes          varchar(255),
    notesEnabled   boolean,
    company_id     bigint       not null,
    constraint fk_bank_details_company foreign key (company_id) references company (id)

);
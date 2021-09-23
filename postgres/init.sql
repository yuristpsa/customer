create database customer;

create user customer
with password 'customer_muvz';
grant all privileges on database customer to customer;
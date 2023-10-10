create table users (
    id int generated always as identity,
    name varchar(150),
    primary key (id)
)
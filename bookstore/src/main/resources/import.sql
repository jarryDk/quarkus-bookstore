
create sequence hibernate_sequence if not exists start 1 increment 1
    
create table Author if not exists(
    id int8 not null,
    name varchar(255),
    primary key (id)
); 

create table Book if not exists(
    id int8 not null,
    authorId int8 not null,
    isbn varchar(255) not null,
    publisherId int8 not null,
    title varchar(255) not null,
    primary key (id)
);

create table Publisher if not exists(
    id int8 not null,
    name varchar(255),
    primary key (id)
);

select 
    nextval ('hibernate_sequence')
insert 
    into
        Author     
           (name, id) 
    values
        ('Peter Hansen', 1);

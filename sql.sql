alter table users
    add email VARCHAR(40) not null;

alter table users
    add password VARCHAR(120) not null;

alter table users
    add displayName VARCHAR(20) null;

alter table users
    add options json null comment 'full user profile';

alter table users
    add created_at date null;

alter table users
    add deleted_at date null;

alter table users
drop primary key;

alter table users
    add constraint users_pk
        primary key (id);

alter table users
drop key users_pk;
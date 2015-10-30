create table users(
id bigint not null generated always as identity primary key,
username varchar(50) not null unique,
password varchar(255) not null,
created timestamp not null,
last_login timestamp
);

create table roles
(
id bigint not null generated always as identity primary key,
rolename varchar(50) not null unique
);

create table users_roles
(
user_id bigint not null references users(id),
role_id bigint not null references roles(id),
primary key (user_id, role_id)
);

create table tasks
(
id bigint not null generated always as identity primary key,
description varchar(4096) not null,
completed timestamp
);

create view securities (username, password, rolename) 
as select u.username, u.password, r.rolename from users u join users_roles ur on u.id = ur.user_id join roles r on ur.role_id = r.id;

insert into users (username, password) values ('good', 'good');
insert into users (username, password) values ('bad', 'bad');

insert into roles (rolename) values ('allowed');
insert into roles (rolename) values ('denied');

insert into users_roles (user_id, role_id) values ((select id from users where username = 'good'), (select id from roles where rolename = 'allowed'))
insert into users_roles (user_id, role_id) values ((select id from users where username = 'bad'), (select id from roles where rolename = 'denied'))

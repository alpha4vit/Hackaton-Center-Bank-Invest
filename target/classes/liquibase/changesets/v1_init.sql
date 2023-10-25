create table if not exists users
(
    id bigint generated by default as identity primary key,
    username varchar not null unique,
    password varchar not null,
    email varchar not null unique,
    phone_number varchar(25),
    enabled bool not null default false
);

create table if not exists users_rating(
    user_id bigint references users(id) primary key,
    status varchar(255) not null,
    points bigint default 0
);

create table if not exists users_roles(
    user_id bigint references users(id) not null,
    role varchar(255) not null,
    primary key (user_id, role),
    constraint fk_users_roles_users foreign key (user_id) references users(id) on delete cascade on update no action
);

create table if not exists address(
    id bigint generated by default as identity primary key,
    username varchar not null,
    city varchar not null,
    street varchar not null,
    contact_number varchar not null,
    working_hours varchar not null
);

create table if not exists landmarks(
    id bigint generated by default as identity primary key,
    title varchar not null,
    description varchar not null,
    address_id bigint references address(id) not null,
    total_stars decimal not null,
    review_counter int not null,
    rating decimal
);

-- create table if not exists reviews_event
-- (
--     id       bigint generated by default as identity primary key,
--     title    varchar(50)                   not null,
--     message  varchar(400),
--     stars    int default 0,
--     event_id bigint references events (id) not null
-- );

create table if not exists reviews_landmark(
    id bigint generated by default as identity,
    title    varchar(50)                   not null,
    message  varchar(400),
    stars    int default 0,
    landmark_id bigint references landmarks (id) not null
);
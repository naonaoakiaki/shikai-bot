CREATE TABLE if not exists USER (
    user_id int primary key auto_increment
    ,name varchar(10) NOT NULL
    ,birthday varchar(8) NOT NULL
    ,deleted varchar(1) NOT NULL
);

create table user(
    id int(5) primary key auto_increment,
    name varchar(100) not null,
    username varchar(50) not null,
    password varchar(50) not null,
    email varchar(50) not null unique
)Engine=InnoDB;
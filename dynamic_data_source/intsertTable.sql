create table read_datasource.read_user
(
    user_id   int auto_increment comment '用户ID'
        primary key,
    user_name varchar(50) null comment '用户名'
)
    comment '用户表';

create table write_datasource.write_user
(
    user_id   int auto_increment comment '用户ID'
        primary key,
    user_name varchar(50) null comment '用户名'
)
    comment '用户表';


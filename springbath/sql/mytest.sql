-- 源数据库

CREATE database if NOT EXISTS `mytest` default character set utf8mb4 collate utf8mb4_general_ci;
use `mytest`;

-- 创建user表
CREATE TABLE `test_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '姓名',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `title` varchar(32) DEFAULT NULL COMMENT '职称职别',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `gender` varchar(32) DEFAULT NULL COMMENT '性别',
  `date_of_birth` date DEFAULT NULL COMMENT '出生时间',
  `sys_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sys_create_user` varchar(255) DEFAULT NULL,
  `sys_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sys_update_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7000 DEFAULT CHARSET=utf8;

create table quartz_job
(
    jobId          varchar(50)  not null,
    cronExpression varchar(50)  null comment 'cron表达式',
    description    varchar(100) null comment '描述',
    beanName       varchar(50)  null comment '任务执行时调用哪个类的方法 包名+类名，完全限定名',
    triggerName    varchar(50)  null comment 'triggerName',
    jobStatus      int          null comment '任务状态',
    jobName        varchar(50)  null comment '任务名',
    groupName        varchar(50)  null comment '组名',
    constraint quartz_config_id_uindex
        unique (jobid)
);

alter table quartz_job
    add primary key (jobid);
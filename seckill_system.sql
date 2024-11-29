-- 创建数据库
create database seckill_system;

-- 使用数据库
use seckill_system;

-- 用户表
create table user (
                      id int unsigned primary key auto_increment comment 'ID',
                      username varchar(20) not null unique comment '用户名',
                      password varchar(32)  comment '密码',
                      nickname varchar(10)  default '' comment '昵称',
                      email varchar(128) default '' comment '邮箱',
                      user_pic varchar(128) default '' comment '头像',
                      create_time datetime not null comment '创建时间',
                      update_time datetime not null comment '修改时间'
) comment '用户表';

-- 商品表
CREATE TABLE product (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品ID',
    name VARCHAR(100) NOT NULL COMMENT '商品名称',
    title VARCHAR(200) DEFAULT NULL COMMENT '商品标题',
    img VARCHAR(200) DEFAULT NULL COMMENT '商品图片URL',
    detail TEXT COMMENT '商品详情描述',
    price DECIMAL(10,2) NOT NULL COMMENT '商品价格',
    stock INT DEFAULT 0 COMMENT '库存数量，-1表示无限制',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

-- 插入商品表测试数据
INSERT INTO product (name, title, img, detail, price, stock) VALUES
('商品1', '商品标题1', 'img1.jpg', '商品详情描述1', 100.00, 10),
('商品2', '商品标题2', 'img2.jpg', '商品详情描述2', 200.00, 20),
('商品3', '商品标题3', 'img3.jpg', '商品详情描述3', 300.00, 30),
('商品4', '商品标题4', 'img4.jpg', '商品详情描述4', 400.00, 40),
('商品5', '商品标题5', 'img5.jpg', '商品详情描述5', 500.00, 50),
('商品6', '商品标题6', 'img6.jpg', '商品详情描述6', 600.00, 60),
('商品7', '商品标题7', 'img7.jpg', '商品详情描述7', 700.00, 70),
('商品8', '商品标题8', 'img8.jpg', '商品详情描述8', 800.00, 80),
('商品9', '商品标题9', 'img9.jpg', '商品详情描述9', 900.00, 90),
('商品10', '商品标题10', 'img10.jpg', '商品详情描述10', 1000.00, 100);
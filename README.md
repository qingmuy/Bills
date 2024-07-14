# Bills



## 第一天



### 导入Maven依赖：

lombok、Mybatis-plus、jwt、MySql驱动。



### 数据库设计

| 数据表名 | 中文名称   |
| -------- | ---------- |
| user     | 用户表     |
| bill     | 账单表     |
| billtype | 账单类型表 |



#### 用户表设计

| 字段名      | 数据类型    | 说明     | 备注           |
| ----------- | ----------- | -------- | -------------- |
| id          | bigint      | 主键     | 自增           |
| account     | varchar(16) | 账号     | 唯一           |
| username    | varchar(16) | 用户名   | 分配，可修改   |
| password    | varchar(32) | 密码     | 不为空         |
| phone       | varchar(11) | 手机号   | 不为空         |
| create_time | datetime    | 创建时间 | 不为空         |
| deleted     | int         | 逻辑删除 | 0未删除，1删除 |



#### 账单表设计

| 字段名      | 数据类型      | 说明         | 备注   |
| ----------- | ------------- | ------------ | ------ |
| id          | bigint        | 主键         | 自增   |
| bill-type   | bigint        | 账单类别     | 不为空 |
| bill-time   | datetime      | 账单产生时间 | 不为空 |
| type        | tinyint(1)    | 收支类别     | 不为空 |
| pay_method  | int           | 支付方式     | 枚举   |
| amount      | decimal(10,2) | 支付金额     |        |
| remark      | varchar(255)  | 备注         | 默认空 |
| payee       | varchar(25)   | 收款方       | 默认空 |
| create_user | bigint        | 创建者       | 不为空 |
| update_time | datetime      | 修改时间     | 默认空 |



#### 账单类型表

| 字段名   | 数据类型    | 说明     | 备注 |
| -------- | ----------- | -------- | ---- |
| id       | bigint      | 主键     | 自增 |
| billtype | varchar(10) | 账单类别 |      |



## 第二天

采用boot3工程，引入若干依赖：jwt与knife4j

使用MyBatisX自动生成各个层级，完成了登录注册功能。使用jwt对密码进行加密储存。



## 第三天

完成逻辑删除的增添，修复了逻辑删除字段没有默认值的问题。



## 第四天

账单的增删改查。

配置了全局异常处理。



## 第五天

学习了拦截器，配置了拦截器，完善了jjwt的使用，完善了增删查改功能，完善了全局异常处理机制。

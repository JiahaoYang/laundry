create table clothes
(
  clothes_id   bigint auto_increment
    primary key,
  clothes_name varchar(50)  null,
  brand        varchar(20)  null,
  color        varchar(10)  null,
  flaw         varchar(100) null
);

create table compensate_record
(
  compensate_id     bigint auto_increment
    primary key,
  voucher_detail_id bigint                             null,
  user_id           bigint                             null,
  compensate_date   datetime default CURRENT_TIMESTAMP null,
  compensate_reason varchar(255)                       null,
  constraint user_id
    unique (user_id)
);

create table info
(
  info_id     bigint auto_increment
    primary key,
  name        varchar(50)  not null,
  description varchar(100) null,
  price       double       null
);

create table recharge_record
(
  recharge_id   bigint auto_increment
    primary key,
  user_id       bigint                             not null,
  money         double                             null,
  recharge_date datetime default CURRENT_TIMESTAMP null,
  constraint user_id
    unique (user_id)
);

create table rewash_record
(
  rewash_id         bigint auto_increment
    primary key,
  voucher_detail_id bigint       null,
  user_id           bigint       null,
  rewash_date       datetime     null,
  take_date         datetime     null,
  rewash_reason     varchar(255) null,
  constraint user_id
    unique (user_id)
);

create table user
(
  user_id       bigint auto_increment
    primary key,
  username      varchar(30)                           null,
  password      varchar(100)                          not null,
  user_type     varchar(10) default '会员'              not null,
  gender        varchar(5)                            null,
  phone         varchar(11)                           null,
  address       varchar(100)                          null,
  balance       double      default 0                 null,
  total_consume double      default 0                 null,
  consume_times int         default 0                 null,
  register_date datetime    default CURRENT_TIMESTAMP not null,
  constraint user_username_uindex
    unique (username),
  constraint username
    unique (username)
);

create table voucher
(
  voucher_id bigint auto_increment
    primary key,
  get_date   datetime    default CURRENT_TIMESTAMP null,
  take_date  datetime                              null,
  price      double                                null,
  state      varchar(20) default '正在洗衣'            null,
  user_id    bigint                                null,
  comment    varchar(255)                          null,
  constraint user_id
    unique (user_id)
);

create table voucher_detail
(
  voucher_detail_id bigint auto_increment
    primary key,
  voucher_id        bigint       null,
  clothes_id        bigint       null,
  server_name       varchar(20)  null,
  is_taken          varchar(5)   null,
  is_rewash         varchar(5)   null,
  is_compensate     varchar(5)   null,
  comment           varchar(255) null,
  wash_price        double       null
);


create table user
(
	user_id bigint auto_increment,
	username varchar(30) null,
	password varchar(20) not null,
	user_type varchar(10) default '会员' not null,
	gender varchar(5) null,
	phone varchar(11) null,
	address varchar(100) null,
	balance double default 0 not null,
	total_consume double default 0,
	consume_times int default 0,
	register_date datetime default now() not null,
	constraint user_pk
		primary key (user_id)
);

create unique index user_username_uindex
	on user (username);

alter table user
	add constraint username
		unique (username);


create table clothes
(
	clothes_id bigint auto_increment,
	clothes_name varchar(50) null,
	server_name varchar(20) null,
	wash_price double null,
	brand varchar(20) null,
	color varchar(10) null,
	flaw varchar(100) null,
	constraint clothes_pk
	primary key (clothes_id)
);


create table compensate_record
(
	compensate_id bigint auto_increment,
	voucher_detail_id bigint null,
	user_id bigint null,
	compensate_date datetime default now() null,
	compensate_reason varchar(255) null,
	constraint compensate_record_pk
		primary key (compensate_id),
	constraint user_id
		unique (user_id)
);


create table recharge_record
(
	recharge_id bigint auto_increment,
	user_id bigint not null,
	money double null,
	recharge_date datetime default now() null,
	constraint recharge_record_pk
		primary key (recharge_id),
	constraint user_id
		unique (user_id)
);

create table voucher
(
	voucher_id bigint auto_increment,
	get_date datetime default now() null,
	take_date datetime null,
	price double null,
	state varchar(20) null,
	user_id bigint null,
	comment varchar(255) null,
	constraint voucher_pk
		primary key (voucher_id),
	constraint user_id
		unique (user_id)
);


create table voucher_detail
(
	voucher_detail_id bigint auto_increment,
	voucher_id bigint null,
	clothes_id bigint null,
	clothes_amount int null,
	is_taken varchar(5) null,
	is_rewash varchar(5) null,
	is_compensate varchar(5) null,
	comment varchar(255) null,
	constraint voucher_detail_pk
		primary key (voucher_detail_id),
	constraint voucher_id
		unique (voucher_id)
);


create table rewash_record
(
	rewash_id bigint auto_increment,
	voucher_detail_id bigint null,
	user_id bigint null,
	rewash_date datetime null,
	take_date datetime null,
	rewash_reason varchar(255) null,
	constraint rewash_record_pk
		primary key (rewash_id),
	constraint user_id
		unique (user_id)
);


create table info
(
	info_id bigint auto_increment,
	name varchar(50) not null,
	description varchar(100) null,
	price double null,
	constraint info_pk
		primary key (info_id)
);







create table user_information
(
	id_num int not null primary key auto_increment,
	id varchar(30) not null,
	pw varchar(30) not null,
	name varchar(60) not null,
	phone_number varchar(100) not null default "000-000-0000",
	address varchar(255) not null default "address",
	Date date not null default now(),
	self_instruction text not null default "instruction"
);
create table menu
(
	menu_num int not null primary key auto_increment,
	menu_name varchar(60) not null
);
create table post
(
	post_num int not null primary key auto_increment,
	id_num int not null,
	menu_num int not null,
	post_name varchar(100) not null,
	Date date default now() not null,
	foreign key(id_num) references user_information(id_num) on delete cascade on update cascade,
	foreign key(menu_num)
	references menu(menu_num) on delete cascade on update cascade
);
create table context
(
	context_num int not null primary key auto_increment, 
	post_num int not null,
	id_num int not null,
	menu_num int not null,
	context text,
	foreign key(id_num) references user_information(id_num) on delete cascade on update cascade,
	foreign key(menu_num)
	references menu(menu_num) on delete cascade on update cascade,
	foreign key(post_num)
	references post(post_num) on delete cascade on update cascade);

create table comment
(
	comment_num int not null primary key auto_increment,
	context_num int not null, 
	post_num int not null,
	id_num int not null,
	menu_num int not null,
	Date date default now() not null,
	context text,
	foreign key(id_num) references user_information(id_num) on delete cascade on update cascade,
	foreign key(menu_num)
	references menu(menu_num) on delete cascade on update cascade,
	foreign key(post_num)
	references post(post_num) on delete cascade on update cascade,
	foreign key(context_num)
	references context(context_num) on delete cascade on update cascade
);

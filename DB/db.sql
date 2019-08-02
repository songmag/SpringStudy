
create table post
(
	post_num int not null primary key,
	id_num int not null,
	menu_num int not null,
	post_name varchar(100) not null,
	date date,
	foreign key(id_num) references identity_information(id_num) on delete cascade on update cascade,
	foreign key(menu_num)
	references menu(menu_num) on delete cascade on update cascade
	
);

create table context
(
	context_num int not null primary key,
	post_num int not null,
	id_num int not null,
	menu_num int not null,
	context text,
	
	foreign key(id_num) references identity_information(id_num) on delete cascade on update cascade,
	foreign key(menu_num)
	references menu(menu_num) on delete cascade on update cascade,
	foreign key(post_num)
	references post(post_num) on delete cascade on update cascade);

create table comment
(

	comment_num int not null primary key,
	context_num int not null, 
	post_num int not null,
	id_num int not null,
	menu_num int not null,

	foreign key(id_num) references identity_information(id_num) on delete cascade on update cascade,
	foreign key(menu_num)
	references menu(menu_num) on delete cascade on update cascade,
	foreign key(post_num)
	references post(post_num) on delete cascade on update cascade,
	foreign key(context_num)
	references context(context_num) on delete cascade on update cascade
);

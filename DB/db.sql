drop table comment;
drop table context;
drop table post;
drop table menu;
drop table user_information;

create table user_information
(
	id_num int not null auto_increment,
	id varchar(30) not null,
	pw varchar(30) not null,
	name varchar(60) not null,
	phone_number varchar(100) default "000-000-0000",
	address varchar(255)  default "address",
	sign_Date date default now(),
	self_instruction text default "instruction",
	primary key (id_num,id)
);
create table menu
(
	menu_num int not null auto_increment,
	menu_name varchar(60) not null,
	primary key (menu_num,menu_name)
);
create table post
(
	post_num int not null primary key auto_increment,
	id_num int not null,
	menu_num int not null,
	post_name varchar(100) not null,
	post_Date date default now(),
	post_contents text default 'contents',
	thumbnail varchar(255) default '/img/thumbnail.png',
	
	foreign key(id_num) references user_information(id_num) on delete cascade on update cascade,
	foreign key(menu_num)
	references menu(menu_num) on delete cascade on update cascade

);
create table comment
(
	comment_num int not null primary key auto_increment,
	post_num int not null,
	id_num int not null,
	comment_Date date default now(),
	context text,
	foreign key(id_num) references user_information(id_num) on delete cascade on update cascade,
	foreign key(post_num)
	references post(post_num) on delete cascade on update cascade
);
-- 보안을 위해 뷰를 만들어놓음
CREATE VIEW USER_VIEW AS
SELECT ID_NUM,ID,NAME,PHONE_NUMBER,ADDRESS,SELF_INSTRUCTION FROM USER_INFORMATION;

CREATE VIEW EACH_MENU AS 
SELECT MENU.MENU_NAME,POST.POST_NAME,POST.THUMBNAIL,POST.POST_CONTENTS,POST.POST_DATE FROM POST 
INNER JOIN MENU ON POST.MENU_NUM = MENU.MENU_NUM;

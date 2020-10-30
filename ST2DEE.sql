create database if not exists ST2EEDB;

use ST2EEDB;
drop table if exists tutor;
create table tutor (
    t_id int(10) primary key auto_increment not null comment 'tutor id',
    t_name varchar(20) not null comment 'tutor name',
     username varchar(20) not null unique comment 'username',
      password varchar(20) not null comment 'login password'
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

drop table if exists student;
create table student (
                         student_id int(10) primary key auto_increment not null comment 'student id',
                         student_group varchar(10) not null comment 'group',
                         first_name varchar(20) not null comment 'first name',
                         last_name varchar(20) not null comment 'last name',
                         start_date timestamp not null default now() comment 'start date',
                         end_date timestamp not null default now() comment 'end date',
                         company_name varchar(20) not null comment 'company name',
                         charger varchar(20) not null comment 'company charger name',
                         address varchar(50) not null comment 'company address',
                         note_tech int(10) comment 'note tech',
                         note_com int(10) comment 'note company',
                         description varchar(300) comment 'description of mission',
                         comment varchar(300) comment 'comment',
                         cdc boolean not null default false comment 'CdC',
                         fv boolean not null  default false comment 'fiche visite',
                         fee boolean not null  default false comment 'fiche eval entr',
                         sw boolean not null  default false comment 'sondage web',
                         rr boolean not null  default false comment 'rapport rendu',
                         sout boolean not null  default false comment 'sout.',
                         plan boolean not null  default false comment 'viste planif.',
                         fait boolean not null  default false comment 'visit faite',
                         t_id int(10) not null  comment 'foreign key',
                         CONSTRAINT `fk_award_shop` FOREIGN KEY (`t_id`) REFERENCES `tutor` (`t_id`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

insert into tutor(t_name,username,password) values ('JAMES','james',0000),('LUC','luc',0000);
insert into student(first_name, last_name, student_group,company_name, charger, address, t_id) values ('TAYLOR','SWIFT','L3','UNIVERSAL MUSIC','BEYONCE','1 ROAD OF USA',1),
                                                                                        ('WILL','SMITH','M1','SONY PRODUCTION','TOM','2 ROAD OF USA',1),
                                                                                        ('DONALD','TRUMP','M2','WHITE HOUSE','IVANKA','3 ROAD OF USA',1),
                                                                                        ('JAY','Z','L3','DISNEY','ADM','4 ROAD OF USA',2),
                                                                                        ('JUSTEN','BIEBER','M2','WARNER MUSIC','LUC','4 ROAD OF USA',2),
                                                                                        ('TOM','CRUISE','M1','Black Screen','Peter','5 ROAD OF USA',2),
                                                                                        ('STEVEN','JOBS','M2','APPLE','LUCK','5 ROAD OF USA',2),
                                                                                        ('BILL','GATES','M1','MICROSOFT','MELINDA','6 ROAD OF USA',2);

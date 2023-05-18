CREATE SCHEMA test_making_system;

USE test_making_system;


create table course
(id_COURSE int NOT NULL ,
 name_COURSE varchar (50),
 PRIMARY KEY (id_COURSE))
 ENGINE = InnoDB;


CREATE TABLE Tests
(Test_ID INT NOT NULL,
number_Of_Questions int,
Type_Test char,
date_creation varchar (100),
id_COURSE INT NOT NULL,
PRIMARY KEY (Test_ID))
ENGINE = InnoDB;

CREATE TABLE Questions
(Question_Number int NOT NULL,
Question_Text VARCHAR(100),
Question_Type char,
PRIMARY KEY (Question_Number))
ENGINE = InnoDB;


CREATE TABLE Open_Questions
(Question_Number int NOT NULL,
Question_Text VARCHAR(100) not null,
Question_Answer VARCHAR(100),
PRIMARY KEY (Question_Number), 
FOREIGN KEY (Question_Number) REFERENCES Questions(Question_Number))
ENGINE = InnoDB;




CREATE TABLE American_Question
(Question_Number INT NOT NULL,
Question_Text VARCHAR(100) NOT NULL,
number_of_answers int not null,
number_of_correct_answers int not NUll,
PRIMARY KEY (Question_Number))
ENGINE = InnoDB;


CREATE TABLE American_answer
(American_answer_ID INT NOT NULL,
serial_Number INT NOT NULL,
is_correct bool , 
Text VARCHAR(100),
PRIMARY KEY (American_answer_ID))
ENGINE = InnoDB;

CREATE TABLE American_Question_to_American_Answer
(american_answer_id int NOT NULL,
american_Question_id int NOT NULL,
FOREIGN KEY (american_answer_id) REFERENCES American_answer(american_answer_id),
FOREIGN KEY (american_Question_id) REFERENCES Questions(Question_Number),
FOREIGN KEY (american_Question_id) REFERENCES American_Question(Question_Number))
ENGINE = InnoDB;

alter table American_Question
add foreign key (Question_Number) REFERENCES American_Question_to_American_Answer(american_Question_id);

use test_making_system;
SET FOREIGN_KEY_CHECKS=0;
insert into american_question_to_american_answer values
(1,2),
(2,2),
(3,2),
(4,2),
(5,8),
(6,8),
(7,8),
(8,8),
(9, 6),
(10,6),
(11,6),
(12,6),
(13,10),
(14,10),
(15,10),
(16,10),
(17,4),
(18,4),
(19,4),
(20,4);

insert into american_question values
(2, "what is the color of orange?"  ,4 , 1),
(4,"what is the machine language that computer use to execute commands"  ,4,1),
(6 ,"what is the most of expensive city in the world" ,4,1),
(8 ,"what is the most richest company?" ,4,1),
(10,"what is the most of spoken language in the world",4,2);


INSERT INTO american_answer VALUES
(1 ,1 , "orange", true),
(2,2,"red", false),
(3,3,"blue", false),
(4,4,"yellow", false),
(5,1,"Microsoft", false),
(6,2,"amazon", false),
(7,3,"apple", true),
(8,4,"ebay", false),
(9 ,1 , "New York", false),
(10,2,"London", false),
(11,3,"Tel Aviv", true),
(12,4,"Paris", False),
(13,1,"English", true),
(14,2,"Hebrew", false),
(15,3,"France", false),
(16,4,"Spanish", true),
(17 ,1 , "c#", true),
(18,2,"C++", false),
(19,3,"assembly", true),
(20,4,"java", false);


insert into questions values 
(1, "what is the color of orange?" , 'O'),
(2, "what is the color of orange?" , 'A'),
(3, "what is the machine language that computer use to execute commands" , 'O'),
(4,"what is the machine language that computer use to execute commands" , 'A'),
(5,"what is the colors of an apple" , 'O'),
(6 ,"what is the most of expensive city in the world" , 'A'),
(7 ,"what is the most of expensive city in the world" , 'O'),
(8 ,"what is the most richest company?" , 'A'),
(9 ,"what is the most richest company?" , 'O'),
(10,"what is the most of spoken language in the world",'A');

insert into tests values 
(1 , 3 , 'A',"01/01/2020", 61);

insert into open_questions values
(1, "what is the color of orange?" , "Orange"),
(3, "what is the machine language that computer use to execute commands"  ,"assembly"),
(5,"what is the colors of an apple" ,"red and green"),
(7 ,"what is the most of expensive city in the world" ,"Tel aviv"),
(9 ,"what is the most richest company?" ,"Apple");

insert into course values
(61 , 'Introduction to Agriculture'),
(1300, 'Mathematical logic'),
(1505 , 'Information and data systems programming');








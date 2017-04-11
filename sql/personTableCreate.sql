CREATE TABLE Person (
  id int NOT NULL identity,
  name varchar(20) NOT NULL DEFAULT '',
  country varchar(20) DEFAULT NULL,
  PRIMARY KEY (id)
) 


CREATE TABLE teams (
  id int NOT NULL identity,
  name varchar(40) NOT NULL,
  rating int NOT NULL,
  PRIMARY KEY (id)
) 

delete from person
select * from person
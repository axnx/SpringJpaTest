CREATE TABLE Person (
  id int NOT NULL identity,
  name varchar(20) NOT NULL DEFAULT '',
  country varchar(20) DEFAULT NULL,
  PRIMARY KEY (id)
) 
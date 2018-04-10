/*
Steps to create RunnerStats table in RunnersDB.
	*	Open the interactive session : ij
    *	Connect to database by providing connection string(use 'create = true' to create a new database)
    *	Run the SQL statements stored in RunnersDBCreate.sql file using the 'run' command.
    
Command Prompt:
C:\Program Files\Java\db-derby-for-java-comp\bin>ij
ij version 10.10
ij> connect 'jdbc:derby:RunnersDB;create=true';
ij> run 'RunnersDBCreate.sql';
*/

CREATE TABLE RunnerStats
(
RunnersName VARCHAR(20),
RunnersSpeed DOUBLE,
RestPercentage DOUBLE
);

INSERT INTO RunnerStats
VALUES('Tortoise', 10, 0);

INSERT INTO RunnerStats
VALUES('Hare', 100, 90);

INSERT INTO RunnerStats
VALUES('Dog', 50, 40);

INSERT INTO RunnerStats
VALUES('Cat', 30, 75);

/*
Disconnect;
*/
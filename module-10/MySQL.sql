CREATE DATABASE databasedb;
CREATE USER 'student1'@'localhost' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON databasedb.* TO 'student1'@'localhost';

USE databasedb;
CREATE TABLE fans (
    ID INT PRIMARY KEY,
    firstname VARCHAR(25),
    lastname VARCHAR(25),
    favoriteteam VARCHAR(25)
);

INSERT INTO fans (ID, firstname, lastname, favoriteteam) VALUES
(101, 'Derrick', 'Henry', 'Ravens'),
(102, 'Josh', 'Jacobs', 'Packers'),
(103, 'Shoei', 'Otani', 'Dodgers'),
(104, 'Steph', 'Curry', 'Warriors'),
(105, 'Chris', 'Bosh', 'Heat');


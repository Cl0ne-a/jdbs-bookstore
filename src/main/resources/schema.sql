DROP TABLE IF EXISTS BOOK;
CREATE TABLE BOOK(
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(60),
    GENRE JAVA_OBJECT(60),
    AUTHOR JAVA_OBJECT(60));

DROP TABLE IF EXISTS GENRE;
CREATE TABLE GENRE(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(60),
    FOREIGN KEY (ID) REFERENCES BOOK(ID)
);

DROP TABLE IF EXISTS AUTHOR;
CREATE TABLE AUTHOR(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(60),
    FOREIGN KEY (ID) REFERENCES BOOK(ID)
)
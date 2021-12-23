DROP TABLE IF EXISTS GENRE cascade ;
CREATE TABLE GENRE
(
    ID   int identity not null primary key,
    NAME VARCHAR(60)
);

DROP TABLE IF EXISTS AUTHOR cascade;
CREATE TABLE AUTHOR
(
    ID   int identity not null primary key,
    NAME VARCHAR(60)
);

DROP TABLE IF EXISTS BOOK;
CREATE TABLE BOOK
(
    ID int identity not null primary key,
    NAME VARCHAR(50),
    GENRE_ID INT(60),
    AUTHOR_ID INT(60),
    FOREIGN KEY (GENRE_ID) REFERENCES GENRE(ID) on delete cascade ,
    FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHOR(ID) on DELETE cascade
)
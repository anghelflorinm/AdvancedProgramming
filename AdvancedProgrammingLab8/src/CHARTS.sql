--am pus asta aici ca sa fie clar ce am facut daca sunt probleme de compatibilitate si nu se poate rula

CREATE TABLE CHART_NAMES (
    CHART_ID INTEGER not null,
    NAME VARCHAR(100) not null,
    primary key (CHART_ID)
);

CREATE SEQUENCE chart_name_seq START WITH 1;

create trigger CHART_BIR
    before insert
    on CHART_NAMES
    for each row
BEGIN
  SELECT chart_name_seq.NEXTVAL
  INTO   :new.CHART_ID
  FROM   dual;
END;

CREATE TABLE CHART_POSITION
(
    CHART_ID INTEGER NOT NULL REFERENCES CHART_NAMES ON DELETE CASCADE,
    ALBUM_ID INTEGER NOT NULL REFERENCES ALBUMS ON DELETE CASCADE,
    POSITION INTEGER NOT NULL,
    PRIMARY KEY (CHART_ID, ALBUM_ID, POSITION)
);




delete from ARTISTS;
commit;
delete from ALBUMS;
commit ;

delete from CHART_POSITION;
commit ;

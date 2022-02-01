CREATE TABLE QUESTIONS
(
    ID       NUMBER UNIQUE,
    QUESTION VARCHAR2(100),
    ANSWER   VARCHAR2(30),
    POINTS   NUMBER
);
CREATE TABLE USERS
(
    ID               NUMBER UNIQUE,
    NAME             VARCHAR2(30),
    MAX_TOTAL_POINTS NUMBER
);
INSERT INTO QUESTIONS VALUES (1,'Скільки днів в звичайному році?','365',10);
INSERT INTO QUESTIONS VALUES (2,'Який колір крейди?','білий',10);
INSERT INTO QUESTIONS VALUES (3,'Скільки років автору тесту?','19',10);
INSERT INTO QUESTIONS VALUES (4,'Чи хоче автор тесту працювати?','Так',10);
INSERT INTO QUESTIONS VALUES (5,'Скільки днів в тижні?','7',10);
INSERT INTO QUESTIONS VALUES (6,'Два тижні, скільки це днів?','14',10);
INSERT INTO QUESTIONS VALUES (7,'Скільки грам в кілограмі?','1000',10);
INSERT INTO QUESTIONS VALUES (8,'Мова програмування яку вивча автор?','java',10);
INSERT INTO QUESTIONS VALUES (9,'Коли закінчується час на практичну частину?','19:30',10);
INSERT INTO QUESTIONS VALUES (10,'Як звати автора?','Віталій',10);

COMMIT;

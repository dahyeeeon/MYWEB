create table my_user(
id varchar2(100) primary key,
pwd varchar2(100) NOT NULL,
name varchar2(50) NOT NULL,
phone varchar2(50),
regdate date
);

CREATE TABLE my_board
(num NUMBER PRIMARY KEY,
writer VARCHAR2(50),
title VARCHAR2(100),
content CLOB,
regdate DATE);

CREATE SEQUENCE my_board_seq;

CREATE TABLE my_boardfile
(num NUMBER PRIMARY KEY, --파일번호
writer VARCHAR2(100), --작성자
title VARCHAR2(100), --제목
orgFileName VARCHAR2(100), --원본파일명
saveFileName VARCHAR(100), --파일 시스템에 저장된 파일명
fileSize NUMBER, --파일 크기
downCount NUMBER DEFAULT 0, --다운로드 횟수
regdate DATE); --등록일

create sequence my_boardfile_seq;

create table my_gallery(
num NUMBER primary key,
writer varchar2(100),
caption varchar2(200),
imagePath varchar2(100),
regdate DATE
);

create sequence my_gallery_seq;
CREATE table board_cafe(
num NUMBER primary key,
writer varchar2(100) not null,
title varchar2(100) not null,
content CLOB,
viewCount NUMBER,
regdate DATE
);

CREATE SEQUENCE board_cafe_seq;

select * from board_cafe;

select result1.*
from (select num,writer,title
		LAG(num,1,0) over(order by num desc) prevNum,
		LEAD(num,1,0) over(order by num desc) nextNum
		from result1
order by num desc) result1
where num=5;


--댓글 정보를 저장할 테이블
CREATE table board_cafe_comment(
	num NUMBER primary key, --댓글 글번호
	writer varchar2(100), --댓글 작성자
	content varchar2(500), --댓글 내용
	target_id varchar2(100), --댓글의 대상이 되는 아이디(글작성자)
	ref_group NUMBER, --게시글의 댓글들의 그룹번호
	comment_group NUMBER, --원글에 달린 댓글 내에서의 그룹
	regdate DATE --댓글 등록일
);

select * from board_cafe_comment;

delete from board_gallery;


select * from board_gallery;

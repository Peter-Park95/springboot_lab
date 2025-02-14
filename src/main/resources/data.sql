INSERT INTO article(title, content) VALUES('가가가', '1111');
INSERT INTO article(title, content) VALUES('나나나', '2222');
INSERT INTO article(title, content) VALUES('다다다', '3333');
-- article 테이블에 데이터 추가
INSERT INTO article(title, content) VALUES('당신의 인생 영화는?', '댓글로 고고');
INSERT INTO article(title, content) VALUES('당신의 소울 푸드는?', '댓글로 고고');
INSERT INTO article(title, content) VALUES('당신의 취미는?', '이것 역시 댓글로 ㄱㄱ');
-- 4번 게시글의 댓글  추가
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'ParkHeebum', '어바웃타임');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Jean', '쇼생크탈출');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Sia', '아이엠샘');
--5번 게시글 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'ParkHeebum', '치킨');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Kim', '마라탕');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Choi', '삼겹살');
--6번 게시글 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'ParkHeebum', '조깅');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Kim', '유튜브 시청');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Choi', '독서');
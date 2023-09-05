-- 기존 데이터
INSERT INTO article(title, content) values ('가가가가', '1111');
INSERT INTO article(title, content) values ('나나나나', '2222');
INSERT INTO article(title, content) values ('다다다다', '3333');
-- article 테이블에 데이터 추가
INSERT INTO article(title, content) values ('당신의 인생 영화는?', '111111');
INSERT INTO article(title, content) values ('당신의 소울 푸드는?', '2222');
INSERT INTO article(title, content) values ('당신의 취미는?', '3333');
-- 4번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) values (4, 'Park', '굿 윌 헌팅');
INSERT INTO comment(article_id, nickname, body) values (4, 'Kim', '아이 엠 샘');
INSERT INTO comment(article_id, nickname, body) values (4,'Choi','쇼생크 탈출');
-- 5번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) values (5, 'Park', '치킨');
INSERT INTO comment(article_id, nickname, body) values (5, 'Kim', '샤브샤브');
INSERT INTO comment(article_id, nickname, body) values (5,'Choi','초밥');
-- 6번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) values (6, 'Park', '조깅');
INSERT INTO comment(article_id, nickname, body) values (6, 'Kim', '유튜브 시청');
INSERT INTO comment(article_id, nickname, body) values (6,'Choi','독서');
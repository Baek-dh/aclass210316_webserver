DROP TABLE "MEMBER";

CREATE TABLE "MEMBER" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"MEMBER_ID"	VARCHAR2(30)		NOT NULL,
	"MEMBER_PW"	VARCHAR2(200)		NOT NULL,
	"MEMBER_NM"	VARCHAR2(30)		NOT NULL,
	"MEMBER_PHONE"	CHAR(13)		NOT NULL,
	"MEMBER_EMAIL"	VARCHAR2(100)		NOT NULL,
	"MEMBER_ADDR"	VARCHAR2(500)		NULL,
	"ENROLL_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"MEMBER_STATUS"	CHAR(1) DEFAULT 'Y'  CHECK("MEMBER_STATUS" IN('Y','N'))		NOT NULL,
	"MEMBER_GRADE"	CHAR(1)	DEFAULT 'G'  CHECK("MEMBER_GRADE" IN('G','A')) 	NOT NULL
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원 구분 번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_ID" IS '회원 아이디';

COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '회원 비밀번호(암호화)';

COMMENT ON COLUMN "MEMBER"."MEMBER_NM" IS '회원 이름';

COMMENT ON COLUMN "MEMBER"."MEMBER_PHONE" IS '회원 휴대폰 번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '회원 이메일';

COMMENT ON COLUMN "MEMBER"."MEMBER_ADDR" IS '회원 주소';

COMMENT ON COLUMN "MEMBER"."ENROLL_DATE" IS '회원 가입일';

COMMENT ON COLUMN "MEMBER"."MEMBER_STATUS" IS '회원상태(정상 : Y, 탈퇴:N)';

COMMENT ON COLUMN "MEMBER"."MEMBER_GRADE" IS '회원등급(일반:G, 관리자:A)';

DROP TABLE "NOTICE";

CREATE TABLE "NOTICE" (
	"NOTICE_NO"	NUMBER		NOT NULL,
	"NOTICE_TITLE"	VARCHAR2(100)		NOT NULL,
	"NOTICE_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"READ_COUNT"	NUMBER	DEFAULT 0	NOT NULL,
	"CREATE_DT"	DATE	DEFAULT SYSDATE	NOT NULL,
	"NOTICE_STATUS"	CHAR(1)	DEFAULT 'Y' CHECK("NOTICE_STATUS" IN('Y','N'))	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "NOTICE"."NOTICE_NO" IS '공지글 번호';

COMMENT ON COLUMN "NOTICE"."NOTICE_TITLE" IS '공지글 제목';

COMMENT ON COLUMN "NOTICE"."NOTICE_CONTENT" IS '공지글 내용';

COMMENT ON COLUMN "NOTICE"."READ_COUNT" IS '조회수';

COMMENT ON COLUMN "NOTICE"."CREATE_DT" IS '공지글 작성일';

COMMENT ON COLUMN "NOTICE"."NOTICE_STATUS" IS '공지글 상태(정상:Y, 삭제:N)';

COMMENT ON COLUMN "NOTICE"."MEMBER_NO" IS '공지글 작성자 회원번호';


DROP TABLE "CATEGORY";

CREATE TABLE "CATEGORY" (
	"CATEGORY_CD"	NUMBER		NOT NULL,
	"CATEGORY_NM"	VARCHAR2(50)		NOT NULL
);

COMMENT ON COLUMN "CATEGORY"."CATEGORY_CD" IS '카테고리 코드 번호';

COMMENT ON COLUMN "CATEGORY"."CATEGORY_NM" IS '카테고리명';


DROP TABLE "BOARD_TYPE";

CREATE TABLE "BOARD_TYPE" (
	"BOARD_TYPE_NO"	NUMBER		NOT NULL,
	"BOARD_NM"	VARCHAR2(50)		NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_TYPE_NO" IS '게시판 타입 번호';

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NM" IS '게시판 이름';


DROP TABLE "BOARD";

CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"BOARD_TITLE"	VARCHAR2(100)		NOT NULL,
	"BOARD_CONTENT"	CLOB		NOT NULL,
	"READ_COUNT"	NUMBER	DEFAULT 0	NOT NULL,
	"CREATE_DT"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"MODIFY_DT"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"BOARD_STATUS"	CHAR(1)	    DEFAULT 'Y'  CHECK("BOARD_STATUS" IN('Y','N'))	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"CATEGORY_CD"	NUMBER		NOT NULL,
	"BOARD_TYPE_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글 번호';

COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글 제목';

COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글 내용';

COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';

COMMENT ON COLUMN "BOARD"."CREATE_DT" IS '게시글 작성일';

COMMENT ON COLUMN "BOARD"."MODIFY_DT" IS '게시글 마지막 수정일';

COMMENT ON COLUMN "BOARD"."BOARD_STATUS" IS '게시글상태(정상:Y,삭제:N)';

COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '게시글 작성 회원번호';

COMMENT ON COLUMN "BOARD"."CATEGORY_CD" IS '카테고리 코드';

COMMENT ON COLUMN "BOARD"."BOARD_TYPE_NO" IS '게시판 종류 구분 번호';


DROP TABLE "ATTACHMENT";

CREATE TABLE "ATTACHMENT" (
	"FILE_NO"	NUMBER		NOT NULL,
	"FILE_PATH"	VARCHAR2(500)		NOT NULL,
	"FILE_NM"	VARCHAR2(100)		NOT NULL,
	"FILE_LEVEL"	NUMBER		NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "ATTACHMENT"."FILE_NO" IS '파일 번호';

COMMENT ON COLUMN "ATTACHMENT"."FILE_PATH" IS '파일 저장 경로';

COMMENT ON COLUMN "ATTACHMENT"."FILE_NM" IS '파일명';

COMMENT ON COLUMN "ATTACHMENT"."FILE_LEVEL" IS '파일 등록 순서';

COMMENT ON COLUMN "ATTACHMENT"."BOARD_NO" IS '파일이 등록된 게시글 번호';



ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"MEMBER_NO"
);

ALTER TABLE "NOTICE" ADD CONSTRAINT "PK_NOTICE" PRIMARY KEY (
	"NOTICE_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY (
	"BOARD_NO"
);

ALTER TABLE "CATEGORY" ADD CONSTRAINT "PK_CATEGORY" PRIMARY KEY (
	"CATEGORY_CD"
);

ALTER TABLE "BOARD_TYPE" ADD CONSTRAINT "PK_BOARD_TYPE" PRIMARY KEY (
	"BOARD_TYPE_NO"
);

ALTER TABLE "ATTACHMENT" ADD CONSTRAINT "PK_ATTACHMENT" PRIMARY KEY (
	"FILE_NO"
);

ALTER TABLE "NOTICE" ADD CONSTRAINT "FK_MEMBER_TO_NOTICE_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "FK_CATEGORY_TO_BOARD_1" FOREIGN KEY (
	"CATEGORY_CD"
)
REFERENCES "CATEGORY" (
	"CATEGORY_CD"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "FK_BOARD_TYPE_TO_BOARD_1" FOREIGN KEY (
	"BOARD_TYPE_NO"
)
REFERENCES "BOARD_TYPE" (
	"BOARD_TYPE_NO"
);

ALTER TABLE "ATTACHMENT" ADD CONSTRAINT "FK_BOARD_TO_ATTACHMENT_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);


------------------------------------------------------------------------------------------------

-- MEMBER 테이블에 샘플 데이터 추가

-- 1) 회원 번호 생성용 SEQUENCE 생성
CREATE SEQUENCE SEQ_MNO;
-- 1부터 1씩 증가하는 시퀀스 생성

-- 2) 관리자 계정 샘플 데이터 추가
INSERT INTO MEMBER
VALUES( SEQ_MNO.NEXTVAL, 'admin', '1q2w3e4r', '김관리', '010-1234-1234', 
            'admin@kh.or.kr', '04540, 서울특별시 중구 남대문로 120, 2층 KH정보교육원 종로지원 A강의장',
            DEFAULT, DEFAULT, 'A');

COMMIT;

-- 로그인을 위한 SELECT 구문
SELECT MEMBER_NO, MEMBER_ID, MEMBER_NM, MEMBER_PHONE,
           MEMBER_EMAIL, MEMBER_ADDR, ENROLL_DATE, MEMBER_GRADE
FROM MEMBER
WHERE MEMBER_ID = 'admin'
AND MEMBER_PW = '1q2w3e4r'
AND MEMBER_STATUS = 'Y'
;



-- 탈퇴하지 않은 회원 중 중복되는 아이디가 있는지 검사
-- 조회 결과   
-- 중복 O : 1
-- 중복 X : 0

SELECT COUNT(*) FROM MEMBER
WHERE MEMBER_STATUS = 'Y'
AND MEMBER_ID = 'user991111';


INSERT INTO CATEGORY VALUES(1, '잡담');
INSERT INTO CATEGORY VALUES(2, '질문');
INSERT INTO CATEGORY VALUES(3, '뉴스');

SELECT * FROM CATEGORY;
COMMIT;

INSERT INTO BOARD_TYPE VALUES(1, '자유');
INSERT INTO BOARD_TYPE VALUES(2, '정보');
SELECT * FROM BOARD_TYPE;

COMMIT;

-- 게시글 번호 시퀀스 생성
CREATE SEQUENCE SEQ_BNO;


-- PL/SQL을 이용한 게시판 샘플 데이터 500개 생성
SET SERVEROUTPUT ON;

BEGIN
    FOR N IN 1..1 LOOP
        INSERT INTO BOARD
        VALUES(SEQ_BNO.NEXTVAL,
                    N || '번째 게시글',
                    N || '번째 게시글 입니다.',
                    DEFAULT, DEFAULT, DEFAULT, DEFAULT, 1,
                    FLOOR(DBMS_RANDOM.VALUE(1,4)), 1);
    END LOOP;
END;
/

COMMIT;

-- 파일 번호 시퀀스 생성
CREATE SEQUENCE SEQ_FNO;

INSERT INTO ATTACHMENT VALUES (SEQ_FNO.NEXTVAL, 'resources/images/freeboard/', 'sample1.jpg', 0, 500);
INSERT INTO ATTACHMENT VALUES (SEQ_FNO.NEXTVAL, 'resources/images/freeboard/', 'sample2.gif', 1, 500);
INSERT INTO ATTACHMENT VALUES (SEQ_FNO.NEXTVAL, 'resources/images/freeboard/', 'sample3.jpg', 2, 500);
INSERT INTO ATTACHMENT VALUES (SEQ_FNO.NEXTVAL, 'resources/images/freeboard/', 'sample4.gif', 3, 500);
INSERT INTO ATTACHMENT VALUES (SEQ_FNO.NEXTVAL, 'resources/images/freeboard/', 'sample5.gif', 0, 499);
COMMIT;
SELECT * FROM ATTACHMENT;


-- 게시판 목록
-- 게시글 번호 / 파일 경로 / 파일명 / 카테고리명 / 제목 / 작성자 / 작성일 / 조회수

SELECT * FROM BOARD
JOIN CATEGORY USING(CATEGORY_CD)
JOIN MEMBER USING(MEMBER_NO)
LEFT JOIN (SELECT * FROM ATTACHMENT WHERE FILE_LEVEL = 0) USING(BOARD_NO);

-- 게시글 목록 500개 모두 조회
-- 단, 게시글에 파일 레벨이 0인 요소가 포함되어 있으면 파일경로, 파일명, 파일레벨 조회

SELECT * FROM ATTACHMENT WHERE FILE_LEVEL = 0  ;


-- VIEW를 이용하여 SQL을 간단하게 만들기
CREATE OR REPLACE VIEW BOARD_LIST AS
    SELECT BOARD_NO, CATEGORY_NM, FILE_PATH, FILE_NM, 
            BOARD_TITLE, MEMBER_NM, READ_COUNT, CREATE_DT, BOARD_STATUS, BOARD_TYPE_NO
    FROM BOARD
    JOIN CATEGORY USING(CATEGORY_CD)
    JOIN MEMBER USING(MEMBER_NO)
    LEFT JOIN (SELECT * FROM ATTACHMENT WHERE FILE_LEVEL = 0) USING(BOARD_NO);
    
SELECT * FROM BOARD_LIST;

-------------------------------------------------------------------------------------------------------

-- 페이징 처리 (Pagenation)
-- 한 페이지에 보여질 게시글 수를 지정
-- ex) 한 페이지당 게시글 10개씩 
-- 1페이지 500 ~ 491   (!최신순!)
-- 2페이지 490 ~ 481
-- ...
-- 50페이지 10 ~ 1


-- 게시글 번호가 최근 게시글 목록 10개 조회
-- + 삭제되지 않아야함, + 게시판 타입은 1번
SELECT * FROM 
    (SELECT * FROM BOARD_LIST
    WHERE BOARD_STATUS = 'Y'
    AND BOARD_TYPE_NO = 1
    ORDER BY BOARD_NO DESC) 
WHERE ROWNUM BETWEEN 11 AND 20; 
--> ROWNUM을 조건으로 사용하는 경우 1부터 시작이 강요됨.
    --> ROWNUM은 1부터 조회되는 행의 수를 세는 가상의 컬럼


/********************************************/
SELECT * FROM 
( SELECT ROWNUM RNUM,   A.* FROM 
    (SELECT * FROM BOARD_LIST
        WHERE BOARD_STATUS = 'Y'
        AND BOARD_TYPE_NO = 1
        ORDER BY BOARD_NO DESC) A
        )
WHERE RNUM BETWEEN 1 AND 10  ; 


-- 특정 게시판 전체 게시글 수 + 게시판 이름 조회
-- BOARD_TYPE_NO = 1
SELECT COUNT(*), BOARD_NM
FROM BOARD_LIST
JOIN BOARD_TYPE USING(BOARD_TYPE_NO)
WHERE BOARD_TYPE_NO=4
GROUP BY BOARD_NM
;

SELECT CNT, (SELECT BOARD_NM FROM BOARD_TYPE WHERE BOARD_TYPE_NO=3) BOARD_NM
FROM (SELECT COUNT(*) CNT
    FROM BOARD_LIST
    JOIN BOARD_TYPE USING(BOARD_TYPE_NO)
    WHERE BOARD_TYPE_NO=3
    GROUP BY BOARD_NM)
;



CREATE OR REPLACE VIEW BOARD_DETAIL AS
    SELECT BOARD_NO, CATEGORY_NM, FILE_PATH, FILE_NM, 
            BOARD_TITLE, MEMBER_NM, READ_COUNT, CREATE_DT, BOARD_STATUS, BOARD_TYPE_NO,
            BOARD_CONTENT, FILE_LEVEL, MODIFY_DT, MEMBER_NO
    FROM BOARD
    JOIN CATEGORY USING(CATEGORY_CD)
    JOIN MEMBER USING(MEMBER_NO)
    LEFT JOIN ATTACHMENT USING(BOARD_NO);
    
 -- 500번글 상세 조회
SELECT * FROM BOARD_DETAIL
WHERE BOARD_NO = 50
AND BOARD_STATUS = 'Y'
;
    


UPDATE BOARD SET
READ_COUNT = READ_COUNT + 1
WHERE BOARD_NO = ?

;

-- 다음 게시글 번호 조회
SELECT SEQ_BNO.NEXTVAL FROM DUAL
;

-- BOARD 테이블 삽입 구문
INSERT INTO BOARD
VALUES(?, ?, ?, DEFAULT, DEFAULT, DEFAULT, DEFAULT, ?, ?, ?)
;

-- ATTACHMENT 테이블 삽입 구문
INSERT INTO ATTACHMENT
VALUES(SEQ_FNO.NEXTVAL, ?, ?, ?, ?)
;

select * from board_detail where board_no = 500;


SELECT * FROM ATTACHMENT
WHERE BOARD_NO = 499
AND FILE_LEVEL = 1;

-- 파일 정보 수정
UPDATE ATTACHMENT SET
FILE_NM = 'aaa.jpg'
WHERE BOARD_NO =499
AND FILE_LEVEL =2;

commit;

rollback;




SELECT * FROM 
( SELECT ROWNUM RNUM,   A.* FROM 
    (SELECT * FROM BOARD_LIST
        WHERE BOARD_STATUS = 'Y'
        AND BOARD_TYPE_NO = 1
        AND BOARD_TITLE LIKE '%테스트%'      
        ORDER BY BOARD_NO DESC) A
        )
WHERE RNUM BETWEEN 1 AND 10  ; 


----------------------------------------------------------------------------------------------------

DROP TABLE REPLY;
DROP SEQUENCE SEQ_RNO;


CREATE TABLE REPLY(
  REPLY_NO NUMBER PRIMARY KEY,
  REPLY_CONTENT VARCHAR2(1000) NOT NULL,
  REPLY_STATUS CHAR(1) DEFAULT 'Y' CHECK (REPLY_STATUS IN ('Y', 'N')),
  CREATE_DT TIMESTAMP DEFAULT SYSTIMESTAMP,
  MEMBER_NO NUMBER REFERENCES MEMBER NOT NULL,
  BOARD_NO NUMBER REFERENCES BOARD NOT NULL
);

COMMENT ON COLUMN REPLY.REPLY_NO IS '댓글 번호(PK)';
COMMENT ON COLUMN REPLY.REPLY_CONTENT IS '댓글  내용';
COMMENT ON COLUMN REPLY.REPLY_STATUS IS '댓글 상태(Y:정상, N:삭제)';
COMMENT ON COLUMN REPLY.CREATE_DT IS '댓글 작성일';
COMMENT ON COLUMN REPLY.MEMBER_NO IS '댓글 작성 회원 번호';
COMMENT ON COLUMN REPLY.BOARD_NO IS '댓글이 작성된 게시글 번호';

-- 댓글 번호 시퀀스
CREATE SEQUENCE SEQ_RNO;

-- 가장 최근 게시글에 댓글 샘플 데이터 삽입
INSERT INTO REPLY VALUES(SEQ_RNO.NEXTVAL, '댓글 테스트1', DEFAULT, DEFAULT, 1, (SELECT MAX(BOARD_NO) FROM BOARD_LIST WHERE BOARD_STATUS = 'Y' AND BOARD_TYPE_NO = 1) );
INSERT INTO REPLY VALUES(SEQ_RNO.NEXTVAL, '댓글 테스트2', DEFAULT, DEFAULT, 1, (SELECT MAX(BOARD_NO) FROM BOARD_LIST WHERE BOARD_STATUS = 'Y' AND BOARD_TYPE_NO = 1) );

COMMIT;




-- 게시글 제목에 '123'이라는 문자열이 포함된 게시글의 수 조회
SELECT CNT, (SELECT BOARD_NM FROM BOARD_TYPE WHERE BOARD_TYPE_NO=1 ) BOARD_NM
FROM (SELECT COUNT(*) CNT
    FROM BOARD_LIST
    JOIN BOARD_TYPE USING(BOARD_TYPE_NO)
    WHERE BOARD_TYPE_NO=1
    AND BOARD_STATUS = 'Y'
    AND MEMBER_NM LIKE '%유저%'
    ); 


-- BOARD_LIST VIEW에 BOARD_CONTENT 추가하기
CREATE OR REPLACE VIEW BOARD_LIST AS
    SELECT BOARD_NO, CATEGORY_NM, FILE_PATH, FILE_NM, 
            BOARD_TITLE, MEMBER_NM, READ_COUNT, CREATE_DT, BOARD_STATUS, BOARD_TYPE_NO, BOARD_CONTENT
    FROM BOARD
    JOIN CATEGORY USING(CATEGORY_CD)
    JOIN MEMBER USING(MEMBER_NO)
    LEFT JOIN (SELECT * FROM ATTACHMENT WHERE FILE_LEVEL = 0) USING(BOARD_NO);


SELECT * FROM 
( SELECT ROWNUM RNUM,   A.* FROM 
    (SELECT * FROM BOARD_LIST
        WHERE BOARD_STATUS = 'Y'
        AND BOARD_TYPE_NO = 1
        
        AND BOARD_TITLE LIKE '%123%'
        
        ORDER BY BOARD_NO DESC
    ) A
)
WHERE RNUM BETWEEN 11 AND 20;









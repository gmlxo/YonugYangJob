/* table */
CREATE TABLE user_tbl_gmlxo(
    user_id varchar2(255) CONSTRAINT user_gmlxo_id_pk primary key,
    user_name varchar2(255) CONSTRAINT user_gmlxo_name_uq unique,
    user_pwd varchar2(255),
    user_date DATE,
    user_email VARCHAR2(255) CONSTRAINT user_gmlxo_eamil_uq unique,
    user_type char(1)
);

CREATE TABLE enterprise_tbl_gmlxo (
    ent_name varchar2(255) CONSTRAINT ent_gmlxo_name_pk primary key, -- 기업명
    sectors varchar2(255), -- 업종
    establishment_date date, -- 설립일
    representative varchar2(255), -- 대표자
    address varchar2(255), -- 주소
    url varchar2(4000) CONSTRAINT ent_gmlxo_url_uq unique,
    Explanation varchar2(4000), -- 정보
    logo_img varchar2(4000) -- logo img
);

CREATE TABLE employment_tbl_gmlxo (
    emp_title varchar2(255) CONSTRAINT emp_gmlxo_title_pk primary key,
    emp_name varchar2(255) CONSTRAINT emp_user_gmlxo_name_fk REFERENCES user_tbl_gmlxo(user_id), -- 올리는 사람 이름
    emp_email varchar2(255), -- 연락처
    company_name varchar2(255) CONSTRAINT emp_ent_gmlxo_entName_fk REFERENCES enterprise_tbl_gmlxo(ent_name), -- 기업 명
    emp_url varchar2(4000) CONSTRAINT emp_gmlxo_url_nn not null, -- 지원 싸이트
    career char(1), -- 경력
    education char(1), -- 학력
    work_type char(1), -- 근무형태
    emp_day date, -- 언제까지 모집하는지
    emp_contents varchar2(4000)
);

DROP TABLE employment_tbl_gmlxo;

CREATE TABLE community_tbl_gmlxo (
    ity_idx int CONSTRAINT ity_gmlxo_idx_pk primary key,
    user_id varchar2(255) CONSTRAINT ity_user_gmlxo_id_fk REFERENCES user_tbl_gmlxo(user_id),
    ity_title varchar2(255),
    ity_day date,
    ity_contents varchar2(4000)
);

CREATE SEQUENCE ity_seq;
DROP SEQUENCE ity_seq;

CREATE TABLE comment_tbl_gmlxo (
    com_idx int CONSTRAINT com_gmlxo_idx_pk primary key,
    ity_idx int CONSTRAINT com_ity_gmlxo_idx_fk REFERENCES community_tbl_gmlxo(ity_idx),
    user_id varchar2(255)CONSTRAINT com_user_gmlxo_id_fk REFERENCES user_tbl_gmlxo(user_id),
    com_day date,
    com_contents varchar2(4000)
);
CREATE SEQUENCE com_seq;
DROP SEQUENCE com_seq;

/* insert */
--user
insert into user_tbl_gmlxo values ('admin', 'admin', '1234', sysdate, 'test@gmail.com', '3');
insert into user_tbl_gmlxo values ('a', 'a', 'a', sysdate, 'test2@gmail.com', '4');

/* test query */
select * from user_tbl_gmlxo;
select * from user_tbl_gmlxo where user_id='admin' and user_pwd='1234';
DELETE FROM user_tbl_gmlxo WHERE user_type = '1';

commit;

select * from employment_tbl_gmlxo;
SELECT * FROM enterprise_tbl_gmlxo;
SELECT * FROM community_tbl_gmlxo;
SELECT * FROM comment_tbl_gmlxo;

SELECT 
    emp.company_name, 
    TO_DATE(emp.emp_day, 'YYYY-MM-DD') - TO_DATE(sysdate, 'YYYY-MM-DD') emp_day, 
    emp_contents, 
    ent.logo_img, 
    ent.sectors 
FROM employment_tbl_gmlxo emp, enterprise_tbl_gmlxo ent 
where emp.company_name = ent.ent_name;

SELECT ent_name, sectors, TO_CHAR(establishment_date, 'YYYY"년 "MM"월 "DD"일"'), representative, address, url, Explanation, logo_img FROM enterprise_tbl_gmlxo  where ent_name like '%?%' or sectors like '%전기%' or address like '%?%' ORDER by ent_name asc;
--DELETE FROM community_tbl_gmlxo where ity_idx = 3;
--DELETE FROM comment_tbl_gmlxo;

SELECT emp.company_name, emp.emp_title, TO_DATE(emp.emp_day, 'YYYY-MM-DD') - TO_DATE(sysdate, 'YYYY-MM-DD') emp_day, substr(emp.emp_contents, 1, 70) emp_contents, ent.logo_img, ent.sectors FROM employment_tbl_gmlxo emp, enterprise_tbl_gmlxo ent where emp.company_name = ent.ent_name and ent.address like '%?%';
SELECT emp.company_name, emp.emp_title, TO_DATE(emp.emp_day, 'YYYY-MM-DD') - TO_DATE(sysdate, 'YYYY-MM-DD') emp_day, substr(emp.emp_contents, 1, 70) emp_contents, ent.logo_img, ent.sectors FROM employment_tbl_gmlxo emp, enterprise_tbl_gmlxo ent where emp.company_name = ent.ent_name and ent.address like '%my%';

insert into enterprise_tbl_gmlxo VALUES ('test_ent', '전기', sysdate, '양만모', '우리집_myHome', '중복방지1', '쓰기 귀찮아', 'https://www.viewhotels.jp/asakusa-annex/wp-content/uploads/sites/6/2020/03/test-img.jpg');
insert into employment_tbl_gmlxo values ('testTitle', 'admin', 'test@gmail.com', '지야조명', 'no', '1', '1', '1', sysdate + 10, 'test emp');
insert into community_tbl_gmlxo values (ity_seq.NEXTVAL, 'admin', 'test text', '2022-11-06','1234567890101112');
insert into comment_tbl_gmlxo values (com_seq.NEXTVAL, 1, 'admin', '2022-11-06', 'day test');

SELECT ity_idx, user_id, ity_title, TO_DATE(sysdate, 'YYYY-MM-DD') - TO_DATE(ity_day, 'YYYY-MM-DD')+1 ity_day, substr(ity_contents, 1, 10) FROM community_tbl_gmlxo;
SELECT TO_DATE(sysdate, 'YYYY-MM-DD') - TO_DATE(ity_day, 'YYYY-MM-DD') FROM community_tbl_gmlxo;
SELECT com_idx, ity_idx, user_id, TO_DATE(sysdate, 'YYYY-MM-DD') - TO_DATE(com_day, 'YYYY-MM-DD')+1 com_day, com_contents FROM comment_tbl_gmlxo where ity_idx=1;
select decode(career, '1', 'test', '2', 'aa') from employment_tbl_gmlxo;

select 
    ent.sectors,
    ent.address,
    ent.url ent_url,
    emp.emp_title,
    emp.emp_name,
    emp.emp_email,
    emp.company_name,
    TO_DATE(emp.emp_day, 'YYYY-MM-DD') - TO_DATE(sysdate, 'YYYY-MM-DD') emp_day, 
    emp.emp_url,
    decode(emp.career, '1','무관', '2', '~ 2년', '5','~ 5년', '8','~ 10년', '9', '10 ~') emp_career,
    decode(emp.education, '1','고졸', '2','2년제', '4','4년제', '5', '대학원') emp_education,
    decode(emp.work_type, '1','비정규직', '2', '정규직') emp_work_type,
    emp.emp_contents
from employment_tbl_gmlxo emp, enterprise_tbl_gmlxo ent 
where emp.company_name = ent.ent_name and emp.emp_title = 'testTitle';

delete form community_tbl_gmlxo where ity_idx = ?;
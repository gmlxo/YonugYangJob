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
    sectors varchar2(255) CONSTRAINT ent_gmlxo_sectors_uq unique, -- 업종
    establishment_date date, -- 설립일
    representative varchar2(255), -- 대표자
    address varchar2(255), -- 주소
    url varchar2(4000) 
);

CREATE TABLE support_tbl_gmlxo (
    title varchar2(255) CONSTRAINT sup_emp_gmlxo_title_fk REFERENCES employment_tbl_gmlxo(emp_title),
    sup_applicant varchar2(255)CONSTRAINT sup_user_gmlxo_name_fk REFERENCES user_tbl_gmlxo(user_id),
    sup_emil VARCHAR2(255) CONSTRAINT sup_user_gmlxo_mail_fk REFERENCES user_tbl_gmlxo(user_email),
    sup_file varchar2(4000)
);

CREATE TABLE employment_tbl_gmlxo (
    emp_title varchar2(255) CONSTRAINT emp_ann_gmlxo_title_pk primary key,
    officials varchar2(255)CONSTRAINT emp_user_gmlxo_name_fk REFERENCES user_tbl_gmlxo(user_id),
    officials_mail varchar2(255) CONSTRAINT emp_gmlxo_mail_uq unique,
    company_name varchar2(255) CONSTRAINT emp_ent_gmlxo_comName_fk REFERENCES enterprise_tbl_gmlxo(ent_name),
    emp_contents varchar2(4000),
    emp_url varchar2(4000)CONSTRAINT emp_gmlxo_url_uq unique,
    emp_sectors varchar2(255) CONSTRAINT emp_ent_gmlxo_sec_fk REFERENCES enterprise_tbl_gmlxo(sectors),
    emp_career CHAR(1),
    emp_Education CHAR(1),
    emp_workType CHAR(1)
);

CREATE TABLE community_tbl_gmlxo (
    ity_idx int CONSTRAINT ity_gmlxo_idx_pk primary key,
    userid varchar2(255) CONSTRAINT ity_user_gmlxo_id_fk REFERENCES user_tbl_gmlxo(user_id),
    ity_title varchar2(255) CONSTRAINT ity_gmlxo_title_uq unique,
    ity_contents varchar2(4000)
);

CREATE TABLE comment_tbl_gmlxo (
    com_idx int CONSTRAINT com_gmlxo_idx_pk primary key,
    ity_idx int CONSTRAINT com_ity_gmlxo_idx_fk REFERENCES community_tbl_gmlxo(ity_idx),
    userid varchar2(255)CONSTRAINT com_user_gmlxo_id_fk REFERENCES user_tbl_gmlxo(user_id),
    com_contents varchar2(4000)
);

/* insert */
--user
insert into user_tbl_gmlxo values ('admin', 'admin', '1234', sysdate, 'test@gmail.com', '3');
insert into user_tbl_gmlxo values ('a', 'a', 'a', sysdate, 'test2@gmail.com', '4');

/* test query */
select * from user_tbl_gmlxo;
select * from user_tbl_gmlxo where user_id='admin' and user_pwd='1234';
DELETE FROM user_tbl_gmlxo WHERE user_type = '1';
commit;

insert into enterprise_tbl_gmlxo VALUES ('지야조명', '전기', sysdate, '양만모', '

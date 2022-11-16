CREATE TABLE user_tbl_gmlxo(
    user_id varchar2(255) CONSTRAINT user_gmlxo_id_pk primary key,
    user_name varchar2(255) CONSTRAINT user_gmlxo_name_uq unique,
    user_pwd varchar2(255),
    data data,
    user_email VARCHAR2(255) CONSTRAINT user_gmlxo_eamil_uq unique,
    user_type char(1)
);

CREATE TABLE enterprise_tbl_gmlxo (
    ent_name varchar2(255) CONSTRAINT ent_gmlxo_name_pk primary key,
    sectors varchar2(255) CONSTRAINT ent_gmlxo_name_uq unique,
    establishment_date data,
    representative varchar2(255),
    address varchar2(255) CONSTRAINT ent_gmlxo_name_uq unique,
    url varchar2(255)
);

CREATE TABLE employment_tbl_gmlxo (
    company_name varchar2(255) CONSTRAINT emp_ent_name_fk REFERENCES announcement_tbl_gmlxo(company_name),
    emp_applicant varchar2(255)CONSTRAINT emp_ent_name_fk REFERENCES user_tbl_gmlxo(user_id),
    emp_file varchar2(255)
);

CREATE TABLE announcement_tbl_gmlxo (
    company_name varchar2(255) CONSTRAINT emp_ent_name_fk REFERENCES enterprise_tbl_gmlxo(ent_name),
    ann_contact varchar2(255) CONSTRAINT emp_gmlxo_contact_uq unique,
    ann_title varchar2(255) CONSTRAINT emp_gmlxo_title_uq unique,
    ann_contents varchar2(4000),
    ann_sectors varchar2(255) CONSTRAINT emp_ent_name_fk REFERENCES enterprise_tbl_gmlxo(sectors)
);
CREATE TABLE community_tbl_gmlxo (
    ity_idx int CONSTRAINT ity_gmlxo_idx_pk primary key,
    userid varchar2(255) CONSTRAINT ity_id_fk REFERENCES user_tbl_gmlxo(user_id),
    ity_title varchar2(255) CONSTRAINT ity_gmlxo_title_uq unique,
    ity_contents varchar2(4000)
);
CREATE TABLE comment_tbl_gmlxo (
    com_idx int CONSTRAINT com_gmlxo_idx_pk primary key,
    ity_idx int CONSTRAINT com_ity_idx_fk REFERENCES community_tbl_gmlxo(ity_idx),
    userid varchar2(255)CONSTRAINT ity_id_fk REFERENCES user_tbl_gmlxo(user_id),
    com_title varchar2(255) CONSTRAINT ity_gmlxo_title_uq unique,
    com_contents varchar2(4000)
);

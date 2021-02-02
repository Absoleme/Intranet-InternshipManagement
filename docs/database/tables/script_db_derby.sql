------------------------------------------------------------
--        Script SQL_Derby.  
------------------------------------------------------------

------------------------------------------------------------
-- Table: tutor
------------------------------------------------------------
CREATE TABLE tutor(
                      tutor_id   INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
                      firstname  Varchar(255) NOT NULL  ,
                      lastname   Varchar(255) NOT NULL  ,
                      email      Varchar(255) NOT NULL  ,
                      password   Varchar(255) NOT NULL  ,
                      PRIMARY KEY (tutor_id)
);


------------------------------------------------------------
-- Table: intern
------------------------------------------------------------
CREATE TABLE intern(
                       intern_id        INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
                       requirement              BOOLEAN  NOT NULL WITH DEFAULT false,
                       visit_file     BOOLEAN  NOT NULL WITH DEFAULT false,
                       eval_comp_file  BOOLEAN  NOT NULL WITH DEFAULT false,
                       web_poll      BOOLEAN  NOT NULL WITH DEFAULT false,
                       report_delivered    BOOLEAN  NOT NULL WITH DEFAULT false,
                       defense       BOOLEAN  NOT NULL WITH DEFAULT false,
                       defense_planned       BOOLEAN  NOT NULL WITH DEFAULT false,
                       defense_done       BOOLEAN  NOT NULL WITH DEFAULT false,
                       linkedin_url     Varchar(255) NOT NULL WITH DEFAULT '',
                       tutor_id         Int NOT NULL,
                       student_id         Int NOT NULL,
                       PRIMARY KEY (intern_id)
);


------------------------------------------------------------
-- Table: company
------------------------------------------------------------
CREATE TABLE company(
    company_id     INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
    name           Varchar(255) NOT NULL  ,
    street_number  Int NOT NULL  ,
    street_name    Varchar(255) NOT NULL  ,
    city           Varchar(255) NOT NULL  ,
    zipcode        Varchar(255) NOT NULL  ,
    PRIMARY KEY (company_id)
);

------------------------------------------------------------
-- Table: mission
------------------------------------------------------------
CREATE TABLE mission(
    mission_id   INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
    description  LONG VARCHAR  ,
    key_words    LONG VARCHAR  ,
    PRIMARY KEY (mission_id)
);


------------------------------------------------------------
-- Table: skill
------------------------------------------------------------
CREATE TABLE skill(
                      skill_id  INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
                      name      Varchar(255) NOT NULL  ,
                      PRIMARY KEY (skill_id)
);


------------------------------------------------------------
-- Table: internship supervisor
------------------------------------------------------------
CREATE TABLE internship_supervisor(
                                      intern_supervisor_id  INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
                                      firstname             Varchar(255) NOT NULL  ,
                                      lastname              Varchar(255) NOT NULL  ,
                                      company_id            Int NOT NULL  ,
                                      PRIMARY KEY (intern_supervisor_id)
);


------------------------------------------------------------
-- Table: internship
------------------------------------------------------------
CREATE TABLE internship
(
	internship_id              INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	start_date            Date NOT NULL  ,
	end_date              Date NOT NULL  ,
    note_tech             FLOAT  ,
    note_com              FLOAT  ,
    commentary_intern     LONG VARCHAR,
    commentary_supervisor LONG VARCHAR,
    mid_internship_meeting_date TIMESTAMP,
    title_report          VARCHAR(255),
	intern_id             Int NOT NULL  ,
	mission_id            Int NOT NULL  ,
	company_id            Int NOT NULL  ,
	intern_supervisor_id  Int NOT NULL  ,
	PRIMARY KEY (internship_id)
);



------------------------------------------------------------
-- Table: student
------------------------------------------------------------
CREATE TABLE skill_required(
	skill_id    Int ,
	mission_id  Int ,
	PRIMARY KEY (skill_id,mission_id)
);

------------------------------------------------------------
-- Table: student
------------------------------------------------------------
CREATE TABLE student(
    student_id      INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
    firstname       Varchar(255) NOT NULL  ,
    lastname        Varchar(255) NOT NULL  ,
    student_group  Varchar(255) NOT NULL  ,
    PRIMARY KEY (student_id)
);

ALTER TABLE intern
	ADD CONSTRAINT intern_tutor_FK
	FOREIGN KEY (tutor_id)
	REFERENCES tutor(tutor_id);

ALTER TABLE intern
    ADD CONSTRAINT intern_student_FK
        FOREIGN KEY (student_id)
            REFERENCES student(student_id);

ALTER TABLE internship_supervisor
	ADD CONSTRAINT internship_supervisor_company_FK
	FOREIGN KEY (company_id)
	REFERENCES company(company_id);

ALTER TABLE internship
	ADD CONSTRAINT internship_intern_FK
	FOREIGN KEY (intern_id)
	REFERENCES intern(intern_id);

ALTER TABLE internship
	ADD CONSTRAINT internship_mission_FK
	FOREIGN KEY (mission_id)
	REFERENCES mission(mission_id);

ALTER TABLE internship
	ADD CONSTRAINT internship_company_FK
	FOREIGN KEY (company_id)
	REFERENCES company(company_id);

ALTER TABLE internship
	ADD CONSTRAINT internship_internship_supervisor_FK
	FOREIGN KEY (intern_supervisor_id)
	REFERENCES internship_supervisor(intern_supervisor_id);

ALTER TABLE internship
	ADD CONSTRAINT internship_mission_AK
	UNIQUE (mission_id);

ALTER TABLE skill_required
	ADD CONSTRAINT skill_required_skill_FK
	FOREIGN KEY (skill_id)
	REFERENCES skill(skill_id);

ALTER TABLE skill_required
	ADD CONSTRAINT Skill_required_mission_FK
	FOREIGN KEY (mission_id)
	REFERENCES mission(mission_id);

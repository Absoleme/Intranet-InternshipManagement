#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: tutor
#------------------------------------------------------------

CREATE TABLE tutor(
        tutor_id  Int  Auto_increment  NOT NULL ,
        firstname Varchar (50) NOT NULL ,
        lastname  Varchar (50) NOT NULL ,
        email     Varchar (50) NOT NULL ,
        password  Varchar (50) NOT NULL
	,CONSTRAINT tutor_PK PRIMARY KEY (tutor_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: intern
#------------------------------------------------------------

CREATE TABLE intern(
        intern_id       Int  Auto_increment  NOT NULL ,
        cdc             Bool NOT NULL ,
        fiche_visite    Bool NOT NULL ,
        fiche_evel_entr Bool NOT NULL ,
        sondage_web     Bool NOT NULL ,
        rapport_rendu   Bool NOT NULL ,
        soutenance      Bool NOT NULL ,
        linkedin_url    Varchar (50) NOT NULL ,
        tutor_id        Int NOT NULL
	,CONSTRAINT intern_PK PRIMARY KEY (intern_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: company
#------------------------------------------------------------

CREATE TABLE company(
        company_id Int  Auto_increment  NOT NULL ,
        name       Varchar (50) NOT NULL ,
        street     Varchar (50) NOT NULL ,
        city       Varchar (50) NOT NULL ,
        zipcode    Int NOT NULL
	,CONSTRAINT company_PK PRIMARY KEY (company_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: skill
#------------------------------------------------------------

CREATE TABLE skill(
        skill_id Int  Auto_increment  NOT NULL ,
        name     Varchar (50) NOT NULL
	,CONSTRAINT skill_PK PRIMARY KEY (skill_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: internship supervisor 
#------------------------------------------------------------

CREATE TABLE internship_supervisor(
        intern_supervisor_id Int  Auto_increment  NOT NULL ,
        firstname            Varchar (50) NOT NULL ,
        lastname             Varchar (50) NOT NULL ,
        company_id           Int NOT NULL
	,CONSTRAINT internship_supervisor_PK PRIMARY KEY (intern_supervisor_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: student
#------------------------------------------------------------

CREATE TABLE student(
        student_id     Int  Auto_increment  NOT NULL ,
        firstname      Varchar (50) NOT NULL ,
        lastname       Varchar (50) NOT NULL ,
        student_groupe Varchar (50) NOT NULL
	,CONSTRAINT student_PK PRIMARY KEY (student_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: intership
#------------------------------------------------------------

CREATE TABLE intership(
        stage_id             Int  Auto_increment  NOT NULL ,
        start_date           Date NOT NULL ,
        end_date             Date NOT NULL ,
        intern_id            Int NOT NULL ,
        mission_id           Int NOT NULL ,
        company_id           Int NOT NULL ,
        intern_supervisor_id Int NOT NULL
	,CONSTRAINT intership_PK PRIMARY KEY (stage_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: mission
#------------------------------------------------------------

CREATE TABLE mission(
        mission_id  Int  Auto_increment  NOT NULL ,
        description Longtext NOT NULL ,
        key_words   Longtext NOT NULL ,
        stage_id    Int NOT NULL
	,CONSTRAINT mission_PK PRIMARY KEY (mission_id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Skill Required
#------------------------------------------------------------

CREATE TABLE Skill_Required(
        skill_id   Int NOT NULL ,
        mission_id Int NOT NULL
	,CONSTRAINT Skill_Required_PK PRIMARY KEY (skill_id,mission_id)
)ENGINE=InnoDB;




ALTER TABLE intern
	ADD CONSTRAINT intern_tutor0_FK
	FOREIGN KEY (tutor_id)
	REFERENCES tutor(tutor_id);

ALTER TABLE intern
	ADD CONSTRAINT intern_student_FK
	FOREIGN KEY (student_id)
	REFERENCES student(student_id);

ALTER TABLE internship_supervisor
	ADD CONSTRAINT internship_supervisor_company0_FK
	FOREIGN KEY (company_id)
	REFERENCES company(company_id);

ALTER TABLE intership
	ADD CONSTRAINT intership_intern0_FK
	FOREIGN KEY (intern_id)
	REFERENCES intern(intern_id);

ALTER TABLE intership
	ADD CONSTRAINT intership_mission1_FK
	FOREIGN KEY (mission_id)
	REFERENCES mission(mission_id);

ALTER TABLE intership
	ADD CONSTRAINT intership_company2_FK
	FOREIGN KEY (company_id)
	REFERENCES company(company_id);

ALTER TABLE intership
	ADD CONSTRAINT intership_internship_supervisor3_FK
	FOREIGN KEY (intern_supervisor_id)
	REFERENCES internship_supervisor(intern_supervisor_id);

ALTER TABLE intership 
	ADD CONSTRAINT intership_mission0_AK 
	UNIQUE (mission_id);

ALTER TABLE mission
	ADD CONSTRAINT mission_intership0_FK
	FOREIGN KEY (stage_id)
	REFERENCES intership(stage_id);

ALTER TABLE mission 
	ADD CONSTRAINT mission_intership0_AK 
	UNIQUE (stage_id);

ALTER TABLE Skill_Required
	ADD CONSTRAINT Skill_Required_skill0_FK
	FOREIGN KEY (skill_id)
	REFERENCES skill(skill_id);

ALTER TABLE Skill_Required
	ADD CONSTRAINT Skill_Required_mission1_FK
	FOREIGN KEY (mission_id)
	REFERENCES mission(mission_id);

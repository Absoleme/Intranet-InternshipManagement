/* Tutor data */
insert into TUTOR VALUES (default, 'John', 'Smith', 'john.smith@efrei.fr', 'dcc876578e6fb0950cca2cf98457104b');
insert into TUTOR VALUES (default, 'Lea', 'Conny', 'lea.conny@efrei.fr', 'dcc876578e6fb0950cca2cf98457104b');

/**
    Student data
    10 students
**/
INSERT INTO STUDENT (firstname,lastname,student_group) VALUES ('Flynn','Hopkins','M2');
INSERT INTO STUDENT (firstname,lastname,student_group) VALUES ('Kerry','Barrett','L3');
INSERT INTO STUDENT (firstname,lastname,student_group) VALUES ('David','White','L3');
INSERT INTO STUDENT (firstname,lastname,student_group) VALUES ('Oscar','Ball','L3');
INSERT INTO STUDENT (firstname,lastname,student_group) VALUES ('Bradley','Stuart','M1');
INSERT INTO STUDENT (firstname,lastname,student_group) VALUES ('Portia','Sparks','L2');
INSERT INTO STUDENT (firstname,lastname,student_group) VALUES ('Germane','Holder','M1');
INSERT INTO STUDENT (firstname,lastname,student_group) VALUES ('Judah','Le','L1');
INSERT INTO STUDENT (firstname,lastname,student_group) VALUES ('Lydia','Raymond','L3');
INSERT INTO STUDENT (firstname,lastname,student_group) VALUES ('Drake','Drake','M1');

/**
    Interns data
    10 interns
**/
INSERT INTO INTERN (tutor_id,student_id) VALUES (2,1);
INSERT INTO INTERN (tutor_id,student_id) VALUES (1,2);
INSERT INTO INTERN (tutor_id,student_id) VALUES (1,3);
INSERT INTO INTERN (tutor_id,student_id) VALUES (1,4);
INSERT INTO INTERN (tutor_id,student_id) VALUES (2,5);
INSERT INTO INTERN (tutor_id,student_id) VALUES (1,6);
INSERT INTO INTERN (tutor_id,student_id) VALUES (1,7);
INSERT INTO INTERN (tutor_id,student_id) VALUES (1,8);
INSERT INTO INTERN (tutor_id,student_id) VALUES (1,9);
INSERT INTO INTERN (tutor_id,student_id) VALUES (2,10);

/**
  Company data
 */
insert into COMPANY (name, street_number, street_name, city, zipcode) values ('Washington Prime Group Inc.', 18, 'Dawn', 'Lille', '59000');
insert into COMPANY (name, street_number, street_name, city, zipcode) values ('Miragen Therapeutics, Inc.', 97, 'Sutherland', 'Lyon', '69000');
insert into COMPANY (name, street_number, street_name, city, zipcode) values ('Sypris Solutions, Inc.', 60, 'Anzinger', 'Villejuif', '94800');
insert into COMPANY (name, street_number, street_name, city, zipcode) values ('Motif Bio plc', 44, 'Dryden', 'Paris', '75000');
insert into COMPANY (name, street_number, street_name, city, zipcode) values ('Pretium Resources, Inc.', 38, 'Bartillon', 'Lyon', '69000');
insert into COMPANY (name, street_number, street_name, city, zipcode) values ('Brown & Brown, Inc.', 74, 'Lillian', 'Lyon', '69000');
insert into COMPANY (name, street_number, street_name, city, zipcode) values ('Brown Forman Corporation', 40, 'Lunder', 'Paris', '75000');
insert into COMPANY (name, street_number, street_name, city, zipcode) values ('Vanguard Russell 1000 ETF', 43, 'Menomonie', 'Villejuif', '94800');
insert into COMPANY (name, street_number, street_name, city, zipcode) values ('Invesco Mortgage Capital Inc.', 64, 'Mendota', 'Dijon', '21000');
insert into COMPANY (name, street_number, street_name, city, zipcode) values ('Information Services Group, Inc.', 47, 'Maple Wood', 'Villejuif', '94800');

/**
  Mission data
 */
insert into MISSION (description, key_words) values ('Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.', 'Full Stack Developer');
insert into MISSION (description, key_words) values ('Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla.', 'Back End Developer');
insert into MISSION (description, key_words) values ('Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', 'DevOps Engineer');
insert into MISSION (description, key_words) values ('Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus.', 'Full Stack Developer');
insert into MISSION (description, key_words) values ('Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum.', 'Front End Developer');
insert into MISSION (description, key_words) values ('Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', 'Front End Developer');
insert into MISSION (description, key_words) values ('Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius. Integer ac leo. Pellentesque ultrices mattis odio.', 'Back End Developer');
insert into MISSION (description, key_words) values ('Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', 'DevOps Engineer');
insert into MISSION (description, key_words) values ('Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor.', 'Front End Developer');
insert into MISSION (description, key_words) values ('Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet.', 'DevOps Engineer');

/**
  Internship Supervisor
 */
insert into INTERNSHIP_SUPERVISOR (firstname, lastname, company_id) values ('Leroi', 'Dadd', 1);
insert into INTERNSHIP_SUPERVISOR (firstname, lastname, company_id) values ('Nikola', 'Iredale', 2);
insert into INTERNSHIP_SUPERVISOR (firstname, lastname, company_id) values ('Darcee', 'Hassard', 3);
insert into INTERNSHIP_SUPERVISOR (firstname, lastname, company_id) values ('Gussy', 'Jopson', 4);
insert into INTERNSHIP_SUPERVISOR (firstname, lastname, company_id) values ('Whitman', 'Lomas', 5);
insert into INTERNSHIP_SUPERVISOR (firstname, lastname, company_id) values ('Arnaldo', 'Ales0', 6);
insert into INTERNSHIP_SUPERVISOR (firstname, lastname, company_id) values ('Eugen', 'Ismead', 7);
insert into INTERNSHIP_SUPERVISOR (firstname, lastname, company_id) values ('Cherilynn', 'McRoberts', 8);
insert into INTERNSHIP_SUPERVISOR (firstname, lastname, company_id) values ('Tandie', 'Graveney', 9);
insert into INTERNSHIP_SUPERVISOR (firstname, lastname, company_id) values ('Saundra', 'Crehan', 10);

/**
  Internship data
 */
insert into INTERNSHIP (start_date, end_date, mid_internship_meeting_date, intern_id, mission_id, company_id, intern_supervisor_id, note_tech, note_com, commentary_intern, commentary_supervisor, title_report) values ('2020-06-13', '2020-10-25', '2020-08-15 09:52:42', 1, 1, 1, 1, 14, 20, 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.', 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue.', 'Balanced uniform installation');
insert into INTERNSHIP (start_date, end_date, mid_internship_meeting_date, intern_id, mission_id, company_id, intern_supervisor_id, note_tech, note_com, commentary_intern, commentary_supervisor, title_report) values ('2019-03-31', '2019-05-23', '2019-04-09 17:12:40', 2, 2, 2, 2, 14, 13, 'Sed ante. Vivamus tortor.', 'Suspendisse accumsan tortor quis turpis.', 'Public-key executive task-force');
insert into INTERNSHIP (start_date, end_date, mid_internship_meeting_date, intern_id, mission_id, company_id, intern_supervisor_id, note_tech, note_com, commentary_intern, commentary_supervisor, title_report) values ('2018-05-16', '2018-11-26', '2018-08-16 11:54:23', 3, 3, 3, 3, 20, 14, 'Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', 'Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque.', 'Operative tangible internet solution');
insert into INTERNSHIP (start_date, end_date, mid_internship_meeting_date, intern_id, mission_id, company_id, intern_supervisor_id, note_tech, note_com, commentary_intern, commentary_supervisor, title_report) values ('2018-01-20', '2018-08-08', '2018-05-19 07:20:41', 4, 4, 4, 4, 14, 17, 'Aliquam erat volutpat.', 'Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', 'Networked intermediate conglomeration');
insert into INTERNSHIP (start_date, end_date, mid_internship_meeting_date, intern_id, mission_id, company_id, intern_supervisor_id, note_tech, note_com, commentary_intern, commentary_supervisor, title_report) values ('2019-07-19', '2019-12-03', '2019-09-29 15:25:16', 5, 5, 5, 5, 12, 12, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Fusce consequat. Nulla nisl. Nunc nisl.', 'Virtual neutral database');
insert into INTERNSHIP (start_date, end_date, mid_internship_meeting_date, intern_id, mission_id, company_id, intern_supervisor_id, note_tech, note_com, commentary_intern, commentary_supervisor, title_report) values ('2020-01-17', '2020-04-13', '2020-02-17 14:37:19', 6, 6, 6, 6, 14, 14, 'Duis consequat dui nec nisi volutpat eleifend.', 'Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', 'Enterprise-wide grid-enabled superstructure');
insert into INTERNSHIP (start_date, end_date, mid_internship_meeting_date, intern_id, mission_id, company_id, intern_supervisor_id, note_tech, note_com, commentary_intern, commentary_supervisor, title_report) values ('2020-03-08', '2020-06-11', '2020-05-01 22:43:12', 7, 7, 7, 7, 15, 18, 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 'Proin risus. Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', 'Proactive solution-oriented extranet');
insert into INTERNSHIP (start_date, end_date, mid_internship_meeting_date, intern_id, mission_id, company_id, intern_supervisor_id, note_tech, note_com, commentary_intern, commentary_supervisor, title_report) values ('2020-04-10', '2020-10-21', '2020-06-18 11:05:47', 8, 8, 8, 8, 12, 18, 'Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis.', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 'Progressive 4th generation synergy');
insert into INTERNSHIP (start_date, end_date, mid_internship_meeting_date, intern_id, mission_id, company_id, intern_supervisor_id, note_tech, note_com, commentary_intern, commentary_supervisor, title_report) values ('2020-01-12', '2020-03-22', '2020-02-04 07:46:38', 9, 9, 9, 9, 13, 17, 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 'Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum.', 'Streamlined mission-critical service-desk');
insert into INTERNSHIP (start_date, end_date, mid_internship_meeting_date, intern_id, mission_id, company_id, intern_supervisor_id, note_tech, note_com, commentary_intern, commentary_supervisor, title_report) values ('2019-02-13', '2019-09-26', '2019-05-03 07:42:23', 10, 10, 10, 10, 19, 20, 'Suspendisse accumsan tortor quis turpis. Sed ante.', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.', 'Diverse non-volatile neural-net');
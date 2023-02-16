insert into categories values(1, 'hi');
insert into questions values(1, 'this is questions', 1);
insert into questions values(2, 'this is questions2', 1);
insert into questions values(3, 'this is questions3', 1);
insert into questions values(4, 'this is questions4', 1);
insert into mentors (mentor_id, age, email, nickname, category_id) values (1, 10, '', '', 1);
insert into mentors (mentor_id, age, email, nickname, category_id) values (2, 10, '', '', 1);
insert into mentees (mentee_id, age, email, nickname) values (1, 10, '', '');
insert into applys values(1, '2019-12-11T00:00:00.000000', '2019-12-11T00:00:00.000000', '2019-12-11T00:00:00.000000', '2019-12-11T00:00:00.000000', '0', 1, 1, 1);
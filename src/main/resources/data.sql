INSERT INTO consumer (id, address, fullname) VALUES (1, 'Borislav1', 'Roman Demkiv');
INSERT INTO consumer (id, address, fullname) VALUES (2, 'Borislav2', 'Taras Demkiv');
INSERT INTO consumer (id, address, fullname) VALUES (3, 'Borislav3', 'Sofija Demkiv');

insert into message (id, message, createdate, expiredate, selected) values (1, 'first message', '2021-01-14', '2021-01-14', false);
insert into message (id, message, createdate, expiredate, selected) values (2, 'second message', '2021-01-15', '2021-01-17', false);
insert into message (id, message, createdate, expiredate, selected) values (3, 'third message', '2021-01-14', '2021-01-15', true);
insert into message (id, message, createdate, expiredate, selected) values (4, 'first message for TD', '2021-01-14', '2021-01-19', false);

insert into sum values (1, 1203.45, '2021-10-01', '', 1);
insert into sum values (2, 1500.00, '2021-10-01', 'This sum belong to Taras Demkiv', 1);
insert into sum values (3, 600.45, '2021-10-01', '', 3);

insert into invoice_item values (1, 'Шарм вершковий', 2.2);
insert into invoice_item values (2, 'Шарм горіховий', 2.2);
insert into invoice_item values (3, 'Шарм з цілим фундуком', 2.2);
insert into invoice_item values (4, 'Труфальє', 4.0);

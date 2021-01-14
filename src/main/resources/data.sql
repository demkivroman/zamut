INSERT INTO consumer (id, address, fullname) VALUES (1, 'Borislav1', 'Roman Demkiv');
INSERT INTO consumer (id, address, fullname) VALUES (2, 'Borislav2', 'Taras Demkiv');
INSERT INTO consumer (id, address, fullname) VALUES (3, 'Borislav3', 'Sofija Demkiv');

insert into message (id, message, createdate, expiredate, selected) values (1, 'first message', '2021-01-14', '2021-01-14', false);
insert into message (id, message, createdate, expiredate, selected) values (2, 'second message', '2021-01-15', '2021-01-17', false);
insert into message (id, message, createdate, expiredate, selected) values (3, 'third message', '2021-01-14', '2021-01-15', true);
insert into message (id, message, createdate, expiredate, selected) values (4, 'first message for TD', '2021-01-14', '2021-01-19', false);

insert into invoice values (1, '2021-01-05');
insert into invoice values (2, '2021-04-01');
insert into invoice values (3, '2021-04-01');

insert into sum values (1, 1203.45, '', 1, 1);
insert into sum values (2, 1500.00, 'This sum belong to Taras Demkiv', 1, 2);
insert into sum values (3, 600.45, '', 3, 3);

insert into invoice_item values (1, 'Шарм вершковий', 363.00, 2.2);
insert into invoice_item values (2, 'Шарм горіховий', 363.00, 2.2);
insert into invoice_item values (3, 'Шарм з цілим фундуком', 410.00, 2.2);
insert into invoice_item values (4, 'Труфальє', 560.00, 4.0);

insert into invoice_item_collaborator values (1, 1);
insert into invoice_item_collaborator values (1, 2);
insert into invoice_item_collaborator values (1, 4);

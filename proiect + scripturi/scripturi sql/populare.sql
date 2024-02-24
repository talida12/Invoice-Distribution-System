/* Populare tabela Client */

INSERT INTO Client (id_c, nume, adresa) VALUES ('2','Daniela Popescu','Oradea, str.Crinului');
INSERT INTO Client (id_c, nume, adresa) VALUES ('3','Lucian Georgescu','Slobozia, str. Emil Cioran');
INSERT INTO Client (id_c, nume, adresa) VALUES ('4','Lucia Popa','Lugoj, str. Mihai Viteazu');
INSERT INTO Client (id_c, nume, adresa) VALUES ('5','Andrei Ciobanu','Târgu-Jiu, str. Victoriei');
INSERT INTO Client (id_c, nume, adresa) VALUES ('6','Robert Turcu','Craiova, str. Lămâiței');
INSERT INTO Client (id_c, nume, adresa) VALUES ('7','Oana Mălăescu','Craiova, str.Păltiniș');
INSERT INTO Client (id_c, nume, adresa) VALUES ('8','Ramona Bălcescu','Târgoviște, str. Unirii');
INSERT INTO Client (id_c, nume, adresa) VALUES ('9','Răzvan Niculete','Aleșd, str. Romanești');
INSERT INTO Client (id_c, nume, adresa) VALUES ('10','Lucreția Bizu','Predeal, str. Revoluției');
INSERT INTO Client (id_c, nume, adresa) VALUES ('11','David Lucaci','Lugoj, str.Calea Călărași');


/* Populare tabela Factura */
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('1', '2022-10-23', '5', '3', '24', '360', '68.4', '7');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('2', '2021-11-01', '4', '2', '27', '216', '41.04', '4');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('3', '2022-10-18', '2', '1', '25', '50', '9.5', '3');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('4', '2022-09-04', '3', '3', '17', '153', '29.07', '10');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('5', '2022-08-07', '3', '9', '10', '270', '51.3', '6');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('6', '2022-04-13', '2', '5', '7', '70' , '13.3', '9');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('7', '2022-04-21', '4', '6', '12', '288', '54.72', '2');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('8', '2021-01-11', '1', '6', '15', '90', '17.1', '5');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('9', '2022-01-03', '6', '6', '15', '540', '102.6', '5');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('10', '2022-01-08', '6', '8', '20', '960', '182.4', '7');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('11', '2022-12-14', '4', '6', '10', '240',  '45.6', '2');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('12', '2022-12-10', '5', '7', '10', '350',  '66.5', '8');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('13', '2022-12-21', '4', '5', '20', '400', '76', '8');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('14', '2022-12-21', '5', '4', '20', '400', '76', '9');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('15', '2022-12-30', '5', '5', '20', '500', '95', '11');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('16', '2023-01-05', '3', '4', '20', '240', '45.6', '6');
INSERT INTO Factura (id_f, data, nr_pagini, cost_pagina, nr_zile, valoare, tva, id_c) VALUES ('17', '2023-01-07', '2', '5', '20', '200', '38', '6');

SELECT * FROM Factura;

/* Populare tabela Localitate */

INSERT INTO Localitate (id_l, denumire) VALUES ('1', 'Târgoviște');
INSERT INTO Localitate (id_l, denumire) VALUES ('2', 'Slobozia');
INSERT INTO Localitate (id_l, denumire) VALUES ('3', 'Moreni');
INSERT INTO Localitate (id_l, denumire) VALUES ('4', 'Aiud');
INSERT INTO Localitate (id_l, denumire) VALUES ('5', 'Aleșd');
INSERT INTO Localitate (id_l, denumire) VALUES ('6', 'Predeal');
INSERT INTO Localitate (id_l, denumire) VALUES ('7', 'Lugoj');
INSERT INTO Localitate (id_l, denumire) VALUES ('8', 'Târgu-Jiu');
INSERT INTO Localitate (id_l, denumire) VALUES ('9', 'Craiova');
INSERT INTO Localitate (id_l, denumire) VALUES ('10', 'Oradea');


/* Populare tabela Difuzare */

INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('1', '9', '2021-10-23', '2022-11-16');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('2', '7', '2021-11-01', '2021-11-28');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('3', '2', '2022-10-18', '2022-11-13');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('4', '6', '2022-09-04', '2022-09-21');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('6', '5', '2022-04-13', '2022-04-20');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('6', '2', '2022-04-13', '2022-04-20');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('7', '10', '2021-04-21', '2022-05-03');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('11', '5', '2022-12-14', '2022-12-24');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('11', '10', '2022-12-14', '2022-12-24');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('12', '1', '2022-12-10', '2022-12-20');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('13', '1', '2022-12-21', '2023-01-10');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('14', '5', '2022-12-21', '2023-01-10');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('14', '10', '2022-12-21', '2023-01-10');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('15', '7', '2022-12-30', '2023-01-19');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('16', '9', '2023-01-05', '2023-01-25');
INSERT INTO Difuzare (id_f, id_l, datai, datas) VALUES ('17', '9', '2023-01-07', '2023-01-27');

SELECT * FROM Difuzare;
/* Creare Sistem de distribuire al facturilor */

CREATE DATABASE SistemDifuzareFacturi;
USE SistemDifuzareFacturi;
CREATE TABLE Client (
    id_c INT,
    nume VARCHAR(50) NOT NULL, 
    adresa VARCHAR(70) NOT NULL
);

CREATE TABLE Factura (
    id_f INT,
    data DATE NOT NULL,
    nr_pagini INT NOT NULL,
    cost_pagina DOUBLE NOT NULL,
    nr_zile INT NOT NULL,
    valoare DOUBLE NOT NULL,
    tva DOUBLE NOT NULL,
    id_c INT
);

CREATE TABLE Localitate (
    id_l INT,
    denumire VARCHAR(25) NOT NULL
);

CREATE TABLE Difuzare (
    id_f INT,
    id_l INT,
    datai DATE NOT NULL, 
    datas DATE NOT NULL
);

/* Declararea cheilor primare si straine */

ALTER TABLE Client
ADD PRIMARY KEY(id_c);

ALTER TABLE Factura
ADD PRIMARY KEY(id_f);

ALTER TABLE Factura
ADD FOREIGN KEY (id_c) REFERENCES Client(id_c);

ALTER TABLE Localitate 
ADD PRIMARY KEY(id_l);

ALTER TABLE Difuzare 
ADD FOREIGN KEY(id_f) REFERENCES Factura(id_f);

ALTER TABLE Difuzare
ADD FOREIGN KEY (id_l) REFERENCES Localitate(id_l);

ALTER TABLE Difuzare
ADD PRIMARY KEY (id_f, id_l);

/* Adaugarea atributului valoare_totala in tabela Factura */

ALTER TABLE Factura
ADD valoare_totala DOUBLE AS (valoare + tva);

/* Adaugarea constrangerilor */

ALTER TABLE Factura
DROP Constraint tva_const_ck;

ALTER TABLE Factura
ADD CONSTRAINT tva_const_ck CHECK (0.19 * valoare = tva);

ALTER TABLE Client
ADD CONSTRAINT adresa_const_ck CHECK (nume NOT LIKE 'firma%' OR adresa LIKE '%sediu social%');

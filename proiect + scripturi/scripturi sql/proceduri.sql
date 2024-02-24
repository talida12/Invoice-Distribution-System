USE SistemDifuzareFacturi;

DROP PROCEDURE facturi_cu_valoarea_intre;
CREATE PROCEDURE facturi_cu_valoarea_intre(IN minim DOUBLE, IN maxim DOUBLE)
	SELECT * FROM Factura
	WHERE (valoare > minim AND valoare < maxim)
	ORDER BY data DESC, valoare;
    
DROP PROCEDURE localitati_care_contin_subsirul;
CREATE PROCEDURE localitati_care_contin_subsirul(IN subsir VARCHAR(25))
	SELECT denumire AS localitate
	FROM Localitate
	WHERE LOWER(denumire) LIKE CONCAT('%',subsir,'%')
	ORDER BY denumire;
    
DROP PROCEDURE facturi_pe_doua_localitati;
CREATE  PROCEDURE facturi_pe_doua_localitati(IN localitate1 VARCHAR(25), IN localitate2 VARCHAR(25))
	SELECT DISTINCT C.nume
	FROM Client C JOIN Factura F ON (C.id_c = F.id_c ) 
	JOIN Difuzare D ON (D.id_f = F.id_f) 
	JOIN Localitate L ON (L.id_l = D.id_l)
    JOIN Factura F2 ON (C.id_c = F2.id_c)
    JOIN Difuzare D2 ON (F2.id_f = D2.id_f)
    JOIN Localitate L2 ON (L2.id_l = D2.id_l)
	WHERE(L.denumire = localitate1 AND L2.denumire = localitate2 );

DROP PROCEDURE perechi_de_localitati;
CREATE PROCEDURE perechi_de_localitati()
	SELECT DISTINCT D1.id_l AS localitate1, D2.id_l AS localitate2
	FROM Difuzare D1 JOIN Difuzare D2
	ON D1.id_f = D2.id_f
	WHERE D1.datai = D2.datai AND D1.datas = D2.datas AND D1.id_l < D2.id_l;
    
DROP PROCEDURE difuzari_in_luna_valoare_sub;
CREATE PROCEDURE difuzari_in_luna_valoare_sub ( IN dataMin DATE, IN dataMax DATE, IN valoareMax int)
	SELECT DISTINCT L.denumire /*, D.datai, D.datas, F.valoare*/
	FROM Localitate L JOIN Difuzare D ON (L.id_l = D.id_l)
	/*JOIN Factura F ON (D.id_f = F.id_f)*/
	WHERE  D.id_l IN (
		SELECT id_l FROM Difuzare 
		WHERE (datai >= dataMin AND datai <= dataMax)
		OR (datas >= dataMin AND datas <= dataMax))
	AND D.id_f IN (
		SELECT id_f FROM Factura
		WHERE valoare_totala < valoareMax);

DROP PROCEDURE client_factura_cel_mai_mic_numar_de_zile_din_an;
CREATE PROCEDURE client_factura_cel_mai_mic_numar_de_zile_din_an (IN an INT)
	SELECT C.nume, F.nr_zile
	FROM Client C JOIN Factura F ON (C.id_c = F.id_c)
	WHERE EXTRACT(YEAR from data) = an and F.nr_zile <= ALL(
		SELECT nr_zile 
		FROM Factura
		WHERE EXTRACT(YEAR from data) = an );
                
DROP PROCEDURE pagini_difuzate_in_data_curenta;
CREATE PROCEDURE pagini_difuzate_in_data_curenta()
	SELECT L.denumire, SUM(F.nr_pagini) AS total_nr_pagini
	FROM Localitate L LEFT JOIN Difuzare D ON (D.id_l = L.id_l)
	LEFT JOIN Factura F ON (D.id_f = F.id_f AND F.data = CURDATE())
	GROUP BY L.denumire;

DROP PROCEDURE statistica_pentru_anul;
CREATE PROCEDURE statistica_pentru_anul(IN an INT)
	SELECT MIN(valoare_totala) AS valoare_minima, AVG(valoare_totala) AS valoare_medie, MAX(valoare_totala) AS valoare_maxima
	FROM Factura
	WHERE EXTRACT(YEAR from data) = an;
    
CREATE procedure extrage_clienti()
	SELECT * FROM Client;
DROP PROCEDURE extrage_clienti;

CREATE procedure extrage_facturi()
	SELECT * FROM Factura;
DROP PROCEDURE extrage_facturi;

CREATE procedure extrage_difuzari()
	SELECT * from Difuzare;
DROP PROCEDURE extrage_difuzari;

CREATE PROCEDURE extrage_localitati()
	SELECT * FROM Localitate;
DROP PROCEDURE extrage_localitati;
    
SELECT * FROM Factura;
CALL facturi_cu_valoarea_intre(200, 500);
CALL localitati_care_contin_subsirul('u-j');
CALL facturi_pe_doua_localitati('Oradea', 'Aleșd');
CALL perechi_de_localitati();
CALL difuzari_in_luna_valoare_sub('2022-10-01', '2022-10-31', 100);
CALL client_factura_cel_mai_mic_numar_de_zile_din_an(2022);
CALL pagini_difuzate_in_data_curenta();
CALL statistica_pentru_anul(2022);
CALL extrage_clienti;
CALL extrage_facturi;
CALL extrage_difuzari;
CALL extrage_localitati;
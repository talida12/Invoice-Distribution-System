package repository;

import models.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static String databaseURL = "jdbc:mysql://localhost:3306/SistemDifuzareFacturi";
    private static String username = "root";
    private static String password = "mysql";

    private Repository() {}

    public static List<Client> extrageClienti() {
        List<Client> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL, username, password)) {
            PreparedStatement p = connection.prepareStatement(
                    "SELECT * FROM Client");
            // cursor
            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()) {
                int idClient = resultSet.getInt("id_c");
                String nume = resultSet.getString("nume");
                String adresa = resultSet.getString("adresa");
                Client c = new Client(idClient, nume, adresa);
                list.add(c);
            }
        } catch (SQLException ignored) {}

        return list;
    }

    public static List<Factura> extrageFacturi(){
        List<Factura> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL, username, password)) {
            PreparedStatement p = connection.prepareStatement(
                    "CALL extrage_facturi()");
            // cursor
            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()) {
                int idFactura = resultSet.getInt("id_f");
                LocalDate data = resultSet.getDate("data").toLocalDate();
                int nrPagini = resultSet.getInt("nr_pagini");
                double costPagina = resultSet.getDouble("cost_pagina");
                int nrZile = resultSet.getInt("nr_zile");
                double valoare = resultSet.getDouble("valoare");
                double tva = resultSet.getDouble("tva");
                int idClient = resultSet.getInt("id_c");
                double valoareTotala = resultSet.getDouble("valoare_totala");
                Factura f = new Factura(idFactura, data, nrPagini, costPagina, nrZile, valoare, tva, idClient, valoareTotala);
                list.add(f);
            }
        } catch (SQLException ignored) {}

        return list;
    }
    public static List<Difuzare> extrageDifuzari(){
        List<Difuzare> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL, username, password)) {
            PreparedStatement p = connection.prepareStatement(
                    "CALL extrage_difuzari()");
            // cursor
            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()) {
                int idFactura = resultSet.getInt("id_f");
                int idLocalitate = resultSet.getInt("id_l");
                LocalDate dataI = resultSet.getDate("datai").toLocalDate();
                LocalDate dataS = resultSet.getDate("datas").toLocalDate();
                Difuzare d = new Difuzare(idFactura, idLocalitate, dataI, dataS);
                list.add(d);
            }
        } catch (SQLException ignored) {}

        return list;
    }
    public static List<Localitate> extrageLocalitati() {
        List<Localitate> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL, username, password)) {
            PreparedStatement p = connection.prepareStatement(
                    "CALL extrage_localitati()");
            // cursor
            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()) {
                int idLocalitate = resultSet.getInt("id_l");
                String denumireLocalitate = resultSet.getString("denumire");
                Localitate l = new Localitate(idLocalitate, denumireLocalitate);
                list.add(l);
            }
        } catch (SQLException ignored) {
        }
        return list;
    }

        public static List<Factura> facturiCuValoareaIntre(double minim, double maxim) {
        List<Factura> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL, username, password)) {
            PreparedStatement p = connection.prepareStatement(
                    "CALL facturi_cu_valoarea_intre(?, ?)");
            p.setDouble(1, minim);
            p.setDouble(2, maxim);

            // cursor
            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()) {
                int idFactura = resultSet.getInt("id_f");
                LocalDate data = resultSet.getDate("data").toLocalDate();
                int nrPagini = resultSet.getInt("nr_pagini");
                double costPagina = resultSet.getDouble("cost_pagina");
                int nrZile = resultSet.getInt("nr_zile");
                double valoare = resultSet.getDouble("valoare");
                double tva = resultSet.getDouble("tva");
                int idClient = resultSet.getInt("id_c");
                double valoareTotala = resultSet.getDouble("valoare_totala");
                Factura f = new Factura(idFactura, data, nrPagini, costPagina, nrZile, valoare, tva, idClient, valoareTotala);
                list.add(f);
            }
        } catch (SQLException ignored) {}

        return list;
    }

    public static List<Localitate> localitatiCareContinSubsirul(String subsir){
        List<Localitate> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL, username, password)) {
            PreparedStatement p = connection.prepareStatement(
                    "CALL localitati_care_contin_subsirul(?)");
            p.setString(1, subsir);

            //cursor
            ResultSet resultSet = p.executeQuery();

            while(resultSet.next()){
                String denumire = resultSet.getString("localitate");
                Localitate l = new Localitate(0, denumire);
                list.add(l);
            }
        } catch (SQLException ignored) {}

        return list;
    }

    public static List<Client> facturiPeDouaLocalitati( String localitate1, String localitate2 ){
        List<Client> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL, username, password)) {
            PreparedStatement p = connection.prepareStatement(
                    "CALL facturi_pe_doua_localitati(?, ?)");
            p.setString(1, localitate1);
            p.setString(2, localitate2);

            //cursor
            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()){
                String nume = resultSet.getString("nume");
                Client c = new Client(0, nume, null);
                list.add(c);
            }

        }catch (SQLException ignored) {}

        return list;
    }

    public static List<Pair<Localitate, Localitate>> perechiDeLocalitati(){
        List<Pair<Localitate, Localitate>> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL, username, password)) {
            PreparedStatement p = connection.prepareStatement(
                    "CALL perechi_de_localitati()");

            //cursor
            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()){
                int idLocalitate1 = resultSet.getInt("localitate1");
                int idLocalitate2 = resultSet.getInt("localitate2");
                Localitate l1 = new Localitate(idLocalitate1, null);
                Localitate l2 = new Localitate(idLocalitate2, null);
                list.add(new Pair<Localitate, Localitate>(l1, l2));
            }
        }catch (SQLException ignored) {}

        return list;
    }

    public static List<Localitate> difuzariInLunaValoareSub(YearMonth yearMonth, double valoare) {
        LocalDate begin = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), 1);
        LocalDate end = yearMonth.atEndOfMonth();
        List<Localitate> list = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(databaseURL, username, password)) {
            PreparedStatement p = connection.prepareStatement(
                    "CALL difuzari_in_luna_valoare_sub(?, ?, ?)");
            p.setDate(1, Date.valueOf(begin));
            p.setDate(2, Date.valueOf(end));
            p.setDouble(3, valoare);

            //cursor
            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()){
                String denumire = resultSet.getString("denumire");
                Localitate l = new Localitate(0, denumire);
                list.add(l);
            }
        } catch (SQLException ignored) {}
        return list;
    }

    public static List<Pair<Client, Factura>> clientFacturaCelMaiMicNumarDeZileDinAn(int an){
        List<Pair<Client, Factura>> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL, username, password)) {
            PreparedStatement p = connection.prepareStatement(
                    "CALL client_factura_cel_mai_mic_numar_de_zile_din_an(?)");
            p.setInt(1, an);

            //cursor
            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()) {
                String nume = resultSet.getString("nume");
                int nrZile = resultSet.getInt("nr_zile");
                Client c = new Client(0, nume, null);
                Factura f = new Factura(0, null, 0, 0, nrZile,
                        0, 0, 0, 0);
                list.add(new Pair<Client, Factura>(c, f));
            }
        } catch (SQLException ignored) {}

        return list;
    }

    public static List<Pair<Localitate, Integer>> paginiDifuzateInDataCurenta() {
        List<Pair<Localitate, Integer>> list = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(databaseURL, username, password)) {
            PreparedStatement p = connection.prepareStatement(
                    "CALL pagini_difuzate_in_data_curenta()");

            //cursor
            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()) {
                String denumire = resultSet.getString("denumire");
                int totalNrPagini = resultSet.getInt("total_nr_pagini");
                Localitate l = new Localitate(0, denumire);
                list.add(new Pair<Localitate, Integer>(l, totalNrPagini));
            }
        } catch (SQLException ignored) {}

        return list;
    }

    public static double[] statisticaPentruAnul(int an) {
        double[] valori = new double[3];
        try (Connection connection = DriverManager.getConnection(databaseURL, username, password)) {
            PreparedStatement p = connection.prepareStatement(
                    "CALL statistica_pentru_anul(?)");
            p.setInt(1, an);

            //cursor
            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()) {
                valori[0] = resultSet.getDouble("valoare_minima");
                valori[1] = resultSet.getDouble("valoare_medie");
                valori[2] = resultSet.getDouble("valoare_maxima");
            }
        } catch (SQLException ignored) {}
        return valori;
    }


    public static void main(String[] args) {
        Repository r = new Repository();
        System.out.println("5.3.a)");
        for (Factura f : r.facturiCuValoareaIntre(500, 1000)) {
            System.out.println(f);
        }
        System.out.println("5.3.b)");
        for ( Localitate l : r.localitatiCareContinSubsirul("j")){
            System.out.println(l.getDenumire());
        }
        System.out.println("5.4.a)");
        for ( Client c : r.facturiPeDouaLocalitati("Oradea", "Aleșd")) {
            System.out.println(c.getNume());
        }

        System.out.println("5.4.b)");
        for ( Pair<Localitate, Localitate> pair : r.perechiDeLocalitati()){
            System.out.println(pair.first().getIdLocalitate() + " - " + pair.second().getIdLocalitate());
        }

        System.out.println("5.5.a)");
        YearMonth yearMonth = YearMonth.of(2022, 10);
        for (Localitate l : r.difuzariInLunaValoareSub(yearMonth, 100)) {
            System.out.println(l.getDenumire());
        }

        System.out.println("5.5.b)");
        for (Pair<Client, Factura> pair : r.clientFacturaCelMaiMicNumarDeZileDinAn(2022)){
            System.out.println(pair.first().getNume() + ", " + pair.second().getNrZile());
        }

        System.out.println("5.6.a)");
        for (Pair<Localitate, Integer> pair : r.paginiDifuzateInDataCurenta()) {
            System.out.println(pair.first().getDenumire() + ", total pagini: " + pair.second());
        }

        System.out.println("5.6.b)");
        double[] valori = r.statisticaPentruAnul(2022);
        System.out.println("valoare minima: " + valori[0]);
        System.out.println("valoare medie: " + valori[1]);
        System.out.println("valoare maxima: " + valori[2]);
    }
}

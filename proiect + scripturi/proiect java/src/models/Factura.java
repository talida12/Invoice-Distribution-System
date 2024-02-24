package models;

import java.time.LocalDate;

public class Factura {
    private int idFactura;
    private LocalDate data;
    private int nrPagini;
    private double costPagina;
    private int nrZile;
    private double valoare;
    private double tva;
    private int idClient;
    private double valoareTotala;

    public Factura(int idFactura, LocalDate data, int nrPagini, double costPagina, int nrZile, double valoare, double tva, int idClient, double valoareTotala) {
        this.idFactura = idFactura;
        this.data = data;
        this.nrPagini = nrPagini;
        this.costPagina = costPagina;
        this.nrZile = nrZile;
        this.valoare = valoare;
        this.tva = tva;
        this.idClient = idClient;
        this.valoareTotala = valoareTotala;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public LocalDate getData() {
        return data;
    }

    public int getNrPagini() {
        return nrPagini;
    }

    public double getCostPagina() {
        return costPagina;
    }

    public int getNrZile() {
        return nrZile;
    }

    public double getValoare() {
        return valoare;
    }

    public double getTva() {
        return tva;
    }

    public int getIdClient() {
        return idClient;
    }

    public double getValoareTotala() {
        return valoareTotala;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", data=" + data +
                ", nrPagini=" + nrPagini +
                ", costPagina=" + costPagina +
                ", nrZile=" + nrZile +
                ", valoare=" + valoare +
                ", tva=" + tva +
                ", idClient=" + idClient +
                '}';
    }
}

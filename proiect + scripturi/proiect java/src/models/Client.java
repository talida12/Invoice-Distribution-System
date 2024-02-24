package models;

public class Client {
    private int idClient;
    private String nume;
    private String adresa;

    public Client(int idClient, String nume, String adresa) {
        this.idClient = idClient;
        this.nume = nume;
        this.adresa = adresa;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}

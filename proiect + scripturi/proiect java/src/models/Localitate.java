package models;

public class Localitate {
    private int idLocalitate;
    private String denumire;

    public Localitate(int idLocalitate, String denumire) {
        this.idLocalitate = idLocalitate;
        this.denumire = denumire;
    }

    public int getIdLocalitate() {
        return idLocalitate;
    }

    public String getDenumire() {
        return denumire;
    }
}

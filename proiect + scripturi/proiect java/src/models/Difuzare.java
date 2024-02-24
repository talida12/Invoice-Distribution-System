package models;

import java.time.LocalDate;

public class Difuzare {
    private int idFactura;
    private int idLocalitate;
    private LocalDate datai;
    private LocalDate datas;

    public Difuzare(int idFactura, int idLocalitate, LocalDate datai, LocalDate datas) {
        this.idFactura = idFactura;
        this.idLocalitate = idLocalitate;
        this.datai = datai;
        this.datas = datas;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public int getIdLocalitate() {
        return idLocalitate;
    }

    public LocalDate getDatai() {
        return datai;
    }

    public LocalDate getDatas() {
        return datas;
    }

    @Override
    public String toString() {
        return "Difuzare{" +
                "idFactura=" + idFactura +
                ", idLocalitate=" + idLocalitate +
                ", datai=" + datai +
                ", datas=" + datas +
                '}';
    }
}

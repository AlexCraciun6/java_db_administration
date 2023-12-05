package com.example.oracle_test;

public class Comanda {
    private int idc;
    private int idp;
    private int idf;
    private int cantitate;

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "idc=" + idc +
                ", idp=" + idp +
                ", idf=" + idf +
                ", cantitate=" + cantitate +
                '}';
    }
}

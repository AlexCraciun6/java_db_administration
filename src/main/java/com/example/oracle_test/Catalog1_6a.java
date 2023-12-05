package com.example.oracle_test;

public class Catalog1_6a {
    private int idf;
    private String moneda;
    private double pret_minim;
    private double pret_maxim;

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getPret_minim() {
        return pret_minim;
    }

    public void setPret_minim(double pret_minim) {
        this.pret_minim = pret_minim;
    }

    public double getPret_maxim() {
        return pret_maxim;
    }

    public void setPret_maxim(double pret_maxim) {
        this.pret_maxim = pret_maxim;
    }

    @Override
    public String toString() {
        return "Catalog1_6a{" +
                "idf=" + idf +
                ", moneda='" + moneda + '\'' +
                ", pret_minim=" + pret_minim +
                ", pret_maxim=" + pret_maxim +
                '}';
    }
}

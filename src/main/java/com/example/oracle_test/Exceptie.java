package com.example.oracle_test;

public class Exceptie {
    private int idp;
    private int idf;
    private String natura_exceptiei;

    public Exceptie(int idp, int idf, String natura_exceptiei) {
        this.idp = idp;
        this.idf = idf;
        this.natura_exceptiei = natura_exceptiei;
    }

    public Exceptie() {
    }

    @Override
    public String toString() {
        return "Exceptie{" +
                "idp=" + idp +
                ", idf=" + idf +
                ", natura_exceptiei='" + natura_exceptiei + '\'' +
                '}';
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

    public String getNatura_exceptiei() {
        return natura_exceptiei;
    }

    public void setNatura_exceptiei(String natura_exceptiei) {
        this.natura_exceptiei = natura_exceptiei;
    }
}

package com.example.oracle_test;

public class SurubComandat {
    private int idc;
    private int idf;
    private String numef;
    private String adresa;
    private int idp;
    private String culoare;
    private double pret;
    private int cantitate;

    public SurubComandat(int idc, int idf, String numef, String adresa, int idp, String culoare, double pret, int cantitate) {
        this.idc = idc;
        this.idf = idf;
        this.numef = numef;
        this.adresa = adresa;
        this.idp = idp;
        this.culoare = culoare;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    public SurubComandat(){}

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getNumef() {
        return numef;
    }

    public void setNumef(String numef) {
        this.numef = numef;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return "SurubComandat{" +
                "idc=" + idc +
                ", idf=" + idf +
                ", numef='" + numef + '\'' +
                ", adresa='" + adresa + '\'' +
                ", idp=" + idp +
                ", culoare='" + culoare + '\'' +
                ", pret=" + pret +
                ", cantitate=" + cantitate +
                '}';
    }
}

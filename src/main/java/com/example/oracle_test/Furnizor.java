package com.example.oracle_test;

public class Furnizor {
    private int idf;
    private String numef;
    private String adresa;

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

    @Override
    public String toString() {
        return "Furnizor{" +
                "idf=" + idf +
                ", numef='" + numef + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }

    public Furnizor(int idf, String numef, String adresa) {
        this.idf = idf;
        this.numef = numef;
        this.adresa = adresa;
    }

    public Furnizor(){}
}

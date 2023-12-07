package com.example.oracle_test;

public class Piesa {
    private int idp;
    private String numep;
    private String culoare;

    public Piesa(int idp, String numep, String culoare) {
        this.idp = idp;
        this.numep = numep;
        this.culoare = culoare;
    }
    public Piesa(){}

    @Override
    public String toString() {
        return "Piesa{" +
                "idp=" + idp +
                ", numep='" + numep + '\'' +
                ", culoare='" + culoare + '\'' +
                '}';
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getNumep() {
        return numep;
    }

    public void setNumep(String numep) {
        this.numep = numep;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }
}

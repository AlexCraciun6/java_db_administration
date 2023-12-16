package com.example.oracle_test;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class Catalog1 {
    @NotNull
    @PositiveOrZero
    private int idf;
    @NotNull
    @PositiveOrZero
    private int idp;
    @NotNull
    @PositiveOrZero
    private double pret;
    @NotEmpty
    private String moneda;

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Override
    public String toString() {
        return "Catalog1{" +
                "idf=" + idf +
                ", idp=" + idp +
                ", pret=" + pret +
                ", moneda='" + moneda + '\'' +
                '}';
    }
}

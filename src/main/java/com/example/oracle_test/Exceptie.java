package com.example.oracle_test;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class Exceptie {
    @NotNull
    @PositiveOrZero
    private int idp;
    @NotNull
    @PositiveOrZero
    private int idf;
    @NotEmpty
    private String natura_exceptiei;
    @NotNull
    @PositiveOrZero
    private int idf2;

    public Exceptie(int idp, int idf, String natura_exceptiei, int idf2) {
        this.idp = idp;
        this.idf = idf;
        this.natura_exceptiei = natura_exceptiei;
        this.idf2 = idf2;
    }

    public Exceptie(){}

    @Override
    public String toString() {
        return "Exceptie{" +
                "idp=" + idp +
                ", idf=" + idf +
                ", natura_exceptiei='" + natura_exceptiei + '\'' +
                ", idf2=" + idf2 +
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

    public int getIdf2() {
        return idf2;
    }

    public void setIdf2(int idf2) {
        this.idf2 = idf2;
    }
}

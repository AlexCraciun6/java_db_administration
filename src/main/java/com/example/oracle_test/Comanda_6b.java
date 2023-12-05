package com.example.oracle_test;

public class Comanda_6b {
    private int idc;
    private int numar_piese;

    @Override
    public String toString() {
        return "Comanda_6b{" +
                "idc=" + idc +
                ", numar_piese=" + numar_piese +
                '}';
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public int getNumar_piese() {
        return numar_piese;
    }

    public void setNumar_piese(int numar_piese) {
        this.numar_piese = numar_piese;
    }
}

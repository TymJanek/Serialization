package com.company;

public class Lekarstwa {
    private String[] nazwa;
    private double[] cena;
    private double[] refundacja;

    public String[] getNazwa() {
        return nazwa;
    }

    public void setNazwa(String[] nazwa) {
        this.nazwa = nazwa;
    }

    public double[] getCena() {
        return cena;
    }

    public void setCena(double[] cena) {
        this.cena = cena;
    }

    public double[] getRefundacja() {
        return refundacja;
    }

    public void setRefundacja(double[] refundacja) {
        this.refundacja = refundacja;
    }

    public Lekarstwa(String[] nazwa, double[] cena, double[] refundacja) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.refundacja = refundacja;
    }
}

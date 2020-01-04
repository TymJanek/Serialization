package com.company;

import java.io.Serializable;
import java.util.Arrays;

public class Lekarstwa implements Serializable {
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
        this.nazwa = changeLetterCase(nazwa);
        this.cena = cena;
        this.refundacja = refundacja;
    }

    private String[] changeLetterCase(String[] nazwa){
        for(int i=0; i< nazwa.length; i++){
            String temp = "";
            if(nazwa[i].length() < 1){
                throw new IllegalArgumentException("Nazwa za krótka.");
            }
            else if(nazwa[i].length() > 1){
                temp += String.valueOf(nazwa[i].charAt(0)).toUpperCase();
                temp += nazwa[i].substring(1).toLowerCase();
            }
            else{
                temp += String.valueOf(nazwa[i].charAt(0)).toUpperCase();
            }
            nazwa[i] = temp;
        }
        return nazwa;
    }

    public double Cena(String lek, boolean ubezpieczony) {
        int i;
        for(i = 0; i < this.nazwa.length-1; i++) {
            if(lek.equals(this.nazwa[i])) break;
        }
        if(ubezpieczony){
            return (this.cena[i] - (this.cena[i] * this.refundacja[i]));
        }
        else{
            return this.cena[i];
        }
    }

    public double kosztCalkowity(){
        double result = 0;
        for(int i=0; i<nazwa.length; i++){
            result += this.cena[i];
        }
        return result;
    }

    @Override
    public String toString(){
        return "Nazwy leków: " + Arrays.toString(getNazwa()) + ", ceny leków: " + Arrays.toString(getCena()) + ", refundacja: " + Arrays.toString(getRefundacja());
    }

    public void wyswietl(){
        System.out.println("Nazwy leków: " + Arrays.toString(getNazwa()) + ", ceny leków: " + Arrays.toString(getCena()) + ", refundacja: " + Arrays.toString(getRefundacja()));
    }
}

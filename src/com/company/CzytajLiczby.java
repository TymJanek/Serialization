package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

public class CzytajLiczby {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("liczby.txt"));
        String line;
        int indeks = 0;
        while((line = br.readLine()) != null){
            line = myReplace(line, '.', ',');       //zamiana '.' (kropek) na ',' (przecinki)
            line = myReplace(line, ':', ' ');       //zamiana ':' (dwukropków) na ' ' (spacje)
            System.out.println(line);
            indeks++;
        }
        br.close();
    }

    //metoda do zamiany znaków (mój replace)
    public static String myReplace(String str, char staryZnak, char nowyZnak){
        String nowyTekst = "";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == staryZnak){
                nowyTekst += nowyZnak;
            }
            else{
                nowyTekst += str.charAt(i);
            }
        }
        return nowyTekst;
    }
}

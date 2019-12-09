package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        Film film1 = new Film();
        Film film2 = new Film("Irlandczyk", "Martin Scorsese", 2019, new String[]{"Robert de Niro", "Al Pacino", "Joe Pesci"});
        film1.introduceYourself();
        film2.introduceYourself();

        Ksiazka book1 = new Ksiazka();
        book1.introduceYourself();

        System.out.println("test1");

        new Main().ZapiszDane(film1,film2, "savefile1.obj");

        System.out.println("\nOdczyt");

        new Main().CzytajDane("savefile1.obj");
    }

    //method to write object into file
    public int ZapiszDane(Film film1,Film film2, String fileName){
        ObjectOutputStream strumien_zapis;

        try{
            strumien_zapis = new ObjectOutputStream(new FileOutputStream(fileName));
            strumien_zapis.writeObject(film1);
            strumien_zapis.writeObject(film2);
            return 0;
        }

        catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public void CzytajDane(String fileName){

        ObjectInputStream strumien_odczyt;

        try{
            strumien_odczyt = new ObjectInputStream(new FileInputStream(fileName));

            Object obj;
            Film filmTest;

            while((obj = strumien_odczyt.readObject()) != null){
                if(obj instanceof Film){
                    filmTest = (Film)obj;
                    System.out.println(filmTest.getTitle() + " " + filmTest.getDirector() + " " + filmTest.getProductionYear());
                }
            }

        }catch(EOFException ex){
            System.out.println("Koniec pliku");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


}

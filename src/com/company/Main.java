package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        //utworzenie 4 instancji klasy Film
        Film film1 = new Film();
        Film film2 = new Film("Irlandczyk", "Martin Scorsese", 2019, new String[]{"Robert de Niro", "Al Pacino", "Joe Pesci"});
        Film film3 = new Film("6 Underground", "Michael Bay", 2019, new String[]{"Ryan Reyndolds", "Mélanie Laurent", "Manuel Garcia-Rulfo"});
        Film film4 = new Film("Pulp Fiction", "Quentin Tarantino", 1994, new String[]{"John Travolta", "Samuel L. Jackson", "Uma Thurman"});

        //utworznie 3 instancji klasy Ksiazka
        Ksiazka book1 = new Ksiazka();
        Ksiazka book2 = new Ksiazka("Gra o Tron", "George R.R. Martin", 1996, 694, "Epic fantasy");
        Ksiazka book3 = new Ksiazka("Ekspozycja", "Remigiusz Mróz", 2015, 512, "Powieść kryminalna");

        //zapis obiektu klasy Film do pliku obiektowego
        new Main().ZapiszFilm(film4, "savefilm.obj");
        //odczyt filmu
        new Main().CzytajDane("savefilm.obj");

        //tablica klasy Object z obiektami klasy Film oraz Ksiazka
        Object[] listOfFilmsAndBooks = new Object[] {film1, film2, film3, book1, book2, book3};

        //zapis tablicy obiektów (listOfFilmsAndBooks) do pliku obiektowego (savefile1.obj)
        new Main().ZapiszDane(listOfFilmsAndBooks, "savefile1.obj");

        //odczyt z pliku obiektowego tablicy obiektów
        System.out.println("\nOdczyt");
        new Main().CzytajDane("savefile1.obj");


    }

    //metoda zapisująca obiekt klasy Film do pliku obiektowgo
    public int ZapiszFilm(Film film, String fileName){
        ObjectOutputStream strumien_zapis;

        try{
            strumien_zapis = new ObjectOutputStream(new FileOutputStream(fileName));
            strumien_zapis.writeObject(film);
            return 0;
        }
        catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    //metoda zapisująca tablicę klasy Object zawierająca obiekty klasy Film i Ksiazka do pliku obiektowego
    public int ZapiszDane(Object[] listOfFilmsAndBooks, String fileName){
        ObjectOutputStream strumien_zapis;

        try{
            strumien_zapis = new ObjectOutputStream(new FileOutputStream(fileName));
            for(int i=0; i<listOfFilmsAndBooks.length; i++){
                strumien_zapis.writeObject(listOfFilmsAndBooks[i]);
            }
            return 0;
        }

        catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    //metoda odczytująca obiekty z pliku obiektowgo i wyświetlająca wybrane wartości na ekran
    public void CzytajDane(String fileName){

        ObjectInputStream strumien_odczyt;

        try{
            strumien_odczyt = new ObjectInputStream(new FileInputStream(fileName));

            Object obj;
            Object temp;

            while((obj = strumien_odczyt.readObject()) != null){
                if(obj instanceof Film){
                    temp = (Film)obj;
                    System.out.println("Film: " + ((Film) temp).getTitle() + " " + ((Film) temp).getDirector() + " " + ((Film) temp).getProductionYear());
                }
                else if(obj instanceof Ksiazka){
                    temp = (Ksiazka)obj;
                    System.out.println("Książka: " + ((Ksiazka) temp).getAuthor() + " " +  ((Ksiazka) temp).getTitle());
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

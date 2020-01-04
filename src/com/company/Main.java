package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

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
        new Main().zapiszFilm(film4, "savefilm.obj");
        //odczyt filmu
        new Main().czytajDane("savefilm.obj");

        //tablica klasy Object z obiektami klasy Film oraz Ksiazka
        Object[] listOfFilmsAndBooks = new Object[] {film1, film2, film3, book1, book2, book3};

        //zapis tablicy obiektów (listOfFilmsAndBooks) do pliku obiektowego (savefile1.obj)
        new Main().zapiszDane(listOfFilmsAndBooks, "savefile1.obj");

        //odczyt z pliku obiektowego tablicy obiektów
        System.out.println();
        new Main().czytajDane("savefile1.obj");

        //Lekarstwa
        Lekarstwa lek1 = new Lekarstwa(new String[]{"iBupRoM", "RuTinoscOrbIN", "sCorBoLAmId"}, new double[]{10.00, 8.00, 9.90}, new double[]{0.5, 0.1, 0.23});
        Lekarstwa lek2 = new Lekarstwa(new String[]{"aCataR", "DaruNavir", "jeLiTon", "Oerapol"}, new double[]{14.76, 5.60, 19.20, 22.50}, new double[]{0.0, 0.2, 0.1, 0.33});
        Lekarstwa lek3 = new Lekarstwa(new String[]{"Abilify", "Babyfen", "Cabometyx", "Daivobet", "Ebivol", "Farfaron", "Gabacol", "Halset", "Ibalgin", "Jakavi", "Kaletra"},
                                       new double[]{14.64, 20.89, 6.55, 12.24, 23.52, 15.9, 17.75, 26.19, 17.45, 26.42, 26.83},
                                       new double[]{0.43, 0.81, 0.21, 0.74, 0.06, 0.51, 0.79, 0.14, 0.78, 0.82, 0.41});
        Lekarstwa[] lekarstwa = new Lekarstwa[]{lek1, lek2, lek3};
        //lek1.wyswietl();
        //System.out.println(lek1.Cena("Rutinoscorbin", true));
        //System.out.println(lek1.kosztCalkowity());

        new Main().zapiszLekarstwa(lekarstwa);
        new Main().zapiszDoNoweDat(new Main().czytajLekarstwa());
        new Main().czytajDane("nowe.dat");
        new Main().zapiszDoIleTxt(new Main().czytajLekarstwa());

    }

    public void zapiszLekarstwa(Lekarstwa[] lekarstwa){
        ObjectOutputStream oos;
        try{
            oos = new ObjectOutputStream(new FileOutputStream("lek.dat"));
            for (Lekarstwa value : lekarstwa) {
                oos.writeObject(value);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Lekarstwa> czytajLekarstwa(){
        List<Lekarstwa> list = new ArrayList<Lekarstwa>();
        ObjectInputStream ois;      //odczyt
        try{
            ois = new ObjectInputStream(new FileInputStream("lek.dat"));
            Object obj;
            while((obj = ois.readObject()) != null){
                if(obj instanceof Lekarstwa){                    
                    if(((Lekarstwa) obj).getNazwa().length < 10 && ((Lekarstwa) obj).kosztCalkowity() <= 1000){
                        try{
                            list.add((Lekarstwa) obj);
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        catch(EOFException ex){
            System.out.println("Koniec pliku.\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public void zapiszDoNoweDat(List<Lekarstwa> list) {
        ObjectOutputStream oos;
        try{
            oos = new ObjectOutputStream(new FileOutputStream("nowe.dat"));
            for(int i=0; i<list.size(); i++){
                oos.writeObject(list.get(i));
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void zapiszDoIleTxt(List<Lekarstwa> list) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("ile.txt"));
        int counter = list.size();
        bw.write(String.valueOf(counter));
            bw.close();
    }



    //metoda zapisująca obiekt klasy Film do pliku obiektowego
    public int zapiszFilm(Film film, String fileName){
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
    public void zapiszDane(Object[] listOfFilmsAndBooks, String fileName){
        ObjectOutputStream strumien_zapis;

        try{
            strumien_zapis = new ObjectOutputStream(new FileOutputStream(fileName));
            for (Object listOfFilmsAndBook : listOfFilmsAndBooks) {            //pętla zapisująca wszystkie obiekty z tablicy do strumienia do pliku obiektowgo
                strumien_zapis.writeObject(listOfFilmsAndBook);
            }
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

    //metoda odczytująca obiekty z pliku obiektowgo i wyświetlająca wybrane wartości na ekran
    public void czytajDane(String fileName){

        ObjectInputStream strumien_odczyt;

        try{
            strumien_odczyt = new ObjectInputStream(new FileInputStream(fileName));

            Object obj;

            while((obj = strumien_odczyt.readObject()) != null){
                if(obj instanceof Film){
                    System.out.println("Film: " + ((Film) obj).getTitle() + " " + ((Film) obj).getDirector());
                }
                else if(obj instanceof Ksiazka){
                    System.out.println("Książka: " + ((Ksiazka) obj).introduceYourself());
                }
                else if(obj instanceof Lekarstwa){
                    System.out.println(obj);
                }
            }

        }
        catch(EOFException ex){
            System.out.println("Koniec pliku.\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


}

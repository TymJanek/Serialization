package com.company;

import java.io.Serializable;

public class Ksiazka implements Serializable {

    private String title;
    private String author;
    private int releaseYear;
    private int pages;
    private String genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //konstruktor domyślny
    public Ksiazka(){
        this.title = "Altered Carbon";
        this.author = "Richard K.Morgan";
        this.releaseYear = 2002;
        this.pages = 375;
        this.genre = "Cyberpunk novel";
    }

    //konstruktor
    public Ksiazka(String title, String author, int releaseYear, int pages, String genre) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.pages = pages;
        this.genre = genre;
    }

    //konstruktor kopiujący
    public Ksiazka(Ksiazka copy){
        this.title = copy.title;
        this.author = copy.author;
        this.releaseYear = copy.releaseYear;
        this.pages = copy.pages;
        this.genre = copy.genre;
    }

    //metoda zwracająca informacje o ksiazce
    public String introduceYourself(){
        return (getTitle() + " " + getAuthor() + " " + getReleaseYear() + " " + getPages() + " " + getGenre());
    }
}

package com.company;

public class Ksiazka {

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

    public Ksiazka(){
        this.title = "Altered Carbon";
        this.author = "Richard K.Morgan";
        this.releaseYear = 2002;
        this.pages = 375;
        this.genre = "Cyberpunk novel";
    }

    public Ksiazka(String title, String author, int releaseYear, int pages, String genre) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.pages = pages;
        this.genre = genre;
    }

    public Ksiazka(Ksiazka copy){
        this.title = copy.title;
        this.author = copy.author;
        this.releaseYear = copy.releaseYear;
        this.pages = copy.pages;
        this.genre = copy.genre;
    }

    public void introduceYourself(){
        System.out.println(getTitle() + " " + getAuthor() + " " + getReleaseYear() + " " + getPages() + " " + getGenre());
    }
}

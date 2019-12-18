package com.company;

import java.io.Serializable;
import java.util.Arrays;

public class Film implements Serializable {

    private String title;
    private String director;
    private int productionYear;
    private String[] actors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    //default
    public Film(){
        this.title = "Interstellar";
        this.director = "Christopher Nolan";
        this.productionYear = 2014;
        this.actors = new String[]{"Ellen Burstyn", "Matthew McConaughey", "Mackenzie Foy"};
    }

    //with parameters
    public Film(String title, String director, int productionYear, String[] actors) {
        this.title = title;
        this.director = director;
        this.productionYear = productionYear;
        this.actors = actors;
    }

    //copy constructor
    public Film(Film copy){
        this.title = copy.title;
        this.director = copy.director;
        this.productionYear = copy.productionYear;
        this.actors = copy.actors;
    }

    public String introduceYourself(){
        return (getTitle() + " " + getDirector() + " " + getProductionYear() + " " + Arrays.toString(getActors()));
    }

}

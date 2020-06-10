package com.ericmenis.application.Models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class City {

    private int id;
    private String name;
    private String country;
    private String icon;
    private String description;
    private float temp;

    //@SerializedName("main")
    //private Temperature temperature;

    public City() {
    }

    public City(int id, String name, String country, String icon, String description, float temp) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.description = description;
        this.temp = temp;
        this.icon = icon;
        //this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Temperatura en Kelvin
    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    //    public Temperature getTemperature() {
//        return temperature;
//    }
//
//    public void setTemperature(Temperature temperature) {
//        this.temperature = temperature;
//    }

    /*public static Temperature parseJSON(String response){
        Gson gson = new GsonBuilder().create();
        Temperature temp = gson.fromJson(response, Temperature.class);
        return temp;
    }*/
}

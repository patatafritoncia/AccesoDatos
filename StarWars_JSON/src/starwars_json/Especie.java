/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package starwars_json;

/**
 *
 * @author FP
 */
public class Especie {
    private String specie_name;
    private String classification;
    private String designation;
    private String average_height;
    private String skin_colors;
    private String hair_colors;
    private String average_lifespan;
    private String language;
    
    //Constructor

    public Especie(String specie_name, String classification, String designation, String average_height, String skin_colors, String hair_colors, String average_lifespan, String language) {
        this.specie_name = specie_name;
        this.classification = classification;
        this.designation = designation;
        this.average_height = average_height;
        this.skin_colors = skin_colors;
        this.hair_colors = hair_colors;
        this.average_lifespan = average_lifespan;
        this.language = language;
    }
    
    //Getters

    public String getSpecie_name() {
        return specie_name;
    }

    public String getClassification() {
        return classification;
    }

    public String getDesignation() {
        return designation;
    }

    public String getAverage_height() {
        return average_height;
    }

    public String getSkin_colors() {
        return skin_colors;
    }

    public String getHair_colors() {
        return hair_colors;
    }

    public String getAverage_lifespan() {
        return average_lifespan;
    }

    public String getLanguage() {
        return language;
    }
    
    //Setters

    public void setSpecie_name(String specie_name) {
        this.specie_name = specie_name;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setAverage_height(String average_height) {
        this.average_height = average_height;
    }

    public void setSkin_colors(String skin_colors) {
        this.skin_colors = skin_colors;
    }

    public void setHair_colors(String hair_colors) {
        this.hair_colors = hair_colors;
    }

    public void setAverage_lifespan(String average_lifespan) {
        this.average_lifespan = average_lifespan;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
}

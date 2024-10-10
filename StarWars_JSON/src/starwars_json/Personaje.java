/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package starwars_json;

import java.util.ArrayList;

/**
 *
 * @author FP
 */
public class Personaje {

    private String name;
    private String height;
    private ArrayList<Pelicula> peliculas;
    private ArrayList <Especie> especies;
    
    //Constructor

    public Personaje(String name, String height) {
        this.name = name;
        this.height = height;
        this.peliculas = new ArrayList<Pelicula>();
        this.especies =  new ArrayList<Especie>();
    }
    
    //Getters
    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public ArrayList<Especie> getEspecies() {
        return especies;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void setEspecies(ArrayList<Especie> especies) {
        this.especies = especies;
    }
    
    public boolean agreagarPelicula (Pelicula p){
        return peliculas.add(p);
    }
    
    public boolean agreagarEspecie (Especie e){
        return especies.add(e);
    }
}

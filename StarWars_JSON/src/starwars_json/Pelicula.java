/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package starwars_json;

/**
 *
 * @author FP
 */
public class Pelicula {
    private String title;
    private String episode_id;
    private String opening;
    private String director;
    
    //Constructor

    public Pelicula(String title, String episode_id, String opening, String director) {
        this.title = title;
        this.episode_id = episode_id;
        this.opening = opening;
        this.director = director;
    }

    //Getters

    public String getTitle() {
        return title;
    }

    public String getEpisode_id() {
        return episode_id;
    }

    public String getOpening() {
        return opening;
    }

    public String getDirector() {
        return director;
    }
    
    
    //Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEpisode_id(String episode_id) {
        this.episode_id = episode_id;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    

}

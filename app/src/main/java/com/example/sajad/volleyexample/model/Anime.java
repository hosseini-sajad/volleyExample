package com.example.sajad.volleyexample.model;

/**
 * Created by sajad on 8/2/2018.
 */
public class Anime {
    private String name;
    private String description;
    private String rating;
    private String categorie;
    private String studio;
    private String image_url;

    public Anime(String name, String description, String rating, String categorie, String studio, String image_url) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.categorie = categorie;
        this.studio = studio;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}

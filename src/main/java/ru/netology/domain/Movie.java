package ru.netology.domain;

public class Movie {
    private String id;
    private String imageUrl;
    private String name;
    private String genre;

    public Movie() {
    }

    public Movie(String id, String imageUrl, String name, String genre) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.genre = genre;
    }

    public String getId() {
        return this.id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getName() {
        return this.name;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

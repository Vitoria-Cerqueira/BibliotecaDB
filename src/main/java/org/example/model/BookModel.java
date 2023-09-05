package org.example.model;

public class BookModel {
    private int id_livro;
    private String title;
    private String description;
    private String genre;
    private boolean status;
    private int id_autor;

    public int getId_book() {
        return id_livro;
    }

    public void setId_book(int id_book) {
        this.id_livro = id_book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }
}

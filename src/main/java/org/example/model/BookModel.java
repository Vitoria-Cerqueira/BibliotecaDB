package org.example.model;

public class BookModel {
    private int id_livro;
    private String title;
    private String description;
    private String genre;
    private boolean status;
    private int id_author;

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

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }
}

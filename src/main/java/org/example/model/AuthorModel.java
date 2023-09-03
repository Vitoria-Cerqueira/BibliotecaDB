package org.example.model;

public class AuthorModel {
    private int id_autor;
    private String name;
    private String cpf;
    private String email;
    private int id_livro;

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autror) {
        this.id_autor = id_autror;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int bookId) {
        this.id_livro = bookId;
    }
}

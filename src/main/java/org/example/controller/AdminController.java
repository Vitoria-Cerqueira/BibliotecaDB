package org.example.controller;

import org.example.model.AdminModel;
import org.example.model.AuthorModel;
import org.example.model.BookModel;
import org.example.model.UserModel;
import org.example.repository.AdminRepository;

public class AdminController {


    AdminRepository adminRepository = new AdminRepository();
    AdminModel adminModel = new AdminModel();
    BookModel bookModel = new BookModel();
    AuthorModel authorModel = new AuthorModel();
    UserModel userModel = new UserModel();

    public boolean logIn(int tokenAdmin) {
        adminModel.setToken_adimin(tokenAdmin);
        return adminRepository.login(adminModel.getToken_adimin());
    }

    public boolean registerBook(String title, String description, String genre) {
        bookModel.setTitle(title);
        bookModel.setDescription(description);
        bookModel.setGenre(genre);
        return adminRepository.registerBook(bookModel.getTitle(), bookModel.getDescription(), bookModel.getGenre());
    }

    public boolean registerAuthor(String name, String cpf, String email) {
        authorModel.setName(name);
        authorModel.setCpf(cpf);
        authorModel.setEmail(email);
        return adminRepository.registerAuthor(authorModel.getName(), authorModel.getCpf(), authorModel.getEmail());
    }

    public boolean deleteBook(int idBook) {
        bookModel.setId_book(idBook);
        return adminRepository.deleteBook(bookModel.getId_book());
    }

    public boolean deleteAuthor(int idAuthor) {
        authorModel.setId_autor(idAuthor);
        return adminRepository.deleteAuthor(authorModel.getId_autor());
    }

    public boolean deleteUser(int idUser) {
        userModel.setId_user(idUser);
        return adminRepository.deleteUser(userModel.getId_user());
    }

    public boolean associateAuthorId(int idAuthor, int idBook) {
        bookModel.setId_author(idAuthor);
        bookModel.setId_book(idBook);
        return adminRepository.associateAuthorId(bookModel.getId_author(), bookModel.getId_book());
    }

    public boolean associateBookId(int idBook, int idAuthor) {
        authorModel.setId_livro(idBook);
        authorModel.setId_autor(idAuthor);
        return adminRepository.associateBookId(authorModel.getId_livro(), authorModel.getId_autor());
    }


}

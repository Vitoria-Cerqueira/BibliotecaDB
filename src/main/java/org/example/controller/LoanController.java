package org.example.controller;


import org.example.model.BookModel;
import org.example.model.LoanModel;
import org.example.model.UserModel;
import org.example.repository.LoanRepository;


public class LoanController {
    LoanRepository loanRepo = new LoanRepository();
    LoanModel loanModel = new LoanModel();
    BookModel bookModel = new BookModel();
    UserModel userModel = new UserModel();

    public boolean makeLoan(int id_book, int id_user) {
        bookModel.setId_book(id_book);
        userModel.setId_user(id_user);
        loanModel.setId_book(bookModel.getId_book());
        loanModel.setId_iuser(userModel.getId_user());
        return loanRepo.efetuarEmprestimo(loanModel.getId_book(), loanModel.getId_iuser());
    }

    public boolean associateUserId(int idUser, int id_loan) {
        userModel.setId_user(idUser);
        loanModel.setId_loan(id_loan);
        return loanRepo.associateUserId(userModel.getId_user(), loanModel.getId_loan());
    }

    public boolean updateStatusBook(int id_book) {
        bookModel.setId_book(id_book);
        return loanRepo.updateStatusBook(bookModel.getId_book());
    }
}


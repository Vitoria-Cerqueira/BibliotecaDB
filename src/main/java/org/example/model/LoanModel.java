package org.example.model;

import java.time.LocalDate;

public class LoanModel {
    private int id_loan;
    private LocalDate withdrawalDate;
    private LocalDate returnDate;
    private int id_iuser;
    private int id_book;

    public int getId_loan() {
        return id_loan;
    }

    public void setId_loan(int id_loan) {
        this.id_loan = id_loan;
    }

    public LocalDate getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(LocalDate withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getId_iuser() {
        return id_iuser;
    }

    public void setId_iuser(int id_iuser) {
        this.id_iuser = id_iuser;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }
}

package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.connection.ConnectionClass.connection;

public class LoanRepository {
    private Connection conn = connection();
    private PreparedStatement preparedStatement;
    public LoanRepository(){}

    public LoanRepository(Connection conn) {
        this.conn = conn;
    }

    public boolean associateUserId(int idUser, int idEmprestimo) {
        try {
            String SQL = "UPDATE leitor SET id_emprestimo=? WHERE id_leitor=?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setInt(2, idEmprestimo);
            preparedStatement.setInt(1, idUser);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean efetuarEmprestimo(int id_book, int id_user) {
        String sql_emprestimo = "INSERT INTO emprestimo(idlivro,id_leitor,status) VALUES(?,?,?)";
        try {
            PreparedStatement prepared_emprestimo = conn.prepareStatement(sql_emprestimo);
            prepared_emprestimo.setInt(1, id_book);
            prepared_emprestimo.setInt(2, id_user);
            prepared_emprestimo.setBoolean(3, true);
            prepared_emprestimo.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStatusBook(int id_livro) {
        String sql_livro = "UPDATE livro SET status = ? WHERE id_livro = ?";
        try {
            PreparedStatement prepared_livro = conn.prepareStatement(sql_livro);
            prepared_livro.setBoolean(1, false);
            prepared_livro.setInt(2, id_livro);
            prepared_livro.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

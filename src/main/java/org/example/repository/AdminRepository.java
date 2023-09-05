package org.example.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionClass.connection;

public class AdminRepository {
    private Connection conn = connection();

    private PreparedStatement preparedStatement;
    public AdminRepository(){}
    public AdminRepository(Connection conn) {
        this.conn = conn;
    }

    public boolean login(int token_admin) {
        try {
            String sql = "SELECT * FROM bibliotecario WHERE token_admin=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, token_admin);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("token_admin") == token_admin) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registerAuthor(String name, String cpf, String email) {
        try {
            String SQL = "INSERT INTO autor(nome,cpf,email) VALUES(?,?,?)";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, cpf);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

    public boolean registerBook(String title, String description, String genrer) {
        try {
            String SQL = "INSERT INTO livro(titulo,descricao,genero) VALUES(?,?,?)";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, genrer);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

    public boolean deleteBook(int idBook) {
        String SQL = "DELETE FROM livro WHERE id_livro = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, idBook);
            pstmt.executeUpdate();
            System.out.println("Livro deletado!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAuthor(int idAuthor) {
        String SQL = "DELETE FROM autor WHERE id_autor = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, idAuthor);
            pstmt.executeUpdate();
            System.out.println("Autor deletado!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(int idUser) {
        String SQL = "DELETE FROM leitor WHERE id_leitor = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, idUser);
            pstmt.executeUpdate();
            System.out.println("Leitor deletado!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean associateAuthorId(int idAuthor, int idBook) {
        try {
            String SQL = "UPDATE livro SET id_autor=? WHERE id_livro=?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setInt(1, idAuthor);
            preparedStatement.setInt(2, idBook);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean associateBookId(int id_livro, int id_Autor) {
        try {
            String SQL = "UPDATE autor SET id_livro=? WHERE id_autor=?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setInt(1, id_livro);
            preparedStatement.setInt(2, id_Autor);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionClass.connection;

public class UserRepository {
    private Connection conn = connection();
    private PreparedStatement preparedStatement;
    public UserRepository(){}

    public UserRepository(Connection conn) {
        this.conn = conn;
    }

    public boolean register(String nome, String cpf, String email, String senha) {
        String sql = "INSERT INTO leitor (nome,cpf,email,senha) VALUES (?,?,?,?)";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cpf);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, senha);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean logIn(String email, String password) {
        try {
            String SQL = "SELECT * FROM leitor WHERE email=? AND senha=?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if ((resultSet.getString("email").equals(email)) && (resultSet.getString("senha").equals(password))) {
                    return true;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }
}

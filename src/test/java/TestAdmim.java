import org.example.repository.AdminRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestAdmim{
    private AdminRepository bibliotecario;
    private Connection connect = mock(Connection.class);
    private PreparedStatement statement = mock(PreparedStatement.class);
    private ResultSet result = mock(ResultSet.class);
    private ByteArrayOutputStream capturaASaidaDoConsole = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(capturaASaidaDoConsole));

        try {
            when(connect.prepareStatement(anyString())).thenReturn(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        bibliotecario = new AdminRepository(connect);
    }

    @Test
    void testRegistrarAutor() {
        try {
            when(statement.executeUpdate()).thenReturn(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        bibliotecario.registerAuthor("zz","111","l@gmail.com");

        String mensagemEsperada = "Conectado ao servidor PostgreSQL com sucesso!Autor registrado!";

        Assertions.assertEquals(mensagemEsperada.replaceAll("\\r?\\n", ""),capturaASaidaDoConsole.toString().trim().replaceAll("\\r?\\n", ""));
    }

    @Test
    void testloginValido() throws SQLException {
        when(statement.executeQuery()).thenReturn(result);
        when(result.next()).thenReturn(true);
        when(result.getInt("token_admin")).thenReturn(1234);

        boolean resultado = bibliotecario.login(1234);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testloginInvalido() throws SQLException {
        when(statement.executeQuery()).thenReturn(result);
        when(result.next()).thenReturn(false);

        boolean resultado = bibliotecario.login(1234);

        Assertions.assertFalse(resultado);
    }

    @Test
    void testRegistrarLivro()throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = bibliotecario.registerBook("Bolhas ao vento","descrição doida","Aventura");

        Assertions.assertTrue(resultado);
    }

    @Test
    void testDeletarLivro()throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = bibliotecario.deleteBook(1);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testDeletarAutor()throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = bibliotecario.deleteAuthor(1);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testDeletarLeitor()throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = bibliotecario.deleteUser(1);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testAssociarIdAutorAoLivro()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = bibliotecario.associateAuthorId(1, 2);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testAssociarIdLivroAoAutor()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = bibliotecario.associateBookId(1, 2);

        Assertions.assertTrue(resultado);
    }
}


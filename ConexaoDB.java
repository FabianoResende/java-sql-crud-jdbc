import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:sqlite:meu_projeto.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}

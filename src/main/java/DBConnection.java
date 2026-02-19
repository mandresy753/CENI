import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection getConnection() {
        String URL = "jdbc:postgresql://localhost:5432/ceni";
        String USER = "postgres";
        String PASSWORD = "4130";

        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            throw new RuntimeException("Connexion impossible à la base de donnée");
        }
    }
}

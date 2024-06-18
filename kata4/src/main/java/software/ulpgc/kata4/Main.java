package software.ulpgc.kata4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/rosma/OneDrive/Escritorio/dbLogIn.db")){
            accountLoader loader = new SqliteAccountLoader(connection);
            loader.loadAll();
            System.out.println(new LogIn().checkEmail("user1@example.com", "password1"));

        }

    }
}

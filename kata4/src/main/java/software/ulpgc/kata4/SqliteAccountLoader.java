package software.ulpgc.kata4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;

public class SqliteAccountLoader implements accountLoader {

    private final Connection connection;

    public static HashMap<String, String> logInData;

    public final static String queryAllSql = "" +
            "SELECT email, password FROM dataLogIn";

    public SqliteAccountLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public HashMap<String, String> loadAll() {
        try{
            return load(resultSetOf(queryAllSql));
        } catch (SQLException e){
            System.out.println("Hubo un problema al cargar la base de datos: " +  e.getMessage());
            return (HashMap<String, String>) Collections.emptyList();
        }
    }

    private ResultSet resultSetOf(String sql) throws SQLException{
        return connection.createStatement().executeQuery(sql);
    }

    private HashMap<String, String> load(ResultSet r)throws SQLException{
        HashMap<String, String> list = new HashMap<>();
        while (r.next()) {
            list.put(r.getString("email"), r.getString("password"));
            logInData = list;
        }
        return list;
    }
}

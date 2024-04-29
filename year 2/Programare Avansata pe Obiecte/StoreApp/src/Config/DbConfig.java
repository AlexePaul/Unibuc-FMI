package Config;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
public class DbConfig {

    private static DbConfig instance = null;
    private Connection DbConnection;

    private DbConfig(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/DbConnection.csv"));
            String d = reader.readLine();
            DbConnection = DriverManager.getConnection(d.split(",")[0].trim(), d.split(",")[1].trim(), d.split(",")[2].trim());
        }
        catch (IOException | SQLException e) {
            System.out.println(e);
        }
    }

    public static DbConfig getInstance() {
        if(instance == null)
            instance = new DbConfig();
        return instance;
    }

    public Connection getDbConnection() {
        return DbConnection;
    }
}

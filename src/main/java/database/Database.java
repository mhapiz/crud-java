package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class Database {
    private final String URL = "jdbc:mysql://localhost:3306/db_java_5a?" + "serverTimezone=Asia/Makassar";
    private final String USER = "root";
    private final String PASS = "";
    
    public Connection getConnection(){

            Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("MAU KONEK");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.toString());
        }
            return null;
    }
    
    public static void main(String[] args ){
        Database database = new Database();
        database.getConnection();
    }
}

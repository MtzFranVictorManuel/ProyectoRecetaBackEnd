package mx.recetariDigital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author victormanuel
 */
public class Conexion {
    private static String url = "jdbc:mysql://localhost:3306/recetariodigital";
    private static String driverName = "com.mysql.cj.jdbc.Driver"; // com.mysql.cj.jdbc.Driver
    private static String username = "root"; //root1234df
    private static String password = "Man159753";
    // variable de conexion
    private static Connection connection = null;

    public static Connection getConnection(){
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(" SQL:" + e);
        } catch (ClassNotFoundException e){
            System.out.println("Driver:" + e);
        }
        return connection;
    }
}
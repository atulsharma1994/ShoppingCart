package Dao;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * Created by atulsharma on 21/02/17.
 */
public class DBConnection {


public static Connection getConnection() throws SQLException,ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=null;
    con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_cart","root","password");

    return con;

}
}

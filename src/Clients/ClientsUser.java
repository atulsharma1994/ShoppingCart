package Clients;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import Services.UserServices;

/**
 * Created by atulsharma on 21/02/17.
 */
public class ClientsUser {
public static void main(String args[]) throws FileNotFoundException, SQLException {
    UserServices obj=new UserServices();
    try {
        obj.addUser();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
}

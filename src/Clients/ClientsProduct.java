package Clients;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import Services.ProductsServices;

/**
 * Created by atulsharma on 21/02/17.
 */
public class ClientsProduct {

    public static void main(String args[]) throws FileNotFoundException, SQLException {


        ProductsServices obj = new ProductsServices();
        obj.addProduct();

    }
}

package Clients;

import java.io.IOException;
import java.sql.SQLException;

import Services.OrdersServices;

/**
 * Created by atulsharma on 21/02/17.
 */
public class ClientsOrders {
    public static void main(String[] args) throws Exception {


        OrdersServices obj = new OrdersServices();
        try {
            obj.addOrderDetails();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

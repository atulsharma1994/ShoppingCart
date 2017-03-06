package Services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import Dao.DaoOrderDetails;
import Domain.OrderDetails;
import Domain.Products;
import Domain.User;

/**
 * Created by atulsharma on 21/02/17.
 */
interface orderdetailservices
{
    void addOrderDetails(OrderDetails od) throws FileNotFoundException, SQLException;
}
public class OrderDetailsServices implements orderdetailservices{

public void addOrderDetails( OrderDetails od) throws SQLException {
    DaoOrderDetails dod=new DaoOrderDetails();
    dod.insertOrderDetail(od) ;

}


}

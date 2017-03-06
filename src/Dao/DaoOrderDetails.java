package Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Domain.OrderDetails;
import Domain.Products;
import com.mysql.jdbc.Connection;

/**
 * Created by atulsharma on 22/02/17.
 */

interface dao_OrderDetails
{
    public void insertOrderDetail(OrderDetails obj) throws SQLException;
}
public class DaoOrderDetails implements dao_OrderDetails{
    public  void insertOrderDetail(OrderDetails obj) throws SQLException {
        DBConnection db = new DBConnection();
        Connection connection = null;
        try {
            connection = db.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PreparedStatement pst = connection.prepareStatement("insert into orderdetails  values (?,?,?)");
        try {
            pst.setInt(1, obj.getOrderProdId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pst.setInt(2, obj.getOrderId());
        pst.setInt(3, obj.getOrder_qty());
        int i = pst.executeUpdate();

    }


}

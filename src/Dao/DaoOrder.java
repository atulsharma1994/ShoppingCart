package Dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


import Domain.Orders;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Created by atulsharma on 22/02/17.
 */
interface daoorders
{
    public int placeOrder(Orders od);
}
public class DaoOrder implements daoorders {

 public int placedOrder(Orders od) throws SQLException, ClassNotFoundException {
     Connection con=DBConnection.getConnection();
     Timestamp ts=new Timestamp(new Date().getTime());
     String str="insert into orders (orderid,order_date,order_status) values(?,?,?)";
     int od_id=0;

     PreparedStatement pst= (PreparedStatement) con.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);

     pst.setInt(1,od.getOrderUserId());
     pst.setTimestamp(2,ts);
     pst.setString(3,od.getStatus());
     pst.executeUpdate();
     ResultSet rs= (ResultSet) pst.getGeneratedKeys();
     if(rs.next())
     {
         od_id=rs.getInt(1);
     }
     return od_id;
  }

    @Override
    public int placeOrder(Orders od) {
        return 0;
    }
}

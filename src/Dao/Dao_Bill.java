package Dao;
import java.util.ArrayList;
//import java.sql.*;
/**
 * Created by atulsharma on 24/02/17.
 */

import com.mysql.jdbc.*;
public class Dao_Bill {


    public ArrayList<Integer> billDetail(int orderid) throws Exception
    {
        ArrayList<Integer> arraylist = new ArrayList<>();
        DBConnection db=new DBConnection();
        Connection con=db.getConnection();

        String query="select * from orderdetails where orderid=?";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);

        ps.setInt(1,orderid);

        ps.execute();

        ResultSet rs = (ResultSet) ps.executeQuery();
        while(rs.next())
        {
            int pid = rs.getInt("orderProdId");
            int qty = rs.getInt("orderQty");
            arraylist.add(qty);
            arraylist.add(pid);
        }

        ps.close();
        con.close();
        return arraylist;
    }




}

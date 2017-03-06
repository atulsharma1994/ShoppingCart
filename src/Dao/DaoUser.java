package Dao;
import java.sql.SQLException;

import Domain.User;
import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 * Created by atulsharma on 21/02/17.
 */
interface daousers
{
    public void insert(User obj) throws SQLException;
}
public class DaoUser implements daousers{

   public void insert(User obj) throws SQLException {
       DBConnection db = new DBConnection();
       Connection connection = null;
       try {
           connection = db.getConnection();
       } catch (SQLException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
      PreparedStatement pst = connection.prepareStatement("insert into user (user_id,user_name,user_add,user_email) values (?,?,?,?)");
       try {
           pst.setInt(1,obj.getUserId());
       } catch (SQLException e) {
           e.printStackTrace();
       }
       pst.setString(2,obj.getUserName());
       pst.setString(3, obj.getUserAdd());
       pst.setString(4, obj.getEmail());

       int i=pst.executeUpdate();

   }

}

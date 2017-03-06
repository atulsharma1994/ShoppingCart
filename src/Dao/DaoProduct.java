package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Domain.Products;
import com.mysql.jdbc.Connection;

/**
 * Created by atulsharma on 22/02/17.
 */
interface daoproducts
{
    public void insert(Products obj) throws SQLException;
    public void update(int id,int qty) throws SQLException;
    public int getQty(int id) throws SQLException;
    public Products getById(int pid) throws SQLException;
}
public class DaoProduct implements daoproducts

{
    public void insert(Products obj) throws SQLException {
        DBConnection db = new DBConnection();
        Connection connection = null;
        try {
            connection = db.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PreparedStatement pst = connection.prepareStatement("insert into products  values (?,?,?,?)");
        try {
            pst.setInt(1, obj.getProdId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pst.setString(2, obj.getProdName());
        pst.setInt(3, obj.getProdQty());
        pst.setInt(4, obj.getProdUnit());

        int i = pst.executeUpdate();

    }

    public void update(int id,int qty) throws SQLException {
        DBConnection db = new DBConnection();
        Connection connection = null;
        try {
            connection = db.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "update products set prod_qty="+qty+" where prod_id="+id;
        PreparedStatement pst = connection.prepareStatement(sql);
        int i = pst.executeUpdate();
    }


    public int getQty(int id) throws SQLException {
        DBConnection db = new DBConnection();
        Connection connection = null;
        try {
            connection = db.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Statement pst = null;
        try {
            pst = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet rs = null;
        try {
            rs = pst.executeQuery("select * from products where prod_id="+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs.next();
    int qty=Integer.parseInt(rs.getString(3));
    return qty;
    }
   public Products getById(int pid) throws SQLException {
       String query="select * from products where prod_id="+pid;
       DBConnection db = new DBConnection();
       Connection connection = null;
       try {
           connection = db.getConnection();
       } catch (SQLException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
       Statement pst = null;

       pst = connection.createStatement();
       Products dp=null;
       ResultSet rs=pst.executeQuery(query);
       if(rs.next())
       {
           dp=new Products();
           dp.setProdId(rs.getInt(1));
           dp.setProdName(rs.getString(2));
           dp.setProdQty(rs.getInt(3));
           dp.setProdUnit(rs.getInt(4));

       }
    return dp;
   }


}

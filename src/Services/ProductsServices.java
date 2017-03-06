package Services;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import Dao.DaoProduct;
import Domain.Products;
import java.sql.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by atulsharma on 21/02/17.
 */
interface productservices{
        void addProduct() throws FileNotFoundException, SQLException;
       void updateprod(int id,int qty) throws SQLException;
      int getQty(int id);
    Products getId(int pid) throws SQLException;
        }
public class ProductsServices implements productservices {


 public void addProduct() throws FileNotFoundException, SQLException {

        String us_file="Resources/Product.txt";
        BufferedReader reader = new BufferedReader(new FileReader(us_file));

        DaoProduct obj=new DaoProduct();

        Products ud=new Products();
        String comma=",";
        String space=" ";
        try {
            while((space=reader.readLine())!=null)
            {
                String str[]=space.split(",");
                ud.setProdId(Integer.parseInt(str[0]));
                ud.setProdName(str[1]);
                ud.setProdQty(Integer.parseInt(str[2]));
                ud.setProdUnit(Integer.parseInt(str[3]));
                obj.insert(ud);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public void updateprod(int id,int qty) throws SQLException {
    DaoProduct obj=new DaoProduct();
    obj.update(id,qty);
}
public int getQty(int id)
{
    DaoProduct obj=new DaoProduct();
    int qty= 0;
    try {
        qty = obj.getQty(id);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return qty;
}
public Products getId(int pid) throws SQLException {
    DaoProduct dp=new DaoProduct();
    return dp.getById(pid);

}
}



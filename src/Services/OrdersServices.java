package Services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.DaoOrder;
import Domain.OrderDetails;
import Domain.Orders;
import Domain.Products;
/**
 * Created by atulsharma on 21/02/17.
 */

interface order_services {
    public void addOrderDetails() throws Exception;
}

public class OrdersServices implements order_services{

    public void addOrderDetails() throws Exception {
        String order_file="Resources/Order_Details.txt";
        BufferedReader reader=new BufferedReader(new FileReader(order_file));
        DaoOrder obj=new DaoOrder();
        OrderDetailsServices ods=new OrderDetailsServices();
        Orders o=new Orders();
        Products pr=new Products();
          String rd=" ";
        rd=reader.readLine();
        o.setOrderUserId(Integer.parseInt(rd));
        o.setStatus("Confirmed");
        int od_id=0;
        od_id=obj.placedOrder(o);
        String comma=",";
        String space=" ";

        while((space=reader.readLine())!=null) {

            String str[] = space.split(",");
            int pid=Integer.parseInt(str[0]);
            int pqty=Integer.parseInt(str[1]);
           OrderDetails od=new OrderDetails();
            od.setOrderId(od_id);
            od.setOrderProdId(pid);
            od.setOrder_qty(pqty);
            ods.addOrderDetails(od);
            ProductsServices ps=new ProductsServices();
            int old_qty=ps.getQty(pid);
            int new_qty=0;
                    new_qty=old_qty-pqty;

            ps.updateprod(pid,new_qty);

        }

        Service_Bill sb=new Service_Bill();
        try {
            sb.billGenerate(od_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

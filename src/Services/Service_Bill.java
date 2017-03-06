package Services;
import java.util.*;
import Dao.Dao_Bill;
import java.io.*;

import Domain.Products;
/**
 * Created by atulsharma on 24/02/17.
 */

public class Service_Bill {

    public void billGenerate(int orderId) throws Exception
    {
        File dir = new File("Resources/");

        File file = new File(dir,"ServiceBill.csv");
        Dao_Bill daoBill =new Dao_Bill();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Products dp= new Products();
        String prod_name="";
        int price=0,prod_qty=0,prod_price=0;
        ProductsServices sp = new ProductsServices();
        ArrayList<Integer> arrayList = daoBill.billDetail(orderId);
        System.out.println("Servcie bill is in ServiceBill.csv file which is in Shopping_Cart/Resources/ServiceBill.csv");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Order Id: "+ orderId+"\n");
        String row = "Name,Quantity,UnitPricePrice,Total";
        fileWriter.write(row+ "\n");
        int qty=0,productid=0;
        int grossTotal=0;

        for(int i=0;i<arrayList.size();i+=2) {
            qty = arrayList.get(i);
            productid = arrayList.get(i + 1);
            dp = sp.getId(productid);
            prod_price = dp.getProdUnit();
            prod_name = dp.getProdName();
            int total = prod_price * qty;
            grossTotal = grossTotal + total;
            row = prod_name + "," + qty + "," + prod_price + "," + total;
            fileWriter.write(row);
            fileWriter.write("\n");
        }
        fileWriter.write("Total Price= " + ","+","+","+grossTotal);
        fileWriter.flush();
        fileWriter.close();
    }
}

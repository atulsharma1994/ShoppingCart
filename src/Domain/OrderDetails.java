package Domain;

/**
 * Created by atulsharma on 20/02/17.
 */
public class OrderDetails {
    private int orderdetailid,orderid,productid,order_qty;
   public OrderDetails(){}
    public OrderDetails(int orderdetailid,int orderid,int productid,int order_qty)
    {
        this.orderdetailid=orderdetailid;
        this.orderid=orderid;
        this.productid=productid;
        this.order_qty=order_qty;
    }
    public int getOrderDetailId()
    {
        return orderdetailid;
    }
    public void setOrdeDetailrId(int orderdetailid)
    {
        this.orderdetailid=orderdetailid;
    }

     public int getOrderProdId()
     {
         return productid;
     }
     public void setOrderProdId(int productid) {
         this.productid = productid;
     }
     public int getOrderId()
    {
        return orderid;
    }
    public void setOrderId(int orderid)
    {
        this.orderid=orderid;
    }
    public int getOrder_qty()
    {return order_qty;}
    public void setOrder_qty(int order_qty){this.order_qty=order_qty;}
   public String toString()
    {
        return "Order Details{" +
                ", Order's id=" + orderid +
                ", ProductId='" + productid + '\'' +
                ", Order quantity='" + order_qty + '\'' +
                '}';
    }

}

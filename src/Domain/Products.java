package Domain;

/**
 * Created by atulsharma on 20/02/17.
 */

public class Products {
private int prod_id,prod_qty,prod_unit;
    private String prod_name;
     public  Products(){}
     public Products(int prod_id,String prod_name,int prod_qty,int prod_unit)
    {   this.prod_id=prod_id;
        this.prod_name=prod_name;
        this.prod_qty=prod_qty;
        this.prod_unit=prod_unit;
    }
    public int getProdId()
    {
        return prod_id;
    }
    public void setProdId(int prod_id)
    {
        this.prod_id=prod_id;
    }
    public String getProdName()
    {
        return prod_name;
    }
    public void setProdName(String prod_name)
    {
        this.prod_name=prod_name;
    }
    public int getProdQty()
    {
        return prod_id;
    }
     public void setProdQty(int prod_qty)
     {
         this.prod_qty=prod_qty;
     }
    public int getProdUnit()
    {
        return prod_unit;
    }
    public void setProdUnit(int prod_unit)
    {
        this.prod_unit=prod_unit;
    }

    public String toString() {
        return "Product{" +
                "productId=" + prod_id +
                ", productName='" + prod_name + '\'' +
                ", quantity=" + prod_qty +
                ", unitPrice=" + prod_unit +
                '}';
    }

}

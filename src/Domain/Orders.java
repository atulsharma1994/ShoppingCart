package Domain;

/**
 * Created by atulsharma on 20/02/17.
 */

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Orders {
    private int order_id;
    private int user_id;
    private Timestamp timestamp;
    private String order_status;
  public  Orders(){}

    public Orders(int order_id, int user_id, Timestamp timestamp, String order_status) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.timestamp = timestamp;
        this.order_status = order_status;
    }

    public int getOrderId() {
        return order_id;
    }

    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }

    public int getOrderUserId() {
        return user_id;
    }

    public void setOrderUserId(int user_id) {

        this.user_id = user_id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return order_status;
    }

    public void setStatus(String order_status) {
        this.order_status = order_status;
    }

    public String toString() {
        return "Order{" +
                "orderId=" + order_id +
                ", userId=" + user_id +
                ", createdDate=" + timestamp +
                ", status='" + order_status + '\'' +
                '}';
    }
}
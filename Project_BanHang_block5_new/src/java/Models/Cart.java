
package Models;

import java.sql.Date;




public class Cart {
    private int orderid;
    private Date orderdate;
    private String status;
    private int itemid;  

    public Cart() {
    }

    public Cart(int orderid, Date orderdate, String status, int itemid) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.status = status;
        this.itemid = itemid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    @Override
    public String toString() {
        return "Cart{" + "orderid=" + orderid + ", orderdate=" + orderdate + ", status=" + status + ", itemid=" + itemid + '}';
    }

       

   
}

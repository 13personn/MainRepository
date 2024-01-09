
package Models;

public class account_cart {
    private String username;
    private int orderid;

    public account_cart() {
    }

    public account_cart(String username, int orderid) {
        this.username = username;
        this.orderid = orderid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Override
    public String toString() {
        return "account_cart{" + "username=" + username + ", orderid=" + orderid + '}';
    }

   
}

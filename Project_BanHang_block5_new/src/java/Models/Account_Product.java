
package Models;


public class Account_Product {
    private String user;
    private int productid;

    public Account_Product() {
    }

    public Account_Product(String user, int productid) {
        this.user = user;
        this.productid = productid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    @Override
    public String toString() {
        return "Account_Product{" + "user=" + user + ", productid=" + productid + '}';
    }
    
}

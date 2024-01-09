
package Models;


public class Item {
    private String user;
    private String itemid;
    private int productid;
    private int quantity;
    private Double price;
    private String name;
    private String image;
    

    public Item() {
    }

    public Item(String user, String itemid, int productid, int quantity, Double price, String name, String image) {
        this.user = user;
        this.itemid = itemid;
        this.productid = productid;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.image = image;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    

   
}

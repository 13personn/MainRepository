
package Models;


public class Accounts {

   private String user;
   private String pass;
   private int role;
   private String name;
   private String phoneNumber;
   private String email;
   private String address;  
   private String image;

    public Accounts() {
    }

    public Accounts(String user, String pass, int role) {
        this.user = user;
        this.pass = pass;
        this.role = role;
    }

    public Accounts(String user, String pass, int role, String name, String phoneNumber, String email, String address, String image) {
        this.user = user;
        this.pass = pass;
        this.role = role;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.image = image;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Accounts{" + "user=" + user + ", pass=" + pass + ", role=" + role + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + ", image=" + image + '}';
    }

   
  


   
   

 
  

    
    

    
   
}

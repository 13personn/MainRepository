package DAL;

import Models.Account_Product;
import Models.Accounts;
import Models.Answer;
import Models.Category;
import Models.Item;
import Models.Product;
import Models.Questions;
import jakarta.servlet.http.Cookie;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from products";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));

            }
        } catch (Exception e) {
            System.out.println("Error at  loading produc in DAO :" + e.getMessage());
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "Select * from Category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (Exception e) {
            System.out.println("Error at Category  in DAO:" + e.getMessage());
        }

        return list;
    }

    public Product getLatestProduct() {
        String query = "select top 1 * from Products "
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));

            }
        } catch (Exception e) {
            System.out.println("Error at  getLatestProduct in DAO :" + e.getMessage());
        }
        return null;
    }

    public List<Product> getAllByCid(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select *from Products\n"
                + "where cateID =?";
        try {

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));

            }
        } catch (Exception e) {
            System.out.println("error at  getAllByCID in DAO : " + e.getMessage());
        }
        return list;
    }

    public Product getProductByID(int pid) {
        String query = "select * from Products\n"
                + "where id =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));

            }
        } catch (Exception e) {
            System.out.println("Error at getProductById :" + e.getMessage());
        }
        return null;
    }

    public List<Product> searchByName(String Searchtxt) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Products\n"
                + "where name Like ?  ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + Searchtxt + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println("Error at searchByName in DAO" + e.getMessage());
        }
        return list;
    }

    public Accounts checkLogin(String user, String pass) {
        String query = "select * from Account\n"
                + "where [user] = ?\n"
                + "and pass = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Accounts(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));

            }
        } catch (Exception e) {
            System.out.println("Error at checkLogin:" + e.getMessage());
        }

        return null;
    }

    public Accounts checkExistAccount(String user) {
        String query = "select * from Account\n"
                + "where [user] = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Accounts(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
            System.out.println("Error at CheckExistAccount:" + e.getMessage());
        }

        return null;
    }

    public Answer loadAnswerByUser(String user) {
        String query = "select * from userSecurityAnswer\n"
                + "where [user] =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Answer(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Error at loadAnswerByUser" + e.getMessage());
        }
        return null;
    }

    public Questions loadQuestionById(int id) {
        String query = "select*from question\n"
                + "where questionId =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Questions(rs.getInt(1),
                        rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Error at LoadQuestionById" + e.getMessage());
        }
        return null;
    }

    public List<Questions> loadQuestion() {
        String query = "select * from question";
        List<Questions> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Questions(rs.getInt(2),
                        rs.getString(1)));
            }
        } catch (Exception e) {
            System.out.println("Error at loadQuestion " + e.getMessage());
        }
        return list;
    }

    public void insertAccount(String user, String pass, int questionid, String answer) {
        String query = "INSERT INTO Account([user],pass,role)\n"
                + "values(?,?,0)\n"
                + "INSERT INTO userSecurityAnswer([user],answer,questionid)\n"
                + "values(?,?,?);";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, user);
            ps.setString(4, answer);
            ps.setInt(5, questionid);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error at insertAccount at DAO" + e.getMessage());
        }

    }

    public List<Account_Product> getProductsIdByUser(String user) {
        List<Account_Product> list = new ArrayList<>();
        String query = "select * from account_product\n"
                + "where [user] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account_Product product = new Account_Product(
                        rs.getString(1),
                        rs.getInt(2));

                list.add(product);
            }
            return list;
        } catch (Exception e) {
            System.out.println("Error at  loading product by sell id in DAO :" + e.getMessage());
        }
        return null;
    }

    public Product getProductById(int id) {

        String query = "select * from Products\n"
                + "where id =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
            System.out.println("Error at  loading product by sell id in DAO :" + e.getMessage());
        }
        return null;
    }

    public void deleteProduct(String pid) {
        String query = "delete account_product \n"
                + "where product_id=?\n"
                + "delete Products \n"
                + "where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.setString(2, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error at deleteProduct at DAO :" + e.getMessage());
        }
    }

    public void addAccountProduct(String user, int productid) {
        String query = "insert into account_product([user],product_id)\n"
                + "values(?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setInt(2, productid);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error at addAccountProduct" + e.getMessage());
        }
    }

    public int addProduct(String name, String img, String price, String title, String description, String categoryId, int quantity) {
        String insertQuery = "INSERT INTO Products([name], [image], price, title, [description], cateID, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = new DBContext().getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
                insertStatement.setString(1, name);
                insertStatement.setString(2, img);
                insertStatement.setString(3, price);
                insertStatement.setString(4, title);
                insertStatement.setString(5, description);
                insertStatement.setString(6, categoryId);
                insertStatement.setInt(7, quantity);

                int affectedRows = insertStatement.executeUpdate();

                if (affectedRows == 0) {
                    System.out.println("there is no affected row");

                }

                // Lấy ID tự tăng của sản phẩm vừa được thêm vào
                try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int productId = generatedKeys.getInt(1);

                        // Commit giao dịch nếu mọi thứ thành công
                        conn.commit();
                        return productId;
                    } else {
                        System.out.println("Creating product failed, no ID obtained.");

                    }
                }
            }
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Error at addProduct in DAO: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return -1; // Hoặc một giá trị đặc biệt khác để chỉ ra lỗi
    }

    public void updateProduct(String id, String name, String img, String price, String title, String description, String categoryId, int quantity) {
        String query = "update Products\n"
                + "set name =?,image=?,price=?,title =?,description=?,cateID=?,quantity=?\n"
                + "where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, img);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, categoryId);
            ps.setString(8, id);
            ps.setInt(7, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error at updateProduct in DAO" + e.getMessage());
        }
    }

    public void EditProfileByUser(String user, String image, String name, String email, String phoneNumber, String address) {
        String query = "update Account\n"
                + "set [name] =?,phoneNumber=?,email=?,address=?,image=?\n"
                + "where [user] =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phoneNumber);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, image);
            ps.setString(6, user);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error at EditProfile in DAO" + e.getMessage());
        }

    }

    public Answer checkSecurityAccount(String user, String questionid, String answer) {
        String query = "select * from userSecurityAnswer\n"
                + "where [user] =? and questionid =? and answer=?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, questionid);
            ps.setString(3, answer);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Answer(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Error at checkSecurityAccount:" + e.getMessage());
        }

        return null;
    }

    public void UpdatePassword(String user, String pass) {
        String query = "update Account\n"
                + "set pass=?\n"
                + "where [user]=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(2, user);
            ps.setString(1, pass);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error at UpdatePassword at DAO" + e.getMessage());
        }

    }

    public int remainQuantity(int origin, int sold, int id) throws ClassNotFoundException, SQLException {
        int remain = origin - sold;
        String query = "update Products\n"
                + "set Quantity =?\n"
                + "where id =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, remain);
            ps.setInt(2, id);
            ps.executeUpdate();
            return remain;
        } catch (Exception e) {
            System.out.println("Error at remainQuantity" + e.getMessage());
        }
        return -1;
    }

    public Item addItem(String user, String itemid, String productid, String quantity, double price, String name, String image) {
        String query = "insert into item(itemid,productid,quantity,price,[user],[name],[image])\n"
                + "values(?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, itemid);
            ps.setString(2, productid);
            ps.setString(3, quantity);
            ps.setDouble(4, price);
            ps.setString(5, user);
            ps.setString(5, name);
            ps.setString(5, image);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Item(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error at addItem" + e.getMessage());
        }
        return null;
    }

    public Item existItembyid(String id) {
        String query = "select * from item\n"
                + "where itemid =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Item(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("Error at existItemById" + e.getMessage());
        }
        return null;
    }

}
//    public List<Question> getAllQuestion(){
//    String query ="select * from Question";
//    List<Question> list = new ArrayList<>();
//        try {
//            conn=new DBContext().getConnection();
//            ps=conn.prepareStatement(query);
//            rs=ps.executeQuery();
//            while(rs.next()){
//            list.add(new Question(
//                    rs.getInt(1),
//                    rs.getString(2)));
//                    
//            }
//        } catch (Exception e) {
//            System.out.println("Error in getAllQuestion:"+e.getMessage());
//        }
//        return list;
//    }
////    //   test DAO
//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        
//        List<Product> a = dao.getAllProduct();
//       if(a==null){
//           System.out.println("null");
//       }else
//       {
//        for (Product questions : a) {
//            System.out.println(questions.getName());
//        }
//       }}
//}


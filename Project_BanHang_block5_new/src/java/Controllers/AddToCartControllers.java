/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import Models.Accounts;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAPTOP
 */
public class AddToCartControllers extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //check dang nhap chua
        HttpSession session = request.getSession();
          LocalDateTime now = LocalDateTime.now();
             long currentTimeInSeconds = now.toEpochSecond(ZoneOffset.UTC);
              long lastSevenDigits = currentTimeInSeconds % 10000000;
        Boolean checkCookie =false;
         String valueCookie =null;
       
        
        Accounts acc = (Accounts) session.getAttribute("logged");
        if(acc!=null){
        int pid = Integer.parseInt(request.getParameter("pid"));
        DAO dao = new DAO();
        Product product = dao.getProductByID(pid);
        String page = request.getParameter("page");
        try {
            //xu ly neu con hang
            if (product.getQuantity() != 0) {
                 Cookie[] cookie = request.getCookies();
                for (Cookie cookie1 : cookie) {
                    if(cookie1.getName().equals(acc.getUser())){
                    
                      valueCookie =cookie1.getValue();
                      cookie1.setMaxAge(0);
                      
                    }
                }
     

                if (page.equals("home")) {
                     dao.remainQuantity(product.getQuantity(), 1, pid);
                    
                       
                    if(valueCookie!=null){
                    Cookie productid = new Cookie(acc.getUser(),
                            String.valueOf(pid)+"#"+String.valueOf(1)+"#"+String.valueOf(lastSevenDigits)+"#"+valueCookie); 
                     productid.setMaxAge(7*24*60*60);      
                    response.addCookie(productid);
                    //response.sendRedirect("/Project_BanHang_prj301/loaddb");
                  //  request.getRequestDispatcher("loadcart").forward(request, response);
                 response.sendRedirect("/Project_BanHang_prj301/loadcart");
                    }else{
                    Cookie productid = new Cookie(acc.getUser(),
                            String.valueOf(pid)+"#"+String.valueOf(1)+"#"+String.valueOf(lastSevenDigits)); 
                     productid.setMaxAge(7*24*60*60);      
                    response.addCookie(productid);
                    //response.sendRedirect("/Project_BanHang_prj301/loaddb");
                  //  request.getRequestDispatcher("loadcart").forward(request, response);
                 response.sendRedirect("/Project_BanHang_prj301/loadcart");
                    }                   
                   
                    
                } else if (page.equals("detail")) {
                    int sold = Integer.parseInt(request.getParameter("sold"));
                    int remain = dao.remainQuantity(product.getQuantity(), sold, pid);
                    Cookie productid = new Cookie(acc.getUser(),
                            String.valueOf(pid)+"#"+String.valueOf(sold)+"#"+String.valueOf(lastSevenDigits)+"#"+valueCookie);                    
                    productid.setMaxAge(7*24*60*60);      
                    response.addCookie(productid);
                                     //   request.getRequestDispatcher("loadcart").forward(request, response);

                 response.sendRedirect("/Project_BanHang_prj301/loadcart");
                      //response.sendRedirect("/Project_BanHang_prj301/detail?pid="+pid);
                }

                    
                
            
        }} catch (ClassNotFoundException ex) {
            Logger.getLogger(AddToCartControllers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddToCartControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
        response.sendRedirect("/Project_BanHang_prj301/loaddb");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

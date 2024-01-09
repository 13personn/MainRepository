/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import Models.Accounts;
import Models.Item;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPTOP
 */
public class LoadCartControllers extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Cookie[] cookie = request.getCookies();
        HttpSession session = request.getSession();
        List<Item> listitem = new ArrayList<>();
        Accounts acc = (Accounts) session.getAttribute("logged");
        DAO dao = new DAO();
        for (Cookie cook : cookie) {

            if (cook.getName().equals(acc.getUser())) {
// tach mang + xac nhan product do co phai cua user hienj tai ko

                String value = cook.getValue();
                String[] values = value.split("#");
                int cookiesLength = values.length;
                int pidPosition = 0;
                int quantityPosition = 1;
                int itemidPosition = 2;
                for (int i = 0; i < cookiesLength/3; i++) {
                    Product product = dao.getProductByID(Integer.parseInt(values[pidPosition]));
                    Item iscookieExist = dao.existItembyid(values[itemidPosition]);
                  if(iscookieExist==null){
                      
                 Item item=  dao.addItem(acc.getUser(), values[itemidPosition],values[pidPosition],
                         values[quantityPosition], product.getPrice(),product.getName(),product.getImage());
                 listitem.add(item);
                 pidPosition =pidPosition+3;
                   quantityPosition=quantityPosition+3;
                   itemidPosition=itemidPosition+3;
                  }
                   
                }

               
                //   response.sendRedirect("/Project_BanHang_prj301/Views/Cart.jsp");

            }
            //  response.sendRedirect("/Project_BanHang_prj301/loaddb");

        }
        request.getRequestDispatcher("loaddb").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

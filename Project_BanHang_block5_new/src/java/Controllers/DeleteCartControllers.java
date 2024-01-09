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

public class DeleteCartControllers extends HttpServlet {

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
                int deleteposition = -1;
                String itemid = request.getParameter("itemid");
                //tim vi tri xoa
                for (int i = 0; i < cookiesLength / 3; i++) {
                    if (values[itemidPosition].equals(itemid.toString())) {
                        deleteposition = itemidPosition;
                    }
                   
                    itemidPosition = itemidPosition + 3;
                }
                String[] newValues = null;
                //tao chuoi moi
                for (int i = 0; i < cookiesLength; i++) {
                    if (i != deleteposition && i != deleteposition + 1 && i != deleteposition + 2) {
                        if (newValues == null) {
                            newValues = new String[cookiesLength -3];
                        }
                        if (i != 0) {
                            newValues[i] = "#" + values[i];
                        }
                        if (i == 0) {
                            newValues[i] = values[i];
                        }
                        if(i==cookiesLength-4){
                    newValues[i] = "#"+values[i]+"#";
                    }
                    }
                }
                cook.setMaxAge(0);
                Cookie newcookie =new Cookie(acc.getUser(), newValues.toString());
                newcookie.setMaxAge(7*24*60*60);      
                    response.addCookie(newcookie);
                   request.getRequestDispatcher("loadcartpage").forward(request, response);
        }
   //response.sendRedirect("/Project_BanHang_prj301/loadcartpage");
      // request.getRequestDispatcher("loadcartpage").forward(request, response);
    }
   // request.getRequestDispatcher("loadcartpage").forward(request, response);
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
     * @return a String containing servlet description
     */
    @Override
public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

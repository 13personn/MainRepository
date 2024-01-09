/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers;

import DAL.DAO;
import Models.Accounts;
import Models.Answer;
import Models.Questions;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author LAPTOP
 */
public class RetakePassControllers extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String user = request.getParameter("user");
       String questionid= request.getParameter("questionid");
       String answer= request.getParameter("answer");
       String newpass= request.getParameter("newpass");
       String renewpass= request.getParameter("newrepass");
       if(newpass.equals(renewpass)){
       DAO dao = new DAO();
       Answer ans = dao.checkSecurityAccount(user, questionid, answer);
       if(ans!=null){
       dao.UpdatePassword(user, newpass);
       request.setAttribute("alert","Your password changed sucessfully!");
       request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
       }else{
       request.setAttribute("alert", "Wrong answer or question security or username!! ");
      
        List<Questions>listq  = dao.loadQuestion();
        request.setAttribute("listquestion", listq);
       request.getRequestDispatcher("Views/RetakePass.jsp").forward(request, response);
       }
       }else{
           DAO dao = new DAO();
        List<Questions>listq  = dao.loadQuestion();
        request.setAttribute("listquestion", listq);
       request.setAttribute("alert", "Your new pass isn't same with your repass!! ");
       request.getRequestDispatcher("Views/RetakePass.jsp").forward(request, response);
       }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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

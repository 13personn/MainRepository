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
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author LAPTOP
 */
public class EditProfile02 extends HttpServlet {
   
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
        HttpSession session = request.getSession();
        Accounts acc = (Accounts) session.getAttribute("logged");
//        String answercheck = a.getAnswer();
    DAO dao = new DAO();
        String user = acc.getUser();
        Answer ans = dao.loadAnswerByUser(acc.getUser());
        int questionid = ans.getQuestionId();
        Questions question = dao.loadQuestionById(questionid);
    
        String image =  request.getParameter("image");
       String name =request.getParameter("name");
      String email = request.getParameter("email");
      String phoneNumber = request.getParameter("phoneNumber");
       String address =request.getParameter("address");
      String answer = request.getParameter("answer");
      if(answer!=null)
      {
      if(ans.getAnswer().equals(answer)){
      dao.EditProfileByUser(user, image, name, email, phoneNumber, address);
       request.setAttribute("warning", "edit sucessfully!!");
      request.getRequestDispatcher("editprofile").forward(request, response);
      }else{
      request.setAttribute("warning", "An Answer is incorrect!!");
      request.getRequestDispatcher("editprofile").forward(request, response);
      }
      }else
      {
       request.setAttribute("warning", "you must to answer to edit profile");
      request.getRequestDispatcher("editprofile").forward(request, response);
      }
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

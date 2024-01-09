

package Controllers;

import DAL.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author LAPTOP
 */
public class SignUpControllers extends HttpServlet {
   
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");       
        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        String repass=request.getParameter("repass");
        int questionid = Integer.parseInt(request.getParameter("questionchoice"));
        String answer = request.getParameter("answer");
        if(!pass.equals(repass)){       
            request.setAttribute("alert", "Your pass must be the same with repass!!try again!!");
        request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
        }else{
             DAO dao= new DAO();
        if(dao.checkExistAccount(user)!=null){
            request.setAttribute("alert", "Account existed");
        request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
        }else{
        dao.insertAccount(user, pass,questionid,answer);
        request.setAttribute("alert", "Create Account sucessfully!!");
        request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
        }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   private final String RegisterFail = "register.jsp";
   private final String RegisterSuccess = "login.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String email = request.getParameter("txtGmail");
           String FullName=request.getParameter("txtFullName");
           String UserName= request.getParameter("txtUsername");
           String Password= request.getParameter("txtPassword");
           String ConfirmPassword = request.getParameter("txtConfirmPassword");
        // Regular expression to ensure:
// - At least 8 characters long
// - At least 1 uppercase letter
// - At least 1 special character
// - At least 1 numbe
          String passwordRegex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$";
           if (Password == null || !(Password.matches(passwordRegex))) {
   request.setAttribute("pwFormat","Password must be at least 8 characters long, "
           + "include at least 1 uppercase letter, 1 special character, and 1 number.");
    request.getRequestDispatcher(RegisterFail).forward(request, response);
    return;
} 
          
            UserDAO u = new UserDAO();
           if(u.isUserExists(UserName, email)){
               request.setAttribute("error", "Email or UserName is existed");
                request.getRequestDispatcher(RegisterFail).forward(request, response);
               
           }
           if(!(Password.equals(ConfirmPassword))){
               request.setAttribute("error", "Passwords do not match");
                request.getRequestDispatcher(RegisterFail).forward(request, response);
           }
           UserDTO user = new UserDTO(UserName,Password,email,FullName,"US");
           u.create(user);
            request.getRequestDispatcher(RegisterSuccess).forward(request, response);
        }
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

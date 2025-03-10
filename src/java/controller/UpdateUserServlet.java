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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.AuthUtils;

/**
 *
 * @author HP
 */
@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/UpdateUserServlet"})
public class UpdateUserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String UpdateUS = "Profile.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           HttpSession session = request.getSession();
           if(AuthUtils.isLoggedIn(session)){
               UserDTO user = (UserDTO) session.getAttribute("user");
               String ProfileUserName = request.getParameter("txtUserName").trim();
               String ProfileFullName = request.getParameter("txtFullName").trim();
               String ProfileEmail = request.getParameter("txtEmail").trim();
               String ProfilePassword = request.getParameter("txtPassword").trim();
               String ProfileConfirmPassword = request.getParameter("txtConfirmPassword").trim();  
                boolean hasError = false;
                boolean hasChanges = false;
                if (!ProfileFullName.equals(user.getFullName())) {
    user.setFullName(ProfileFullName);
    hasChanges = true;
                }
                if (!ProfileEmail.equals(user.getEmail())) {
    if (ProfileEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) { // Kiểm tra email hợp lệ
        user.setEmail(ProfileEmail);
        hasChanges = true;
    } else {
       request.setAttribute("emailError", "Invalid email format!");
       hasError = true;
    }
}
 String passwordRegex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$";
/// cần phải sửa lại chỗ này
if (!ProfilePassword.isEmpty()) { // If the user enters a new password
    if (ProfilePassword.matches(passwordRegex)) { // Check if the password is valid
        if (ProfilePassword.equals(ProfileConfirmPassword)) { // Check if passwords match
            user.setPassword(ProfilePassword);
            hasChanges = true;
        } else {
             request.setAttribute("passwordMismatch", "Passwords do not match!");
            hasError = true;
        }
    } else {
        request.setAttribute("passwordError", "Password must be at least 8 characters long, include at least 1 uppercase letter, 1 number, and 1 special character.");
        hasError = true;
    }
}
if (hasChanges && !hasError) {
    UserDAO userDAO = new UserDAO();
    boolean updateSuccess = userDAO.updateUser(user);
    if (updateSuccess) {
        request.setAttribute("message", "UpdateSuccessfully");
        session.setAttribute("user", user); 
    } else {
        request.setAttribute("message", "Error");
    }
}else if (!hasError) {
    request.setAttribute("message", "No changes were made.");
}

// Chuyển hướng về trang profile
request.getRequestDispatcher(UpdateUS).forward(request, response);
           } else {
               response.sendRedirect("login.jsp");
           }
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

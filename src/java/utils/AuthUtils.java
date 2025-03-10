/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.UserDAO;
import dto.UserDTO;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
public class AuthUtils {
    private static final String ADMIN_ROLE = "AD";
    private static final String USER_ROLE = "US";
      public static UserDTO getUser(String UserName) {
        UserDAO udao = new UserDAO();
        UserDTO user = udao.readByUserName(UserName);
        return user;
    }
      public static boolean isValidLogin(String strUserName,String strPassword){
          UserDTO u = getUser(strUserName);
          System.out.println(u);
          return u!=null && u.getPassword().equals(strPassword);
      }
      public static boolean isLoggedIn(HttpSession session){
          return session.getAttribute("user")!=null;
      }
      public static UserDTO getUser(HttpSession session) {
        if (!isLoggedIn(session)) {
            return null;
        }
        return (UserDTO) session.getAttribute("user");
    }
      public static boolean isAdmin(HttpSession session){
          if(!isLoggedIn(session)){
          return false;
      }
           UserDTO user = getUser(session);
        return user.getRoleID().equals(ADMIN_ROLE);
      }
}

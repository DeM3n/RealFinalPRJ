package dao;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author no-solace
 */
public class UserDAO {

    
    //register account
  
    public boolean create(UserDTO entity) {
Connection cn = null;
        PreparedStatement stm = null;
        int row = -1;
        boolean success= false;
         try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO Users(Username, Password, Email,FullName,RoleID)\n"
                        + "VALUES (?,?,?,?,?);";
                stm = cn.prepareStatement(sql);
               
                stm.setString(1,entity.getUserName());
                stm.setString(2,entity.getPassword());
                stm.setString(3,entity.getEmail());
                stm.setString(4,entity.getFullName());
                stm.setString(5,entity.getRoleID());

                row = stm.executeUpdate();

                if (row > 0) {
                    success = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
//close to reduce slow and crash
                if (stm != null) {
                    stm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;    
    }
  
 public UserDTO readByUserName(String USname) {
        String sql="Select * From Users WHERE Username=?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, USname);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserDTO user = new UserDTO(
                        rs.getInt("UserID"),
                        rs.getString("Username"),                       
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("FullName"),
                        rs.getString("RoleID"));
                return user;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return null;
    }

    

    
    public boolean updateUser(UserDTO entity) {
     Connection cn = null;
        PreparedStatement stm = null;
        int row = -1;
        boolean success= false;
         try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                 String sql = "UPDATE Users SET Password = ?, FullName = ?, Email = ? WHERE Username = ?";
                stm = cn.prepareStatement(sql);
                stm.setString(1, entity.getPassword());
                stm.setString(2, entity.getFullName());
                stm.setString(3, entity.getEmail());
                stm.setString(4, entity.getUserName());
                row = stm.executeUpdate();

                if (row > 0) {
                    success = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
//close to reduce slow and crash
                
                 if (stm != null) {
                    stm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    
    public boolean deleteUser(String UserName) {
        Connection cn = null;
        PreparedStatement stm = null;
        int row = -1;
        boolean success= false;
         try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                  String sql = "DELETE FROM Users WHERE Username = ?";
                stm = cn.prepareStatement(sql);
               
                stm.setString(1,UserName);
                row = stm.executeUpdate();

                if (row > 0) {
                    success = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
//close to reduce slow and crash
                
                 if (stm != null) {
                    stm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;
 
    }
   public boolean isUserExists(String username, String email)  {
    Connection cn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    boolean exists = false;

    try {
         cn=DBUtils.getConnection();
        if (cn != null) {
            String sql = "SELECT 1 FROM Users WHERE Username = ? OR Email = ?";
            stm = cn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, email);
            rs = stm.executeQuery();

            if (rs.next()) { 
                exists = true; // User found in the database
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    return exists;
}
public List<UserDTO> readAll(){
     List<UserDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM [tblUsers]";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                list.add(new UserDTO(
                        rs.getInt("userID"),  // Assuming userID is an integer
                    rs.getString("userName"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("fullName"),
                    rs.getString("roleID")
                ));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Lỗi khi đọc dữ liệu", ex);
        }
        return list;
    }

    
}

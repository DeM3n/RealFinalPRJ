package dao;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author no-solace
 */
public class UserDAO implements IDAO<UserDTO, Integer> {

    
    //register account
   @Override
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
                stm.setString(3,entity.getFullName());
                stm.setString(3,entity.getRoleID());

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

    

    @Override
    public boolean update(UserDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public List<UserDTO> search(String searchTerm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDTO readById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

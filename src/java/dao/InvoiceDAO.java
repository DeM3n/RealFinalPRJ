/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.InvoiceDTO;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.DBUtils;
/**
 *
 * @author HP
 */
public class InvoiceDAO{

  
    public boolean createInvoice(InvoiceDTO entity) {
        Connection cn = null;
         PreparedStatement stm = null;
        int row = -1;
        boolean success= false;
         try {
            cn = DBUtils.getConnection();
            if (cn != null) {
            String sql = "INSERT INTO Invoice (BookingID,PaymentStatus,TotalPrice) VALUES (?,?,?)";
                stm = cn.prepareStatement(sql);
               stm.setInt(1, entity.getBookingID()); // BookingID
            stm.setString(2, entity.getInvoiceStatus()); // PaymentStatus
            stm.setDouble(3, entity.getTotalPrice()); // TotalPrice
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

  
    public List<InvoiceDTO> readAll() {
  return null;
    }

    
    public List<InvoiceDTO> readByInvoiceStatus(String Status) {
        List<InvoiceDTO> InvoiceList = new ArrayList<>();
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if(cn!=null){
                String sql="Select * from Invoice Where PaymentStatus = ?  ";
                stm=cn.prepareStatement(sql);
                stm.setString(1, Status);
                rs=stm.executeQuery();
                while(rs.next()){
                    InvoiceDTO invoice = new InvoiceDTO(
                    rs.getInt("InvoiceID"),
                    rs.getInt("BookingID"),
                  
                    rs.getDouble("TotalPrice"),
                    rs.getString("PaymentStatus")
                    );
                    InvoiceList.add(invoice);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (cn != null) cn.close();
            }catch (Exception e){
           e.printStackTrace();
        }
            
        }
         return InvoiceList;
    }

   
   public boolean updateInvoiceStatus(int invoiceID, String paymentStatus) {
    Connection cn = null;
    PreparedStatement stm = null;
    boolean success = false;

    try {
        cn = DBUtils.getConnection();
        if (cn != null) {
            String sql = "UPDATE Invoice SET PaymentStatus = ? WHERE InvoiceID = ?";
            stm = cn.prepareStatement(sql);
            stm.setString(1, paymentStatus);
            stm.setInt(2, invoiceID);

            int row = stm.executeUpdate();
            success = row > 0; // Returns true if at least one row is updated
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (stm != null) stm.close();
            if (cn != null) cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return success;
}
   
    

    
}

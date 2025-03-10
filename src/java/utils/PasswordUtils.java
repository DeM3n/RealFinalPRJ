/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.UserDAO;
import dto.UserDTO;
import dto.UserDTO;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.List;

/**
 *
 * @author tungi
 */
public class PasswordUtils {

    public static String hashPassword(String plainPassword) {
        try {
            // Tạo MessageDigest với thuật toán SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Mã hóa mật khẩu
            byte[] messageDigest = md.digest(plainPassword.getBytes());

            // Chuyển byte[] thành chuỗi hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        String newHashedPassword = hashPassword(plainPassword);
        return newHashedPassword != null && newHashedPassword.equals(hashedPassword);
    }

    public static void migratePasswords() {
        UserDAO dao = new UserDAO();
    List<UserDTO> users = dao.readAll(); // Lấy tất cả người dùng từ DB

    for (UserDTO user : users) {
        String hashedPassword = PasswordUtils.hashPassword(user.getPassword()); // Băm mật khẩu
        user.setPassword(hashedPassword); // Gán lại mật khẩu đã mã hóa

        if (dao.updateUser(user)) { // Gọi updateUser để cập nhật DB
            System.out.println("Cập nhật thành công cho user: " + user.getUserName());
        } else {
            System.out.println("Cập nhật thất bại cho user: " + user.getUserName());
        }
    }

    System.out.println("Tất cả mật khẩu đã được mã hóa và cập nhật.");
    }
    
    public static void main(String[] args) {
        /*
        ALTER TABLE [dbo].[tblUsers]
        ALTER COLUMN [password] [varchar](250) NOT NULL;
        */
       migratePasswords();
    }
}



        
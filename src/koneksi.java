/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LAB1_22
 */
public class koneksi {
    static Connection konek;
    static ResultSet rs;
    static Statement s;
    
    public static void konekkeun(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           konek = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum_faizal","root","");
        }catch(ClassNotFoundException | SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
   public static boolean ubahdata(String sql){
       try{
           konekkeun();
           s = konek.createStatement();
           s.executeUpdate(sql);
           return true;
       }catch(SQLException error){
           JOptionPane.showMessageDialog(null, error);
           return false;
       }
   }
}

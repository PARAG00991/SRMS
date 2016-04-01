/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaproject;
import java.io.FileInputStream;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class InsertImage {
    public InsertImage(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/results","root","123");
        PreparedStatement ps1 = con.prepareStatement("insert into profilepic values(?,?)");
        ps1.setInt(2, 13551);
        FileInputStream fin1 = new FileInputStream("..\\1.jpg");
        ps1.setBinaryStream(1, fin1,fin1.available());
        ps1.executeUpdate();
        FileInputStream fin2 = new FileInputStream("..\\2.jpg");
        FileInputStream fin3 = new FileInputStream("..\\3.jpg");
        FileInputStream fin4 = new FileInputStream("..\\4.jpg");
        FileInputStream fin5 = new FileInputStream("..\\5.jpg");
        PreparedStatement ps2 = con.prepareStatement("insert into profilepic values(?,?)");
        ps2.setBinaryStream(1, fin2,fin2.available());
        ps2.setInt(2, 13552);
        ps2.executeUpdate();
        PreparedStatement ps3 = con.prepareStatement("insert into profilepic values(?,?)");
        ps3.setBinaryStream(1, fin3,fin3.available());
        ps3.setInt(2, 13553);
        ps3.executeUpdate();
        PreparedStatement ps4 = con.prepareStatement("insert into profilepic values(?,?)");
        ps4.setBinaryStream(1, fin4,fin4.available());
        ps4.setInt(2, 13554);
        ps4.executeUpdate();
        PreparedStatement ps5 = con.prepareStatement("insert into profilepic values(?,?)");
        ps5.setBinaryStream(1, fin5,fin5.available());
        ps5.setInt(2, 13555);
        ps5.executeUpdate();
        //con.commit();
        con.close();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "EXCEPTION FOUND!", 1,new ImageIcon("..\\imazzges.jpg"));
        }
    }
    
    public static void main(String Args[]){
        new InsertImage();
    }
}

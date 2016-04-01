/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaproject;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 *
 * @author HP
 */
public class Profile {
    public Profile(String first,String last,String id,String rolln,String course,String cllg){
        JFrame jf;
        jf = new JFrame("HOME WINDOW");
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setIconImage(new ImageIcon("..\\Home-icon.png").getImage());
        final JLabel home,name,email,roll,crse,clg,jl1,jl2,jl3,jl4,jl5;
        JLabel dp = new JLabel();
        JButton logout,result;
        home = new JLabel(new ImageIcon("..\\home.jpg"));
        home.setBounds(30, 30, 230, 210);
        jf.add(home);
        //dp = new JLabel();
        //dp.setFont(new Font("Bradley Hand ITC",Font.BOLD|Font.ITALIC,22));
        //dp.setAlignmentX(9);
        //dp.setBounds(280, 40, 200, 190);
        //jf.add(dp);
        logout = new JButton("LOG OUT");
        logout.setBounds(535, 20, 100, 40);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.white);
        logout.setFont(new Font("Algerian",Font.ITALIC,16));
        jf.add(logout);
        result = new JButton(new ImageIcon("..\\result_icon.jpg"));
        result.setBounds(500,175,180,75);
        jf.add(result);
        Font font = new Font("Comic Sans MS",Font.ITALIC,24);
        name = new JLabel("NAME:");
        name.setBounds(60, 260, 200, 30);
        name.setFont(font);
        jf.add(name);
        email = new JLabel("EMAIL-ID:");
        email.setBounds(60, 310, 200, 30);
        email.setFont(font);
        jf.add(email);
        roll = new JLabel("ROLL NO.:");
        roll.setBounds(60, 360, 200, 30);
        roll.setFont(font);
        jf.add(roll);
        crse = new JLabel("COURSE:");
        crse.setBounds(60,410,200,30);
        crse.setFont(font);
        jf.add(crse);
        clg = new JLabel("COLLEGE:");
        clg.setBounds(60, 460, 200, 30);
        clg.setFont(font);
        jf.add(clg);
        jl1 = new JLabel();
        jl1.setBounds(300, 250, 300, 40);
        jl1.setFont(font);
        jf.add(jl1);
        jl2 = new JLabel();
        jl2.setBounds(300,300,300,40);
        jl2.setFont(font);
        jf.add(jl2);
        jl3 = new JLabel();
        jl3.setBounds(300, 350, 300, 40);
        jl3.setFont(font);
        jf.add(jl3);
        jl4 = new JLabel();
        jl4.setBounds(300, 400, 300, 40);
        jl4.setFont(font);
        jf.add(jl4);
        jl5 = new JLabel();
        jl5.setBounds(300,450,300,40);
        jl5.setFont(font);
        jf.add(jl5);
        jf.setBounds(350, 40, 700, 550);
        jl1.setText(first + "   " + last);
        jl2.setText(id);
        jl3.setText(rolln);
        jl4.setText(course);
        jl5.setText(cllg);
       try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/results","root","123");
            PreparedStatement stm = conn.prepareStatement("select dp from profilepic where rollno ='"+jl3.getText()+"'");
            ResultSet rs = stm.executeQuery();
            //rs.next();
            //URL path = rs.getURL("url");
            //dp.setIcon(new ImageIcon("path"));
            byte[] image;
            /*while(rs.next()){
                image = rs.getBytes("dp");
            }*/
            // BEST PART OF MY CODE IS TO APPLY IMAGE ON FRAME BY RETRIEVING BYTE CODE OF IMAGE FROM DATABASE
            rs.next();
            image = rs.getBytes("dp");
            Image img = Toolkit.getDefaultToolkit().createImage(image);
            ImageIcon icon = new ImageIcon(img);
            dp.setIcon(icon);
            //PreparedStatement ps = conn.prepareStatement("select url from profilepicture where rollno ='"+jl3.getText()+"'");
            //Statement ps = conn.createStatement();
            //ResultSet rs = ps.executeQuery();
            //ResultSet rs = ps.executeQuery("select url from profilepicture where rollno ='"+jl3.getText()+"'");
            //if(rs.next()){
            //rs.next();
            //dp = new JLabel(new ImageIcon(rs.getString("url")));
            //dp.setFont(new Font("Bradley Hand ITC",Font.BOLD|Font.ITALIC,22));
        //dp.setAlignmentX(9);
            //dp.setBounds(280, 40, 200, 190);
            //jf.add(dp);
            //URL path = rs.getURL("url");
            //BufferedImage c = ImageIO.read(path);
            ///ImageIcon image = new ImageIcon(c);
            //dp.setIcon(image);
            //dp = new JLabel(new ImageIcon(path));
        //dp.setFont(new Font("Bradley Hand ITC",Font.BOLD|Font.ITALIC,22));
        //dp.setAlignmentX(9);
        dp.setBounds(280, 40, 200, 190);
        jf.add(dp);
            //dp.setIcon(new ImageIcon(rs.getString("url")));
            //dp.setIcon(new ImageIcon(rs.getString("url")));
            //Blob b = rs.getBlob("dp");
            //dp.setIcon((Icon) b);
            
            //dp.setIcon( (Icon) b);
            //byte barr[]=b.getBytes(1, (int) b.length());
            //FileOutputStream fout = new FileOutputStream("d:\\sonoo.jpg");
            //fout.write(barr);
           // ps.executeUpdate();
            conn.close();
        }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex,"ALERT!",1,new ImageIcon("..\\imazzges.jpg"));
                    System.exit(1);
                }
        
        
        logout.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            JOptionPane.showMessageDialog(null, "LOGGED OUT SUCCESSFULLY!", "POP-UP", 1);
                new LogIn();
            }
            
        });
        
        result.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/results","root","123"); 
                        Statement stm = c.createStatement();
                        ResultSet rs = stm.executeQuery("select * from marks where rollno ='"+jl3.getText()+"' ");
                        rs.next();
                        
                        //new Result(rs.getString("english"),rs.getString("maths"),rs.getString("physics"),rs.getString("chemistry"),rs.getString("comp_science"));
                        //PreparedStatement ps = c.prepareStatement("select * from marks where rollno ='"+jl3.getText()+"'");
                        //ResultSet rs = ps.executeQuery();
                        Result a = new Result(rs.getString("english"),rs.getString("maths"),rs.getString("physics"),rs.getString("chemistry"),rs.getString("comp_science"));
                        //ps.executeUpdate();
                        // new Result(ps.getString("english"),ps.getString("maths"),ps.getString("physics"),ps.getString("chemistry"),ps.getString("comp_science"));
                    
                }catch(ClassNotFoundException | SQLException ex){
                    JOptionPane.showMessageDialog(null, ex ,"ALERT!",1,new ImageIcon("..\\imazzges.jpg"));
                    System.exit(1);
                }
                //new Result();
                
                
                //new Result();
            }
            
        });
        
        
    }
    public Profile(){
        JFrame jf;
        jf = new JFrame("HOME WINDOW");
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setIconImage(new ImageIcon("..\\Home-icon.png").getImage());
        JLabel home,name,email,roll,crse,clg,jl1,jl2,jl3,jl4,jl5;
        JLabel dp;
        JButton logout,result;
        home = new JLabel(new ImageIcon("..\\home.jpg"));
        home.setBounds(30, 30, 230, 210);
        jf.add(home);
        dp = new JLabel("PROFILE PICTURE");
        dp.setFont(new Font("Bradley Hand ITC",Font.BOLD|Font.ITALIC,22));
        //dp.setAlignmentX(9);
        dp.setBounds(280, 40, 200, 190);
        jf.add(dp);
        logout = new JButton("LOG OUT");
        logout.setBounds(535, 20, 100, 40);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.white);
        logout.setFont(new Font("Algerian",Font.ITALIC,16));
        jf.add(logout);
        result = new JButton(new ImageIcon("..\\result_icon.jpg"));
        result.setBounds(500,175,180,75);
        jf.add(result);
        Font font = new Font("Comic Sans MS",Font.ITALIC,24);
        name = new JLabel("NAME:");
        name.setBounds(60, 260, 200, 30);
        name.setFont(font);
        jf.add(name);
        email = new JLabel("EMAIL-ID:");
        email.setBounds(60, 310, 200, 30);
        email.setFont(font);
        jf.add(email);
        roll = new JLabel("ROLL NO.:");
        roll.setBounds(60, 360, 200, 30);
        roll.setFont(font);
        jf.add(roll);
        crse = new JLabel("COURSE:");
        crse.setBounds(60,410,200,30);
        crse.setFont(font);
        jf.add(crse);
        clg = new JLabel("COLLEGE:");
        clg.setBounds(60, 460, 200, 30);
        clg.setFont(font);
        jf.add(clg);
        jl1 = new JLabel();
        jl1.setBounds(300, 260, 300, 30);
        jl1.setFont(font);
        jf.add(jl1);
        jl2 = new JLabel();
        jl2.setBounds(300,310,300,30);
        jl2.setFont(font);
        jf.add(jl2);
        jl3 = new JLabel();
        jl3.setBounds(300, 360, 300, 30);
        jl3.setFont(font);
        jf.add(jl3);
        jl4 = new JLabel();
        jl4.setBounds(300, 410, 300, 30);
        jl4.setFont(font);
        jf.add(jl4);
        jl5 = new JLabel();
        jl5.setBounds(360,460,300,30);
        jl5.setFont(font);
        jf.add(jl5);
        jf.setBounds(350, 40, 700, 550);
        
        
        logout.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            JOptionPane.showMessageDialog(null, "LOGGED OUT SUCCESSFULLY!", "POP-UP", 1);
                new LogIn();
            }
            
        });
        
        result.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            new Result();
            }
            
        });
        
        
    }
    
    
    public static void main(String args[]){
        new Profile();
    }
}

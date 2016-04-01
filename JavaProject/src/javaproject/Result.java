/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author HP
 */
public class Result {
    public Result(String english,String maths,String physics,String chemistry,String cs){
        JFrame jf;
        jf = new JFrame("RESULT WINDOW");
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setIconImage(new ImageIcon("..\\ResultIcon.png").getImage());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton home,logout;
        final JLabel jl1,jl2,ricon,eng,math,phy,chm,cse,jlm1,jlm2,jlm3,jlm4,jlm5,total,jlm6,percent,jlm7,status;
        home = new JButton(new ImageIcon("..\\imagesn.jpg"));
        home.setBounds(30, 30, 170, 150);
        jf.add(home);
        Font font1 = new Font("Tempus Sans ITC",Font.ITALIC|Font.BOLD,15);
        jl1 = new JLabel(" <- CLICK HERE TO ");
        jl1.setBounds(210, 60, 150, 30);
        jl1.setFont(font1);
        jl1.setForeground(Color.blue);
        jf.add(jl1);
        jl2 = new JLabel("    GO BACK HOME ");
        jl2.setForeground(Color.blue);
        jl2.setBounds(210, 90, 150, 30);
        jl2.setFont(font1);
        jf.add(jl2);
        logout = new JButton("LOG OUT");
        logout.setBounds(400, 20, 100, 40);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.setFont(new Font("Algerian",Font.ITALIC,16));
        jf.add(logout);
        ricon = new JLabel(new ImageIcon("..\\icon-result.jpg"));
        ricon.setBounds(60, 210, 400, 150);
        jf.add(ricon);
        Font font = new Font("Chaparral Pro Light",Font.BOLD|Font.ITALIC,20);
        eng = new JLabel("ENGLISH:");
        eng.setBounds(50, 380, 200, 30);
        eng.setFont(font);
        jf.add(eng);
        math = new JLabel("MATHS:");
        math.setBounds(50, 430, 200, 30);
        math.setFont(font);
        jf.add(math);
        phy = new JLabel("PHYSICS:");
        phy.setBounds(50, 480, 200, 30);
        phy.setFont(font);
        jf.add(phy);
        chm = new JLabel("CHEMISTRY:");
        chm.setBounds(50, 530, 200, 30);
        chm.setFont(font);
        jf.add(chm);
        cse = new JLabel("COMPUTER SCIENCE:");
        cse.setBounds(50, 580, 200, 30);
        cse.setFont(font);
        jf.add(cse);
        total = new JLabel("TOTAL MARKS :");
        total.setBounds(50, 640, 200, 30);
        total.setFont(font);
        jf.add(total);
        jlm6 = new JLabel();
        jlm6.setBounds(280, 640, 50, 30);
        jlm6.setFont(font);
        total.setFont(font);
        jf.add(jlm6);
        jlm1 = new JLabel();
        jlm1.setBounds(280, 380, 50, 30);
        jlm1.setFont(font);
        jf.add(jlm1);
        jlm2 = new JLabel();
        jlm2.setBounds(280, 430, 50, 30);
        jlm2.setFont(font);
        jf.add(jlm2);
        jlm3 = new JLabel();
        jlm3.setBounds(280, 480, 50, 30);
        jlm3.setFont(font);
        jf.add(jlm3);
        jlm4 = new JLabel();
        jlm4.setBounds(280, 530, 50, 30);
        jlm4.setFont(font);
        jf.add(jlm4);
        jlm5 = new JLabel();
        jlm5.setBounds(280, 580, 50, 30);
        jlm5.setFont(font);
        jf.add(jlm5);
        jf.setBounds(390, 0, 520, 720);
        jlm1.setText(english);
        jlm2.setText(maths);
        jlm3.setText(physics);
        jlm4.setText(chemistry);
        jlm5.setText(cs);
        percent = new JLabel("PERCENTAGE");
        percent.setBounds(330, 430, 150, 30);
        percent.setFont(font);
        jf.add(percent);
        jlm7 = new JLabel();
        jlm7.setBounds(390, 450, 60, 30);
        jlm7.setFont(font);
        jf.add(jlm7);
        status = new JLabel();
        status.setBounds(360, 540, 100, 30);
        status.setFont(new Font("Lucida Handwriting",Font.BOLD|Font.ITALIC,22));
        jf.add(status);
         try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/results","root","123");
                Statement stmt = con.createStatement();
                ResultSet rs1 = stmt.executeQuery("select * from marks where english='"+jlm1.getText()+"'");
                rs1.next();
                int sum = rs1.getInt("english")+ rs1.getInt("maths")+rs1.getInt("physics")+rs1.getInt("chemistry")+rs1.getInt("comp_science");
                //jlm6.setText(String.valueOf(sum));// IT ALSO MAKES INTEGER TYPE VALUES INTO STRINGS
                jlm6.setText(sum+"");// TRICK TO MAKE INTEGER TYPE VALUE INTO STRING
                double percentage = sum/5;
                jlm7.setText(percentage+" %");
                if(percentage<40){
                    status.setText("FAIL");
                    status.setForeground(Color.red);
                }
                else
                {
                    status.setText("PASS");
                    status.setForeground(Color.GREEN);
                }
         }catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex ,"ALERT!",1,new ImageIcon("..\\imazzges.jpg"));
                 System.exit(1);
            }
        
        
        home.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/results","root","123");
                Statement stmt = con.createStatement();
                ResultSet rs1 = stmt.executeQuery("select rollno from marks where english='"+jlm1.getText()+"'");
                rs1.next();
                int roll = rs1.getInt("rollno");
                ResultSet rs2 = stmt.executeQuery("select * from stud_info where rollno='"+roll+"'");
                rs2.next();
                new Profile(rs2.getString("fname"),rs2.getString("lname"),rs2.getString("email"),rs2.getString("rollno"),rs2.getString("crse"),rs2.getString("college"));
                
            }catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex ,"ALERT!",1,new ImageIcon("..\\imazzges.jpg"));
                 System.exit(1);
            }
                
            }
        
    });
        
        logout.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            JOptionPane.showMessageDialog(null, "LOGGED OUT SUCCESSFULLY!", "POP-UP", 1);
                new LogIn();
            }
            
        });
        
    }
    
    public Result(){
        JFrame jf;
        jf = new JFrame("RESULT WINDOW");
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setIconImage(new ImageIcon("..\\ResultIcon.png").getImage());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton home,logout;
        JLabel jl1,jl2,ricon,eng,math,phy,chm,cse,jlm1,jlm2,jlm3,jlm4,jlm5,total,jlm6,jlm7,percent,status;
        home = new JButton(new ImageIcon("..\\imagesn.jpg"));
        home.setBounds(30, 30, 170, 150);
        jf.add(home);
        Font font1 = new Font("Tempus Sans ITC",Font.ITALIC|Font.BOLD,15);
        jl1 = new JLabel(" <- CLICK HERE TO ");
        jl1.setBounds(210, 60, 150, 30);
        jl1.setFont(font1);
        jl1.setForeground(Color.blue);
        jf.add(jl1);
        jl2 = new JLabel("    GO BACK HOME ");
        jl2.setForeground(Color.blue);
        jl2.setBounds(210, 90, 150, 30);
        jl2.setFont(font1);
        jf.add(jl2);
        logout = new JButton("LOG OUT");
        logout.setBounds(400, 20, 100, 40);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.setFont(new Font("Algerian",Font.ITALIC,16));
        jf.add(logout);
        ricon = new JLabel(new ImageIcon("..\\icon-result.jpg"));
        ricon.setBounds(60, 210, 400, 150);
        jf.add(ricon);
        Font font = new Font("Chaparral Pro Light",Font.BOLD|Font.ITALIC,20);
        eng = new JLabel("ENGLISH:");
        eng.setBounds(50, 380, 200, 30);
        eng.setFont(font);
        jf.add(eng);
        math = new JLabel("MATHS:");
        math.setBounds(50, 430, 200, 30);
        math.setFont(font);
        jf.add(math);
        phy = new JLabel("PHYSICS:");
        phy.setBounds(50, 480, 200, 30);
        phy.setFont(font);
        jf.add(phy);
        chm = new JLabel("CHEMISTRY:");
        chm.setBounds(50, 530, 200, 30);
        chm.setFont(font);
        jf.add(chm);
        cse = new JLabel("COMPUTER SCIENCE:");
        cse.setBounds(50, 580, 200, 30);
        cse.setFont(font);
        jf.add(cse);
        total = new JLabel("TOTAL MARKS :");
        total.setBounds(50, 640, 200, 30);
        total.setFont(font);
        jf.add(total);
        jlm6 = new JLabel();
        jlm6.setBounds(280, 640, 200, 30);
        total.setFont(font);
        jf.add(jlm6);
        jlm1 = new JLabel();
        jlm1.setBounds(280, 380, 200, 30);
        jlm1.setFont(font);
        jf.add(jlm1);
        jlm2 = new JLabel();
        jlm2.setBounds(280, 430, 200, 30);
        jlm2.setFont(font);
        jf.add(jlm2);
        jlm3 = new JLabel();
        jlm3.setBounds(280, 480, 200, 30);
        jlm3.setFont(font);
        jf.add(jlm3);
        jlm4 = new JLabel();
        jlm4.setBounds(280, 530, 200, 30);
        jlm4.setFont(font);
        jf.add(jlm4);
        jlm5 = new JLabel();
        jlm5.setBounds(280, 580, 200, 30);
        jlm5.setFont(font);
        jf.add(jlm5);
        jf.setBounds(390, 0, 520, 720);
        percent = new JLabel("PERCENTAGE");
        percent.setBounds(330, 430, 150, 30);
        percent.setFont(font);
        jf.add(percent);
        jlm7 = new JLabel();
        jlm7.setBounds(390, 480, 50, 30);
        jlm7.setFont(font);
        jf.add(jlm7);
        status = new JLabel();
        status.setBounds(360, 600, 60, 30);
        status.setFont(font);
        jf.add(status);
        
        home.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            new Profile();
            }
        
    });
        
        logout.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            JOptionPane.showMessageDialog(null, "LOGGED OUT SUCCESSFULLY!", "POP-UP", 1);
                new LogIn();
            }
            
        });
        
    }
    public static void main(String []args){
        new Result();
    }
}

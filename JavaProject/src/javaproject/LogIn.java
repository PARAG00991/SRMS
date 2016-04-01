/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.sql.*;

/**
 *
 * @author HP
 */
public class LogIn {
    public LogIn(){
        JFrame jf;
        final JLabel login,jl1,jl2,jl3,user,lock,name,pass;
        final JTextField jtf;
        final JPasswordField jpf;
        JButton log,sign;
        jf = new JFrame("LOG IN WINDOW");
        jf.setIconImage(new ImageIcon("..\\login1.jpg").getImage());
        jf.setLayout(null);
        jf.setVisible(true);
        login = new JLabel(new ImageIcon("..\\loginn.jpg"));
        login.setBounds(-2, 0, 600, 85);
        jf.add(login);
        Font font = new Font("Lucida Calligraphy",Font.BOLD,24);
        jl1 = new JLabel(" Enter USERNAME and PASSWORD ");
        jl1.setBounds(30, 85, 540, 30);
        jl1.setFont(font);
        jl1.setForeground(Color.blue);
        jf.add(jl1);
        jl2 = new JLabel("     in order to access your account ");
        jl2.setBounds(30, 115, 540, 30);
        jl2.setFont(font);
        jl2.setForeground(Color.blue);
        jf.add(jl2);
        jl3 = new JLabel("        and to check your RESULT ");
        jl3.setBounds(30, 145, 540, 30);
        jl3.setFont(font);
        jl3.setForeground(Color.blue);
        jf.add(jl3);
        user = new JLabel(new ImageIcon("..\\user.jpg"));
        user.setBounds(20, 190, 55, 80);
        jf.add(user);
        Font font1 = new Font("Charlemagne Std",Font.BOLD,22);
        Font font2 = new Font("Century Schoolbook",Font.BOLD|Font.ITALIC,20);
        name = new JLabel("USER NAME:");
        name.setBounds(90, 210, 150, 40);
        name.setFont(font1);
        name.setForeground(Color.black);
        jf.add(name);
        jtf = new JTextField();
        jtf.setFont(font2);
        jtf.setBounds(270, 210, 250, 40);
        jf.add(jtf);
        lock = new JLabel(new ImageIcon("..\\lock.jpg"));
        lock.setBounds(25, 300, 50, 75);
        jf.add(lock);
        pass = new JLabel("PASSWORD:");
        pass.setBounds(90,315,150,40);
        pass.setForeground(Color.black);
        pass.setFont(font1);
        jf.add(pass);
        jpf = new JPasswordField();
        jpf.setBounds(270, 315, 250, 40);
        jpf.setFont(font2);
        jf.add(jpf);
        log = new JButton(new ImageIcon("..\\photo-login2.jpg"));
        log.setBounds(400, 385, 170, 55);
        jf.add(log);
        sign = new JButton("NEW USERS CLICK HERE");
        sign.setBounds(0, 470, 600, 40);
        sign.setBackground(Color.BLACK);
        sign.setForeground(Color.WHITE);
        sign.setFont(new Font("Trajan Pro",Font.BOLD,23));
        jf.add(sign);
        jf.setBounds(370, 30, 600, 548);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        sign.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            new SignUp();
            }
            
        });
        
        log.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(jtf.getText().equals("")){
                    jtf.setText(JOptionPane.showInputDialog(null,"ENTER USER NAME","ALERT!",1));
                }
                else if(jpf.getText().equals("")){
                    jpf.setText(JOptionPane.showInputDialog(null,"ENTER PASSWORD","ALERT!",1));
                }
                else{
                    gr8:  { try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/results","root","123");
                    Statement stmt = con.createStatement();
                    ResultSet rst = stmt.executeQuery("select * from stud_info");
                     while(rst.next()){
                        if((jtf.getText().equals(rst.getString("username")))&& (jpf.getText().equals(rst.getString("password"))))
                        {
                            JOptionPane.showMessageDialog(null, "ACCESS GRANTED", "POP-UP", 1);
                            new Profile(rst.getString("fname"), rst.getString("lname"),rst.getString("email"), rst.getString("rollno"),rst.getString("crse"),rst.getString("college"));
                            //public void userdetails(){
                            //Profile userd = null;
                            //userd.userdetails(rst.getString("fname"), rst.getString("lname"),rst.getString("email"), rst.getInt("rollno"),rst.getString("crse"),rst.getString("college"));
                            
                            break gr8;
                            
                        }
                         
                    }
                    Statement stmt1 = con.createStatement();
                    ResultSet rst1 = stmt1.executeQuery("select username from stud_info");
                    cya: {
                         while(rst1.next()){
                        if((jtf.getText().equals(rst1.getString("username")))){
                           //jtf.setText(JOptionPane.showInputDialog(null, "Unregistered USERNAME..ENTER VALID USER NAME", "ALERT!", 1));
                           break cya;
                        }
                    }
                    jtf.setText(JOptionPane.showInputDialog(null, "Unregistered USERNAME..ENTER VALID USER NAME", "ALERT!", 1));
                    break gr8;
                    } 
                    /*String user = jtf.getText();
                    try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/results","root","123");
                    Statement ps1 = con1.createStatement();
                    ResultSet rs1 = ps1.executeQuery("select password from stud_info where username='"+user+"'");
                    if(!(jpf.getText().equals(rs1.getString("password")))){
                        jpf.setText(JOptionPane.showInputDialog(null, "ENTER VALID PASSWORD", "ALERT!",1));
                    }
                    con1.close();}
                    catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "EXCEPTION FOUND","ALERT!",1,new ImageIcon("E:\\Netbeans projects\\Database_Project\\imazzges.jpg"));
                    System.exit(1);
                    }*/
                    jpf.setText(JOptionPane.showInputDialog(null, "PASSWORD INCORRECT...ENTER VALID PASSWORD", "ALERT!",1));
                  con.close();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "EXCEPTION FOUND","ALERT!",1,new ImageIcon("..\\imazzges.jpg"));
                    System.exit(1);
                }
                    }
                //if(jtf.getText().equals(e))
                
                //new Profile();
            }
            }
            
        });
    }
            
    public static void main(String []args){
        new LogIn();
    }
}

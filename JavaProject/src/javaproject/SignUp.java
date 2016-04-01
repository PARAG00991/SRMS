/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author HP
 */
public class SignUp {
    public SignUp(){
     JFrame jf;
     JLabel fn,ln,email,name,pass,cpass,account,signup1,signup2,signup,gender;
     final JTextField jtf1,jtf2,jtf3,jtf4;
     final JPasswordField jpf1,jpf2;
     JButton login,register;
     final JRadioButton male,female;
     final ButtonGroup gendergrp;
     String a;
     //JSlider js = new JSlider(JSlider.VERTICAL,0,100,0);
        jf = new JFrame("SIGN UP WINDOW");
        //js.setPaintLabels(true);
        //js.setPaintTicks(true);
        //js.setVisible(true);
        //js.setPaintTrack(true);
        //jf.add(js);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        jf.setIconImage(new ImageIcon("..\\sign.jpg").getImage());
        signup = new JLabel(new ImageIcon("..\\SIGNUP.jpg"));
        signup.setBounds(30, 25, 250, 135);
        jf.add(signup);
        signup1 = new JLabel("IF ALREADY REGISTERED");
        signup1.setBounds(300, 30, 250, 30);
        signup1.setFont(new Font("Lucida Handwriting",Font.BOLD|Font.ITALIC,16));
        signup1.setForeground(Color.BLUE);
        jf.add(signup1);
        signup2 = new JLabel("Click Here To");
        signup2.setForeground(Color.BLUE);
        signup2.setBounds(350, 60, 165, 30);
        signup2.setFont(new Font("Lucida Handwriting",Font.BOLD|Font.ITALIC,16));
        jf.add(signup2);
        login = new JButton("LOG IN");
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setFont(new Font("CASTELLAR",Font.BOLD|Font.ITALIC,13));
        login.setBounds(370, 95, 95, 30);
        jf.add(login);
        account = new JLabel("CREATE A NEW ACCOUNT");
        account.setFont(new Font("Bradley Hand ITC",Font.BOLD|Font.ITALIC,34));
        account.setForeground(Color.BLUE);
        account.setBounds(40, 175, 460, 40);
        jf.add(account);
        Font font = new Font("Comic Sans MS",Font.ITALIC,22);
        fn = new JLabel("First Name:");
        fn.setBounds(40, 240, 200, 20);
        fn.setFont(font);
        jf.add(fn);
        ln = new JLabel("Last Name:");
        ln.setBounds(40, 290, 200, 20);
        ln.setFont(font);
        jf.add(ln);
        gender = new JLabel("Gender:");
        gender.setBounds(40, 340, 200, 20);
        gender.setFont(font);
        jf.add(gender);
        email = new JLabel("Email ID:");
        email.setFont(font);
        email.setBounds(40, 390, 200, 20);
        jf.add(email);
        name = new JLabel("User Name:");
        name.setBounds(40, 440, 200, 20);
        name.setFont(font);
        jf.add(name);
        pass = new JLabel("Password:");
        pass.setFont(font);
        pass.setBounds(40, 490, 200, 20);
        jf.add(pass);
        cpass = new JLabel("Confirm Password:");
        cpass.setFont(font);
        cpass.setBounds(40, 540, 200, 20);
        jf.add(cpass);
        Font font1 = new Font("Tempus Sans ITC",Font.ITALIC|Font.BOLD,18);
        jtf1 = new JTextField();
        jtf1.setBounds(300, 235, 220, 30);
        jtf1.setFont(font1);
        jtf1.setForeground(Color.DARK_GRAY);
        jf.add(jtf1);
        jtf2 = new JTextField();
        jtf2.setBounds(300, 285, 220, 30);
        jtf2.setFont(font1);
        jtf2.setForeground(Color.DARK_GRAY);
        jf.add(jtf2);
        male = new JRadioButton("MALE");
        male.setBounds(300, 335, 100, 30);
        male.setFont(font1);
        male.setForeground(Color.red);
        jf.add(male);
        /*male.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent e) {
             //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          //String s = e.getActionCommand();
          //s=this.s;
             String s = male.getText();
             a = this.s;
         }
            
        });*/
        female = new JRadioButton("FEMALE");
        female.setBounds(420, 335, 100, 30);
        female.setFont(font1);
        female.setForeground(Color.red);
        jf.add(female);
        /*female.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent e) {
             //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          //s = e.getActionCommand();
             String s = female.getText();
             a = this.s;
             
         }
            
        });*/
        gendergrp = new ButtonGroup();
        gendergrp.add(male);
        gendergrp.add(female);
        //jf.add(gendergrp);
        jtf3 = new JTextField();
        jtf3.setBounds(300, 385, 220, 30);
        jtf3.setFont(font1);
        jtf3.setForeground(Color.DARK_GRAY);
        jf.add(jtf3);
        jtf4 = new JTextField();
        jtf4.setBounds(300, 435, 220, 30);
        jtf4.setFont(font1);
        jtf4.setForeground(Color.DARK_GRAY);
        jf.add(jtf4);
        jpf1 = new JPasswordField();
        jpf1.setBounds(300, 485, 220, 30);
        jpf1.setFont(font1);
        jpf1.setForeground(Color.DARK_GRAY);
        jf.add(jpf1);
        jpf2 = new JPasswordField();
        jpf2.setBounds(300, 535, 220, 30);
        jpf2.setFont(font1);
        jpf2.setForeground(Color.DARK_GRAY);
        jf.add(jpf2);
        register = new JButton("SUBMIT");
        register.setBounds(215, 595, 120, 40);
        register.setFont(new Font("Chaparral Pro Light",Font.BOLD|Font.ITALIC,20));
        register.setForeground(Color.BLACK);
        jf.add(register);
        jf.setBounds(350, 20, 575, 690);
        //jf.setGlassPane(pass);
        //jf.setOpacity((float) 599.3);
        login.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent e) {
             //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         new LogIn();
         }
            
        });
        register.addActionListener(new ActionListener(){
        //String s1="1@gmail.com";
           // ResultSet rs;
         @Override
                 public void actionPerformed(ActionEvent e) {
                   /*  try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/results","root","123");
             String user = jtf4.getText();
             Statement stmt = con.createStatement();
             //PreparedStatememt stmt = con.prepareStatement("select * from stud_info");
             rs = stmt.executeQuery("select username from stud_info");
                     }
                     catch(Exception ex){
                      JOptionPane.showMessageDialog(null, ex, "EXCEPTION FOUND", 1,new ImageIcon("E:\\Netbeans projects\\Database_Project\\imazzges.jpg"));
                      System.exit(1);  
                     }*/
             //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             /*try{
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/results","root","123");
                 PreparedStatement ps = c.prepareStatement("update gen set fname= jtf1 where email= jtf4");
                 c.close();
                 
             }catch(Exception exc){
                 System.out.println(exc);
             }*/
             //JOptionPane.showMessageDialog(null,"HELLO", "ALERT!", 1,new ImageIcon("E:\\Netbeans projects\\Database_Project\\imazzges.jpg"));
            //JOptionPane.showMessageDialog(null, "ALERT!!!!!!!!!!", null,1);
             if(jtf1.getText().equals("")){
                 //JOptionPane.showMessageDialog(null, "ENTER FIRST NAME", "ALERT!", 1);
                 //continue Label;
                 //jtf1 = new JTextField(JOptionPane.showInputDialog("ENTER YOUR FIRST NAME"));
                 jtf1.setText(JOptionPane.showInputDialog("ENTER YOUR FIRST NAME"));
                 //actionPerformed();
                  
             }
             else if(jtf2.getText().equals("")){
                 //JOptionPane.showMessageDialog(null, "ENTER LAST NAME", "ALERT!", 1);
                 //JOptionPane.showInputDialog("hello");
                 jtf2.setText(JOptionPane.showInputDialog("ENTER YOUR LAST NAME"));
             }
             //else if(male.getText().equals("male")|female.getText().equals("female")){
             else if(!male.isSelected() && !female.isSelected()){
                 JOptionPane.showMessageDialog(null, "SELECT YOUR GENDER", "ALERT!", 1);
             }  
             else if(jtf3.getText().equals("")){
                 jtf3.setText(JOptionPane.showInputDialog(null, "ENTER E-MAIL ID","ALERT!",1));
             }
             //else if(jtf3.getText().equals("1@gmail.com"));
                
             /*else if(!(jtf3.getText().equals("1@gmail.com"))){
                 jtf3.setText(JOptionPane.showInputDialog("Enter valid Email ID from \"1@gmail.com\",\"2@gmail.com\",\"3@gmail.com\",\"4@gmail.com\",\"5@gmail.com\""));
             }
             else if(!(jtf3.getText().equals("2@gmail.com")) | !(jtf3.getText().equals("1@gmail.com"))){
                 jtf3.setText(JOptionPane.showInputDialog("Enter valid Email ID from \"1@gmail.com\",\"2@gmail.com\",\"3@gmail.com\",\"4@gmail.com\",\"5@gmail.com\""));
             }
             else if(!(jtf3.getText().equals("3@gmail.com"))){
                 jtf3.setText(JOptionPane.showInputDialog("Enter valid Email ID from \"1@gmail.com\",\"2@gmail.com\",\"3@gmail.com\",\"4@gmail.com\",\"5@gmail.com\""));
             }
             else if(!(jtf3.getText().equals("4@gmail.com"))){
                 jtf3.setText(JOptionPane.showInputDialog("Enter valid Email ID from \"1@gmail.com\",\"2@gmail.com\",\"3@gmail.com\",\"4@gmail.com\",\"5@gmail.com\""));
             }
             else if(!(jtf3.getText().equals("5@gmail.com"))){
                 jtf3.setText(JOptionPane.showInputDialog("Enter valid Email ID from \"1@gmail.com\",\"2@gmail.com\",\"3@gmail.com\",\"4@gmail.com\",\"5@gmail.com\""));
             }*/
             else if(!((jtf3.getText().equals("1@gmail.com"))|(jtf3.getText().equals("2@gmail.com"))|(jtf3.getText().equals("3@gmail.com"))|(jtf3.getText().equals("4@gmail.com"))|(jtf3.getText().equals("5@gmail.com")))){
                 jtf3.setText(JOptionPane.showInputDialog("Enter valid Email ID from \"1@gmail.com\",\"2@gmail.com\",\"3@gmail.com\",\"4@gmail.com\",\"5@gmail.com\""));
             }
             else if(jtf4.getText().equals("")){
                 jtf4.setText(JOptionPane.showInputDialog("ENTER USERNAME"));
             }
             else if(true){
                 hi: { 
                     String gen;
                     if(male.isSelected()){
                         gen="male";
                     }
                     else
                         gen="female";
                     try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/results","root","123");
             String user = jtf4.getText();
             Statement stmt = con.createStatement();
             //PreparedStatememt stmt = con.prepareStatement("select * from stud_info");
             ResultSet rs = stmt.executeQuery("select username from stud_info");
             
             hello: while(rs.next()){
                 
                 if(user.equals(rs.getString("username"))){
                     jtf4.setText(JOptionPane.showInputDialog(null, "Already Registered USERNAME..Please try another ..", "ALERT!", 1));
                     break hi;
                 }
             }
             
                 if(jpf1.getText().equals("")){
                 jpf1.setText(JOptionPane.showInputDialog("ENTER PASSWORD"));
                 //break hello;
             }
             else if(jpf2.getText().equals("")){
                 jpf2.setText(JOptionPane.showInputDialog("CONFIRM YOUR PASSWORD"));
                 //break hello;
             }
             else if((jpf1.getText()).equals(jpf2.getText())){
             try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/results","root","123");
             Statement stmt1 = conn.createStatement();
             stmt1.executeUpdate("update stud_info set fname ='"+jtf1.getText()+"',lname='"+jtf2.getText()+"',gender='"+gen+"',username='"+jtf4.getText()+"',password='"+jpf1.getText()+"'where email='"+jtf3.getText()+"' ");
             con.close();
             //JOptionPane.showInputDialog("hello");
             JOptionPane.showMessageDialog(null, "ALL DETAILS SUBMITTED SUCCESSULLY", "POP-UP",1);
             new LogIn();
             }
             catch(Exception exc){
                JOptionPane.showMessageDialog(null, exc, "EXCEPTION FOUND", 1,new ImageIcon("..\\imazzges.jpg"));
                System.exit(1);
             }
             //break hello;
             }
             
             //new LogIn();
             else
             {
                 JOptionPane.showMessageDialog(null, "CONFIRM YOUR PASSWORD CORRECTLY", "ALERT!", 1, new ImageIcon("..\\imazzges.jpg"));
             }
                 
             
             con.close();
                 }
             catch(Exception exc){
                JOptionPane.showMessageDialog(null, exc, "EXCEPTION FOUND", 1,new ImageIcon("..\\imazzges.jpg"));
                System.exit(1);
             } 
             
            }    
             }
         }
            
        });
        
    }
    
    public static void main(String args[]){
        new SignUp();
    }
}

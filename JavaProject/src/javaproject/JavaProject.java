/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaproject;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.font.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author HP
 */
public class JavaProject {

    /**
     * @param args the command line arguments
     */
    
    public JavaProject(){
        JFrame jf;
        JLabel img;
        JButton newuser,olduser;
        JTextArea signup,login;
        
        jf = new JFrame();
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setTitle("RESULTS 2014");
        jf.setVisible(true);
        //jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setIconImage(new ImageIcon("..\\res.jpg").getImage());
        img = new JLabel(new ImageIcon("..\\imagesg.jpg"));
        img.setBounds(120, 30, 250, 80);
        jf.add(img);
        Font font1 = new Font("Comic Sans MS",Font.BOLD|Font.ITALIC,15);
        signup = new JTextArea();
        //signup.setRows(4);
        signup.setText("    New Users:\n   Click on the \n'SIGN UP' Button \n     below for \n   Registration ");
        signup.setBounds(55, 160, 140, 120);
        signup.setFont(font1);
        signup.setBackground(Color.LIGHT_GRAY);
        signup.setForeground(Color.black);
        jf.add(signup);
        login = new JTextArea("      Already \n Registered Users:\n      Click on \n     'LOG IN' \n    Button below ");
        //login.setRows(4);
        login.setBounds(295, 160, 140, 120);
        login.setBackground(Color.LIGHT_GRAY);
        login.setForeground(Color.black);
        login.setFont(font1);
        //login.setEditable(false);
        jf.add(login);
        newuser = new JButton("SIGN UP");
        olduser = new JButton("LOG IN");
        newuser.setBounds(75, 310, 100, 50);
        newuser.setFont(new Font("ALGERIAN",Font.BOLD|Font.ITALIC,16));
        olduser.setBounds(315, 310, 100, 50);
        olduser.setFont(new Font("ALGERIAN",Font.BOLD|Font.ITALIC,16));
        newuser.setForeground(Color.blue);
        olduser.setForeground(Color.blue);
        jf.add(newuser);
        jf.add(olduser);
        jf.setLayout(null);
        jf.setBounds(400, 150, 490, 450);
        newuser.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            new SignUp();
            }
            
        });
        olduser.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            new LogIn();
            }
            
        });
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new JavaProject();
    }
    
}

package example;
 /*
1 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    JPanel p1;
    JTextField t1, t2, t3, t4;
    Choice c1;
    JButton b1, b2;
    Signup(){
    	setUndecorated(true);
        setBounds(450, 250, 700, 400);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 2, true), new LineBorder(new Color(255, 51, 51), 2, true)));
        lblNewLabel.setBounds(0, 0, 700, 400);
        lblNewLabel.setIcon(new ImageIcon(Signup.class.getResource("/icon/wallback.jpg")));
        getContentPane().add(lblNewLabel);
        
        p1 = new JPanel();
        p1.setBounds(150, 50, 400, 300);
        p1.setBackground(new Color(102, 205, 170,100));
        p1.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
        lblNewLabel.add(p1);
        p1.setLayout(null);
        
        JLabel l1 = new JLabel("Username");
        l1.setBounds(62, 34, 100, 20);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(l1);
        
        t1 = new JTextField();
        t1.setBounds(204, 37, 150, 20);
        p1.add(t1);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(62, 84, 100, 20);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(204, 84, 150, 20);
        p1.add(t2);
        
        
        JLabel l3 = new JLabel("Password");
        l3.setBounds(62, 126, 100, 20);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(l3);
        
        t3 = new JTextField();
        t3.setBounds(204, 129, 150, 20);
        p1.add(t3);
        
        
        JLabel l4 = new JLabel("Create Account As");
        l4.setBounds(59, 171, 140, 20);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(l4);
        
        
        JLabel l5 = new JLabel("Meter Number");
        l5.setBounds(62, 204, 132, 20);
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setVisible(false);
        p1.add(l5);
        
        t4 = new JTextField();
        t4.setBounds(204, 204, 150, 20);
        t4.setVisible(false);
        p1.add(t4);
        
        c1 = new Choice();
        c1.setBounds(204, 173, 150, 18);
        c1.add("Admin");
        c1.add("Customer");
        p1.add(c1);
        
        c1.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent ae){
               String user = c1.getSelectedItem();
               if(user.equals("Customer")){
                   l5.setVisible(true);
                   t4.setVisible(true);
               }else{
                   l5.setVisible(false);
                   t4.setVisible(false);
               }
           } 
        });
        
        
        b1 = new JButton("Create");
        b1.setBounds(79, 240, 120, 30);
        b1.setBackground(new Color(102, 0, 204));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        p1.add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(214, 240, 120, 30);
        b2.setBackground(new Color(102, 102, 255));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        p1.add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String user = c1.getSelectedItem();
            String meter = t4.getText();
            try{
                Conn c = new Conn();
                String str = null;
                if(user.equals("Admin")){
                    str = "insert into login values( '"+meter+"', '"+username+"', '"+name+"', '"+password+"', '"+user+"')";
                }else{
                    str = "update login set usename = '"+username+"', nam = '"+name+"', pass = '"+password+"', users = '"+user+"' where meter_no = '"+t4.getText()+"'";
                }
                
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                this.setVisible(false);
                new Login().setVisible(true);
            }catch(Exception e){
            	e.printStackTrace();
                System.out.println("error: "+e);
            }
        } else if(ae.getSource()== b2){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Signup().setVisible(true);
    }
}

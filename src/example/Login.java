package example;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.LineBorder;

public class Login extends JFrame implements ActionListener{
    JLabel l1,l2, l4;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2, b3;
    JPanel p1,p2,p3,p4;
    Choice c1;
    Login(){
        super("Login Page");
        setUndecorated(true);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        
        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        
        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i4 = ic4.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setBackground(new Color(0, 0, 0,80));
        panel.setBorder(new LineBorder(new Color(0, 153, 153), 2, true));
        panel.setBounds(68, 10, 356, 230);
        panel.setLayout(null);
        
        
        tf1 = new JTextField(15);
        tf1.setBounds(163, 39, 150, 20);
        panel.add(tf1);
        
        l4 = new JLabel("Logging in as");
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Tahoma", Font.BOLD, 13));
        l4.setBounds(57, 104, 100, 20);
        panel.add(l4);
        
        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(163, 104, 150, 18);
        panel.add(c1);
        b1 = new JButton("Login");
        		//,new ImageIcon(i1));
        b1.setBounds(67, 134, 100, 20);
        panel.add(b1);
        b2 = new JButton("Cancel");
        		//,new ImageIcon(i2));
        b2.setBounds(177, 134, 100, 20);
        panel.add(b2);
        
        l1 = new JLabel("Username");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.BOLD, 13));
        l1.setBounds(57, 39, 66, 16);
        panel.add(l1);
        l2 = new JLabel("Password");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma", Font.BOLD, 13));
        l2.setBounds(57, 69, 62, 16);
        panel.add(l2);
        pf2 = new JPasswordField(15);
        pf2.setBounds(163, 69, 150, 19);
        panel.add(pf2);
        
         
         b3 = new JButton("Signup");
        		 //,new ImageIcon(i4));
         b3.setBounds(121, 164, 109, 21);
         panel.add(b3);
         
         JLabel lblNewLabel = new JLabel("");
         lblNewLabel.setBorder(new LineBorder(new Color(128, 128, 128), 3, true));
         lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/icon/backgrounds.jpg")));
         lblNewLabel.setBackground(new Color(255, 0, 0));
         lblNewLabel.setBounds(0, 0, 500, 250);
         getContentPane().add(lblNewLabel);
       
         
        b3.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);

     
        setSize(500,250);
        setLocation(500,300);
        

        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{        
                Conn c = new Conn();
                String a  = tf1.getText();
                String b  = pf2.getText();
                String user = c1.getSelectedItem();
                String q  = "select * from login where BINARY usename = '"+a+"' and BINARY pass = '"+b+"' and users = '"+user+"'";
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next()){
                    String meter = rs.getString("meter_no");
                    new Project(user).setVisible(true);
                    this.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tf1.setText("");
                    pf2.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
            }
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            this.setVisible(false);
            new Signup().setVisible(true);
            
        }
    }
    
    public static void main(String[] args){

        new Login().setVisible(true);
    }
}




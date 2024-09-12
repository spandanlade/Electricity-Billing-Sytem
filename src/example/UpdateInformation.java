package example;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class UpdateInformation extends JFrame implements ActionListener{
    JTextField t1, t2, t3, t4, t5, t6, t7,l11;
    Choice l12;
    JButton b1, b2;
    UpdateInformation(){
    	setUndecorated(true);
        
        setBounds(500, 220, 670, 450);
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(255, 255, 255,70), 4, true));
        panel.setBackground(new Color(173, 216, 230));
        panel.setBounds(0, 0, 670, 450);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 70, 100, 20);
        panel.add(l1);
        
        l11 = new JTextField();
        l11.setBounds(230, 70, 200, 20);
        panel.add(l11);
        
        JLabel l2 = new JLabel("Meter Number");
        l2.setBounds(30, 110, 100, 20);
        panel.add(l2);
        
        l12 = new Choice();
        l12.setBounds(230, 110, 200, 20);
        panel.add(l12);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                l12.add(rs.getString("meter_no"));
            }
        }catch(Exception e){}
   	
        
        JLabel l3 = new JLabel("Address");
        l3.setBounds(30, 150, 100, 20);
        panel.add(l3);
        
        t1 = new JTextField();
        t1.setBounds(230, 150, 200, 20);
        panel.add(t1);
        
        JLabel l4 = new JLabel("City");
        l4.setBounds(30, 190, 100, 20);
        panel.add(l4);
        
        t2 = new JTextField();
        t2.setBounds(230, 190, 200, 20);
        panel.add(t2);
        
        JLabel l5 = new JLabel("State");
        l5.setBounds(30, 230, 100, 20);
        panel.add(l5);
        
        t3 = new JTextField();
        t3.setBounds(230, 230, 200, 20);
        panel.add(t3);
        
        JLabel l6 = new JLabel("Email");
        l6.setBounds(30, 270, 100, 20);
        panel.add(l6);
        
        t4 = new JTextField();
        t4.setBounds(230, 270, 200, 20);
        panel.add(t4);
        
        JLabel l7 = new JLabel("Phone");
        l7.setBounds(30, 310, 100, 20);
        panel.add(l7);
        
        t5 = new JTextField();
        t5.setBounds(230, 310, 200, 20);
        panel.add(t5);
        
        b1 = new JButton("Update");
        b1.setBounds(70, 360, 100, 25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(this);
        
        b2 = new JButton("Back");
        b2.setBounds(230, 360, 100, 25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        panel.add(b2);
        b2.addActionListener(this);
        
        
        JLabel title = new JLabel("UPDATE CUSTOMER INFORMATION");
        title.setBounds(157, 10, 320, 25);
        panel.add(title);
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
       
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2  = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
        	
        	
            String meter_no=l12.getSelectedItem();
            String s1 = l11.getText();
            String s3 = t1.getText();
            String s4 = t2.getText();
            String s5 = t3.getText();
            String s6 = t4.getText();
            String s7 = t5.getText();
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set nam='"+s1+"' , address = '"+s3+"', city = '"+s4+"', state = '"+s5+"', email = '"+s6+"', phone = '"+s7+"' where meter_no = '"+meter_no+"'");
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                this.setVisible(false);
                
            }catch(Exception e){}
            
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new UpdateInformation().setVisible(true);
        
    }
}

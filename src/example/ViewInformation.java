package example;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class ViewInformation extends JFrame implements ActionListener{
    
	JButton b1;
    JLabel title,l1,l11,l2,l12,l3,l13,l4,l14,l5,l15,l6,l16,l7,l17;
    JPanel panel,panel1;
    private JTextField meter_number;
    ViewInformation(){
    	setUndecorated(true);
        setBounds(400,180, 400, 200);
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);
        
        
       
        
       
        
       
        meter_number = new JTextField();
        meter_number.setBounds(71, 24, 217, 19);
        meter_number.setColumns(10);
        
        title = new JLabel("VIEW CUSTOMER INFORMATION");
        title.setBounds(250, 0, 500, 40);
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        
         l1 = new JLabel("Name");
        l1.setBounds(70, 80, 100, 20);
       
        
         l11 = new JLabel();
        l11.setForeground(Color.BLACK);
        l11.setBounds(160, 80, 100, 20);
        
        
         l2 = new JLabel("Meter Number");
        l2.setBounds(70, 140, 100, 20);
       
        
         l12 = new JLabel();
        l12.setForeground(Color.BLACK);
        
        l12.setBounds(160, 140, 100, 20);
        
        
         l3 = new JLabel("Address");
        l3.setBounds(70, 200, 100, 20);
      
        
         l13 = new JLabel();
        l13.setForeground(Color.BLACK);
        l13.setBounds(160, 200, 150, 20);
        
        
         l4 = new JLabel("City");
        l4.setBounds(70, 260, 100, 20);
      
        
         l14 = new JLabel();
        l14.setForeground(Color.BLACK);
        l14.setBounds(160, 260, 100, 20);
        
         l5 = new JLabel("State");
        l5.setBounds(500, 80, 100, 20);
        
         l15 = new JLabel();
        l15.setBounds(560, 80, 100, 20);
        
         l6 = new JLabel("Email");
        l6.setBounds(500, 140, 100, 20);
        
         l16 = new JLabel();
        l16.setBounds(560, 140, 150, 20);
       
        
         l7 = new JLabel("Phone");
        l7.setBounds(500, 200, 100, 20);
     
         l17 = new JLabel();
        l17.setBounds(560, 200, 100, 20);
        
        b1 = new JButton("Back");
        b1.setBorder(null);
        b1.setBounds(350, 340, 100, 25);
        b1.setBackground(new Color(102, 0, 204));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(255, 255, 255,70), 4, true));
        panel.setBackground(new Color(173, 216, 230));
        panel.setBounds(0, 0, 400, 200);
        getContentPane().add(meter_number);
        
        
        JLabel l8  = new JLabel(i3);
        l8.setBounds(20, 350, 600, 300);
       
        
        JButton ViewButton = new JButton("View");
        ViewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String meter=meter_number.getText();
        		if(meter==null) {
        			 JOptionPane.showMessageDialog(null, "Enter the Meter Number");
        			}
        		else {
        				ViewButton.setVisible(false);
        				meter_number.setVisible(false);
        				panel.setBounds(0,0,850,350);
        				
        				setBounds(400,180, 850, 650);
        				
        			   
        				getContentPane().add(title);
        		        getContentPane().add(l1);
        		        getContentPane().add(l11);
        		        getContentPane().add(l2);
        		        getContentPane().add(l12);
        		        getContentPane().add(l3);
        		        getContentPane().add(l13);
        		        getContentPane().add(l4);
        		        getContentPane().add(l14);
        		        getContentPane().add(l5);
        		        getContentPane().add(l15);
        		        getContentPane().add(l6);
        		        getContentPane().add(l16);
        		        getContentPane().add(l7);
        		        getContentPane().add(l17);
        		        getContentPane().add(b1);
        		        getContentPane().add(panel);
        		        getContentPane().add(l8);
        		        
        		        try{
        		            Conn c = new Conn();
        		            ResultSet rs = c.s.executeQuery("select *from customer where meter_no = "+meter+"");
        		            while(rs.next()){
        		                l11.setText(rs.getString(1));
        		                l12.setText(rs.getString(2));
        		                l13.setText(rs.getString(3));
        		                l15.setText(rs.getString(4));
        		                l14.setText(rs.getString(5));
        		                l16.setText(rs.getString(6));
        		                l17.setText(rs.getString(7));
        		                
        		            }
        		        }catch(Exception e){}
        		        
        		}
        	}
        });
        ViewButton.setBounds(102, 82, 139, 27);
        getContentPane().add(ViewButton);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new ViewInformation().setVisible(true);
    }
}

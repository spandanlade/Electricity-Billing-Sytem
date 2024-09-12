package example;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.LineBorder;


public class DepositeDetails extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1, b2,back;
    JLabel l1, l2;
    Choice c1;
    String x[] = {"Meter Number","Month","Units","Total Bill","Status"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    DepositeDetails(){
        super("Deposit Details");
        setUndecorated(true);
        setSize(700,750);
        setLocation(300,20);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        t1 = new JTable(y,x);
        t1.setBorder(new LineBorder(new Color(255, 255, 255,70), 4, true));
        t1.setBackground(new Color(173, 216, 230));
        
        try{
            Conn c  = new Conn();
            String s1 = "select * from bill";
            ResultSet rs  = c.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("meter_no");
                y[i][j++]=rs.getString("months");
                y[i][j++]=rs.getString("units");
                y[i][j++]=rs.getString("total_bill");
                y[i][j++]=rs.getString("payment_status");
                i++;
                j=0;
            }
            
            
            
          
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(t1);
        sp.setBackground(new Color(173, 216, 230,70));
        sp.setBorder(new LineBorder(new Color(128, 128, 128,100), 4, true));
        sp.setBounds(0, 100, 700, 650);
        getContentPane().add(sp);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(128, 128, 128,70), 4, true));
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 700, 103);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        back = new JButton("");
        back.setBorder(null);
        back.setBounds(660, 10, 30, 30);
        panel.add(back);
        back.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\cancel.jpg"));
        
        

        
        b2 = new JButton("Print");
        b2.setBounds(590, 73, 80, 20);
        panel.add(b2);
        b2.addActionListener(this);
        back.addActionListener(this);
        
        
        
     
    }

    
    public static void main(String[] args){
        new DepositeDetails().setVisible(true);
    }
	public void actionPerformed(ActionEvent ae) {

	        	if(ae.getSource() == b2){
	            try{
	                t1.print();
	            }catch(Exception e){}
	        }
	        	else if(ae.getSource()==back) {
	        		this.setVisible(false);
	        	}
	        	
	}
}

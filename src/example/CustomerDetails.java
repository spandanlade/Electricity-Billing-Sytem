package example;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.LineBorder;

public class CustomerDetails extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1,b2;
    String x[] = {"Customer Name","Meter Number","Address","City","State","Email","Phone"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    CustomerDetails(){
        super("Customer Details");
        setUndecorated(true);
        setSize(1200,650);
        setLocation(300,150);
        
        try{
            Conn c1  = new Conn();
            String s1 = "select * from customer";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("nam");
                y[i][j++]=rs.getString("meter_no");
                y[i][j++]=rs.getString("address");
                y[i][j++]=rs.getString("city");
                y[i][j++]=rs.getString("state");
                y[i][j++]=rs.getString("email");
                y[i][j++]=rs.getString("phone");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            t1.setBackground(new Color(173, 216, 230));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        getContentPane().setLayout(null);
        
        
        b1 = new JButton("Print");
        b1.setBounds(new Rectangle(0, 629, 600, 21));
        b1.setBorder(new LineBorder(new Color(0, 0, 0,80), 4, true));
        getContentPane().add(b1);
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 0, 1200, 629);
        sp.setBorder(new LineBorder(new Color(255, 255, 255,70), 4, true));
        getContentPane().add(sp);
        
        b2 = new JButton("back");
        b2.setBorder(new LineBorder(new Color(0, 0, 0,80), 4, true));
        b2.setBounds(new Rectangle(600, 629, 600, 21));
        b2.setBounds(600, 629, 600, 21);
        getContentPane().add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource() == b1){
        try{
            t1.print();
        }catch(Exception e){}
    }else if(ae.getSource() == b2){
        this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new CustomerDetails().setVisible(true);
    }
}

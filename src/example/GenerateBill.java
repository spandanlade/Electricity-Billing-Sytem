package example;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.LineBorder;

public class GenerateBill extends JFrame implements ActionListener{
    JLabel l1, l2;
    JTextArea t1;
    JButton b1,PrintButton,BackButton;
    Choice c2;
    JPanel p1;
    String meter;
    String year1;
    
    private JTextField year;
    private JTextField meter_number;
    GenerateBill(){
    	setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\deltaforce\\Documents\\bill (1).png"));
    	setUndecorated(true);
        setBounds(400,100,500,700);
        
        p1 = new JPanel();
        p1.setBounds(0, 0, 500, 37);
        p1.setBorder(new LineBorder(new Color(255, 255, 255,70), 4, true));
        p1.setBackground(new Color(173, 216, 230));
       
        l1 = new JLabel("Generate Bill");
        
        l2 = new JLabel(meter);
        c2 = new Choice();
        
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");

        
        t1 = new JTextArea(50,15);
        t1.setForeground(Color.black);
        t1.setBorder(new LineBorder(new Color(255, 255, 255,70), 4, true));
        t1.setBackground(new Color(250, 128, 114));
        t1.setText("\n\n\t------- Click on the -------\n\t Generate Bill Button to get\n\tthe bill of the Selected Month\n\n");
        JScrollPane jsp = new JScrollPane(t1);
        jsp.setBounds(0, 37, 500, 642);
        t1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
        
        b1 = new JButton("Generate Bill");
        b1.setBounds(0, 679, 150, 21);
        b1.setBorder(new LineBorder(new Color(255, 255, 255,70), 4, true));
        getContentPane().setLayout(null);
        
        p1.add(l1);
        p1.add(l2);
        p1.add(c2);
        getContentPane().add(p1);
        
        year = new JTextField();
        year.setToolTipText("year");
        p1.add(year);
        year.setColumns(10);
         year1=year.getText();
         
         meter_number = new JTextField();
         meter_number.setToolTipText("Meter Number");
         p1.add(meter_number);
         meter_number.setColumns(10);
        
        getContentPane().add(jsp);
        getContentPane().add(b1);
        
        PrintButton = new JButton("Print");
        PrintButton.setBounds(150, 679, 200, 21);
        PrintButton.setBorder(new LineBorder(new Color(255, 255, 255,70), 4, true));
        getContentPane().add(PrintButton);
        
        BackButton = new JButton("Back");
        BackButton.setBounds(350, 679, 150, 21);
        BackButton.setBorder(new LineBorder(new Color(255, 255, 255,70), 4, true));
        getContentPane().add(BackButton);
        
        b1.addActionListener(this);
        PrintButton.addActionListener(this);
        BackButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1) {
    	try{
            Conn c = new Conn();
   
            String month = c2.getSelectedItem();
            year1=year.getText();
            meter=meter_number.getText();
            t1.setText("\tReliance Power Limited\nELECTRICITY BILL FOR THE MONTH OF "+month+" "+year1+"\n\n\n");
            
            String q="select *from customer where meter_no='"+meter+"'";
            ResultSet rs = c.s.executeQuery(q);
            
            if(rs.next()){
                t1.append("\n    Customer Name: "+rs.getString("nam"));
                t1.append("\n    Meter Number:    "+rs.getString("meter_no"));
                t1.append("\n    Address:               "+rs.getString("address"));
                t1.append("\n    State:                    "+rs.getString("state"));
                t1.append("\n    City:                       "+rs.getString("city"));
                t1.append("\n    Email:                   "+rs.getString("email"));
                t1.append("\n    Phone Number:  "+rs.getString("phone"));
                t1.append("\n-------------------------------------------------------------");
                t1.append("\n");
            }
            
            rs = c.s.executeQuery("select * from meter_info");
            
            if(rs.next()){
                t1.append("\n    Meter Location: "+rs.getString("meter_location"));
                t1.append("\n    Meter Type:     "+rs.getString("meter_type"));
                t1.append("\n    Phase Code:     "+rs.getString("phase_code"));
                t1.append("\n    Bill Type:      "+rs.getString("bill_type"));
                t1.append("\n    Days:           "+rs.getString("days"));
                t1.append("\n");
            }
            rs = c.s.executeQuery("select *from bill_data where meter_no= '"+meter+"' AND months='"+month+"' AND years='"+year1+"'");
            if(rs.next()){
                t1.append("---------------------------------------------------------------");
                t1.append("\n\n");
                t1.append("\n    Fixed Charges(FC):                        Rs "+rs.getString("fixed_charges"));
                t1.append("\n    Energy Charges(EC):                     Rs "+rs.getString("energy_charges"));
                t1.append("\n    Wheeling Charges @2 Rs/U:       Rs "+rs.getString("wheeling_charges"));
                t1.append("\n    Electricity Duty(ED) @ 16%:       Rs "+rs.getString("electricity_duty"));
                t1.append("\n    Fuel Adjustment charges(FAC):  Rs "+rs.getString("FAC"));
                t1.append("\n    Tax on Sale(TOS):                        Rs "+rs.getString("TOC"));
                t1.append("\n");
                
            }
            
            rs = c.s.executeQuery("select *from bill where meter_no="+meter+" AND months = '"+month+"' AND years='"+year1+"'");
            
            if(rs.next()){
                t1.append("\n    Current Month :\t"+rs.getString("months"));
                t1.append("\n    Units Consumed:\t"+rs.getString("units"));
                t1.append("\n    Total Charges :\t"+rs.getString("total_bill"));
                t1.append("\n---------------------------------------------------------------");
                t1.append("\n    TOTAL PAYABLE :\t"+rs.getString("total_bill"));
            }
            
            
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()==PrintButton) {
        	try {
        		t1.print();
        	}
        	catch(Exception e) {}
        }else if(ae.getSource()==BackButton) {
        	this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new GenerateBill().setVisible(true);
    }
}


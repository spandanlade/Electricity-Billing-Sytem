package example;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.LineBorder;

public class CalculateBill extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    JTextField t1;
    Choice c1,c2;
    JButton b1,b2;
    JPanel p;
    private JTextField years;
    CalculateBill(){
    	setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\deltaforce\\Documents\\invoice.png"));
    	setUndecorated(true);
        
        p = new JPanel();
       
        p.setBounds(181, 0, 569, 500);
        p.setBorder(new LineBorder(new Color(255, 255, 255,70), 4, true));
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        
        l1 = new JLabel("Calculate Electricity Bill");
        l1.setBounds(30, 10, 400, 30);
        
        l2 = new JLabel("Meter No");
        l2.setBounds(60, 70, 100, 30);
        
        JLabel l6 = new JLabel("Name");
        l6.setBounds(60, 120, 100, 30);
        
        JLabel l7 = new JLabel("Address");
        l7.setBounds(60, 170, 100, 30);
        
        l3 = new JLabel("Units Cosumed");
        l3.setBounds(60, 220, 100, 30);
        
        l5 = new JLabel("Month");
        l5.setBounds(60, 270, 100, 30);
        
        c1 = new Choice();
        c1.setBounds(200, 75, 180, 20);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("meter_no"));
            }
        }catch(Exception e){}
        
        JLabel l11 = new JLabel();
        l11.setBounds(200, 125, 180, 20);
        p.add(l11);
        
        JLabel l12 = new JLabel();
        l12.setBounds(200, 175, 180, 20);
        p.add(l12);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+c1.getSelectedItem()+"'");
            while(rs.next()){
                l11.setText(rs.getString("nam"));
                l12.setText(rs.getString("address"));
            }
        }catch(Exception e){}
        
        c1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+c1.getSelectedItem()+"'");
                    while(rs.next()){
                        l11.setText(rs.getString("nam"));
                        l12.setText(rs.getString("address"));
                    }
                }catch(Exception e){}
            }
        });
        
        t1 = new JTextField();
        t1.setBounds(200, 225, 180, 20);
        
        
        c2 = new Choice();
        c2.setBounds(200, 275, 180, 20);
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
        
        
        
        b1 = new JButton("Submit");
        b1.setBounds(100, 370, 100, 25);
        b2 = new JButton("Cancel");
        b2.setBounds(230, 370, 100, 25);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(180, 270,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l4 = new JLabel(i3);
        l4.setBounds(0, 0, 181, 500);
        l4.setBorder(new LineBorder(new Color(0, 0, 0,70), 4, true));
        getContentPane().setLayout(null);
        
        
        
        l1.setFont(new Font("Senserif",Font.PLAIN,26));
        //Move the label to center
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        
        p.add(l1);
        p.add(l2);
        p.add(l6);
        p.add(l7);
        p.add(c1);
        p.add(l5);
        p.add(c2);
        p.add(l3);
        p.add(t1);
        p.add(b1);
        p.add(b2);
        
        
        getContentPane().add(p);
        
        JLabel year = new JLabel("Year");
        year.setBounds(60, 315, 100, 30);
        p.add(year);
        
        years = new JTextField();
        years.setBounds(200, 320, 180, 18);
        p.add(years);
        years.setColumns(10);
        getContentPane().add(l4);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);        
        setSize(750,500);
        setLocation(500,220);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String meter_no = c1.getSelectedItem();
            String units = t1.getText();
            String month = c2.getSelectedItem();
            String year1 = years.getText();
            

            int units_consumed = Integer.parseInt(units);

            float total_bill = 0;
            float fixed_charges = 0,energy_charges = 0,wheeling_charges = 0,electricity_duty = 0,FAC = 0,TOS = 0;
            try {
            	Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from calculate");
                while(rs.next()){
                    fixed_charges = Integer.parseInt(rs.getString("fixed_charges")); 
                    energy_charges =(Integer.parseInt(rs.getString("energy_charges")))*units_consumed;  //rent per unit
                    wheeling_charges =(Float.parseFloat(rs.getString("wheeling_charges")))*units_consumed;
                    electricity_duty =((fixed_charges+energy_charges+wheeling_charges)/100)*Integer.parseInt(rs.getString("electricity_duty"));
                    FAC = Integer.parseInt(rs.getString("FAC")); //Fuel adjustment charges
                    TOS = Integer.parseInt(rs.getString("TOC")); //tax on sale
            }
                total_bill = fixed_charges+energy_charges+wheeling_charges+electricity_duty+FAC+TOS;
                }catch(Exception e){}
            

            String q = "insert into bill values('"+meter_no+"','"+month+"','"+year1+"','"+units+"','"+total_bill+"', 'Not Paid')";
            
            String q1="insert into bill_data values('"+fixed_charges+"','"+energy_charges+"','"+wheeling_charges+"','"+electricity_duty+"','"+FAC+"','"+TOS+"','"+meter_no+"','"+month+"','"+year1+"');";
            
            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(q);
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully");
                this.setVisible(false);
            }catch(Exception aee){
                aee.printStackTrace();
                
                
                
                
            }
            

        }else if(ae.getSource()== b2){
            this.setVisible(false);
        }        
    }
    
       
    public static void main(String[] args){
        new CalculateBill().setVisible(true);
    }
}

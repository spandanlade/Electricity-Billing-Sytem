package example;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import javax.swing.border.BevelBorder;
import java.awt.Dialog.ModalExclusionType;

public class Project extends JFrame implements ActionListener {
    String meter;
    private JPanel contentPane;
    JButton btnNewButton;
    Project(String person){
        super("Electricity Billing System");
        setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Project.class.getResource("/icon/electricity-bill-payment-1846954-1563971.png")));
        setExtendedState(Frame.MAXIMIZED_BOTH);
        
        setBounds(0,0,1920,1030);
        
        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(208, 8, 1128, 86);
		panel_3.setBackground(new Color(0, 0, 0,60));
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Electricity Billing System");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 28));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(347, 21, 376, 55);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 1538, 100);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		panel_1.setBackground(new Color(255, 204, 153));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		panel.setBackground(new Color(255, 204, 153));
		panel.setBounds(0, 100, 300,720);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel UpdateInfo = new JLabel("");
		UpdateInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				UpdateInfo.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (9).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				UpdateInfo.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (7).png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new UpdateInformation().setVisible(true);
			}
		});
		UpdateInfo.setIcon(new ImageIcon(Project.class.getResource("/icon/button (7).png")));
		UpdateInfo.setBounds(16, 139, 271, 40);
		
		
		JLabel calculate = new JLabel("");
		calculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				calculate.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (4).png"));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				calculate.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (2).png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new CalculateBill().setVisible(true);
			}
		});
		calculate.setIcon(new ImageIcon(Project.class.getResource("/icon/button (2).png")));
		calculate.setBounds(16, 263, 271, 40);
		
		
		JLabel NewCust = new JLabel("");
		NewCust.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				NewCust.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (12).png"));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				NewCust.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (11).png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new NewCustomer().setVisible(true);
			}
		});
		NewCust.setIcon(new ImageIcon(Project.class.getResource("/icon/button (11).png")));
		NewCust.setBounds(16, 44, 269, 40);
		
		
		JLabel CustDetails = new JLabel("");
		CustDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				CustDetails.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (13).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CustDetails.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (14).png"));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new CustomerDetails().setVisible(true);
			}
		});
		CustDetails.setIcon(new ImageIcon(Project.class.getResource("/icon/button (14).png")));
		CustDetails.setBounds(16, 91, 267, 40);
		
    	
    	JLabel ViewInfo = new JLabel("");
    	ViewInfo.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseEntered(MouseEvent e) {
    			ViewInfo.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (10).png"));
    		}
    		@Override
    		public void mouseExited(MouseEvent e) {
    			ViewInfo.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (15).png"));
    		}
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			new ViewInformation().setVisible(true);
    		}
    	});
    	ViewInfo.setIcon(new ImageIcon(Project.class.getResource("/icon/button (15).png")));
    	ViewInfo.setBounds(16, 187, 267, 40);
    	
    	
	      JLabel generate_bill = new JLabel("");
	      generate_bill.setBounds(16, 309, 271, 40);
	      generate_bill.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseEntered(MouseEvent e) {
	      		 generate_bill.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (17).png"));
	      	}
	      	@Override
	      	public void mouseExited(MouseEvent e) {
	      		 generate_bill.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (16).png"));
	      	}
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		new GenerateBill().setVisible(true);
	      	}
	      });
	      generate_bill.setIcon(new ImageIcon(Project.class.getResource("/icon/button (16).png")));
	      
	        JLabel lblNewLabel_3 = new JLabel("--------------Connection--------------");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setBounds(35, 10, 249, 16);
			
		
         
	           panel.add(CustDetails);
	           if(person=="Admin") {
	        	   panel.add(NewCust); 
	           }
	  	       
		       panel.add(calculate);
		       panel.add(lblNewLabel_3);
           	   panel.add(ViewInfo);
               panel.add(UpdateInfo);
		       panel.add(generate_bill);
		       
		       JLabel report = new JLabel("---------------- Report -----------------");
		       report.setForeground(Color.WHITE);
		       report.setFont(new Font("Tahoma", Font.PLAIN, 15));
		       report.setBounds(35, 236, 249, 16);
		       panel.add(report);
		       
		       JLabel lblNewLabel_2 = new JLabel("");
		       lblNewLabel_2.addMouseListener(new MouseAdapter() {
		       	@Override
		       	public void mouseEntered(MouseEvent e) {
		       		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (26).png"));
		       	}
		       	@Override
		       	public void mouseExited(MouseEvent e) {
		       		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\lenov\\eclipse-workspace\\Electricity_Billing\\src\\icon\\button (25).png"));
		       	}
		       	@Override
		       	public void mouseClicked(MouseEvent e) {
		       		new DepositeDetails().setVisible(true);
		       	}
		       });
		       lblNewLabel_2.setIcon(new ImageIcon(Project.class.getResource("/icon/button (25).png")));
		       lblNewLabel_2.setBounds(16, 356, 271, 40);
		       panel.add(lblNewLabel_2);
		       
		       btnNewButton = new JButton("");
		      
		       btnNewButton.setContentAreaFilled(false);
		       btnNewButton.setBorder(null);
		       btnNewButton.setIcon(new ImageIcon(Project.class.getResource("/icon/button (29).png")));
		       btnNewButton.setBounds(16, 403, 267, 40);
		       panel.add(btnNewButton);
		       btnNewButton.addActionListener(this);
		        
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(Project.class.getResource("/icon/projectbg.jpg")));
		lblNewLabel.setBounds(300, 100,1225,711);
		contentPane.add(lblNewLabel);
		
		
        
    }
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()==btnNewButton) {
    		try{
    			this.setVisible(false);
    	}
    		catch(Exception e) {}
    		
    	}
    }
    
    
    
    public static void main(String[] args){
        new Project("").setVisible(true);
    }
}

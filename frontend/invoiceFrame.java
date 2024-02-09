package frontend;

import java.util.HashMap;

import java.util.Map;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Color;


public class invoiceFrame extends JFrame 
{

    private JPanel contentPane;
    private JTextField txtQuantity;

    // Define costs of each medicine
    private Map<String, Double> medicineCosts;

    /**
     * Create the frame.
     */
    public invoiceFrame() 
    {
        // Initialize medicine costs
        medicineCosts = new HashMap<>();
        medicineCosts.put("Remlimid", 200.0);
        medicineCosts.put("Avastin", 300.0);
        medicineCosts.put("Abacavir", 120.0);
        medicineCosts.put("Amantadine", 90.0);

        setTitle("Medicine Bill Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 200);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(202, 210, 197));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox<String> comboBoxMedicine = new JComboBox<>();
        comboBoxMedicine.setBounds(147, 25, 150, 20);
        for (String medicine : medicineCosts.keySet()) 
        {
            comboBoxMedicine.addItem(medicine);
        }
        contentPane.add(comboBoxMedicine);

        JLabel lblMedicine = new JLabel("Medicine:");
        lblMedicine.setForeground(new Color(66, 66, 66));
        lblMedicine.setBounds(30, 28, 70, 14);
        contentPane.add(lblMedicine);

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setForeground(new Color(66, 66, 66));
        lblQuantity.setBounds(30, 63, 70, 14);
        contentPane.add(lblQuantity);

        txtQuantity = new JTextField();
        txtQuantity.setBounds(147, 60, 150, 20);
        contentPane.add(txtQuantity);
        txtQuantity.setColumns(10);

        JLabel lblTotalBill = new JLabel("");
        lblTotalBill.setBounds(30, 129, 300, 14);
        contentPane.add(lblTotalBill);

        JButton calculate = new JButton("Calculate");
        calculate.setForeground(new Color(66, 66, 66));
        calculate.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	String medi = (String) comboBoxMedicine .getSelectedItem();
				int i = Integer.parseInt(txtQuantity.getText());
				
				
				try
				{
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "project@123");
					String query = ("update medicines set quantity =  quantity-"+txtQuantity.getText()+" where name like '"+ medi + "'") ;
					Statement sta =  conn.createStatement();
					int x =  sta.executeUpdate(query);
					if (x==0)
							{
								JOptionPane.showMessageDialog(calculate,"error");
								
							}
					else
					{
						JOptionPane.showMessageDialog(calculate,"data added successfully");
					}
					conn.close();
				}
				catch (Exception exception)
				{
					exception.printStackTrace();
				}
			
				
            	
                String selectedMedicine = comboBoxMedicine.getSelectedItem().toString();
                int quantity = Integer.parseInt(txtQuantity.getText());
                {
                if (medicineCosts.containsKey(selectedMedicine)) 
                {
                    double costPerUnit = medicineCosts.get(selectedMedicine);
                    double totalCost = costPerUnit * quantity;
                    lblTotalBill.setText("Total bill for " + quantity + " " + selectedMedicine + "\tis" + totalCost+"\tRupees");
                } else 
                {
                    lblTotalBill.setText("Invalid medicine selected.");
                }
                }
        
            }

            
        });
        


        calculate.setBounds(147, 94, 89, 23);
        contentPane.add(calculate);
    }

        

        
    




   
        
        
    

      public static void invoiceScreen() 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    invoiceFrame frame = new invoiceFrame();
                    frame.setVisible(true);
                } catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });
    
    }
    
    
}
package frontend;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;

public class newStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField medi_name;
	private JTextField quantity;
	private JTextField cost;

	/**
	 * Launch the application.
	 */
	public static void stockScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newStock frame = new newStock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public newStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(202, 210, 197));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WHAT WOULD YOU LIKE TO ADD?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(87, 19, 357, 16);
		contentPane.add(lblNewLabel);
		
		medi_name = new JTextField();
		medi_name.setBounds(225, 72, 130, 26);
		contentPane.add(medi_name);
		medi_name.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(225, 147, 130, 26);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Medicine Name");
		lblNewLabel_1.setForeground(new Color(66, 66, 66));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(71, 76, 130, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setForeground(new Color(66, 66, 66));
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(104, 151, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		cost = new JTextField();
		cost.setBounds(225, 110, 130, 26);
		contentPane.add(cost);
		cost.setColumns(10);
		
		JButton addData = new JButton("Add Data ");
		addData.setForeground(new Color(66, 66, 66));
		addData.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		addData.addActionListener(new ActionListener() 
			{
			public void actionPerformed(ActionEvent e) 
			{
				String medi = medi_name.getText();
				int i = Integer.parseInt(quantity.getText());
				int Cost = Integer.parseInt(cost.getText());
				
				try
				{
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "project@123");
					String query = "insert into medicines (name,cost,quantity) values('" + medi + "'," + cost.getText()+"," + quantity.getText() + ")" ;
					Statement sta = conn.createStatement();
					int x = sta.executeUpdate(query);
					if (x==0)
							{
								JOptionPane.showMessageDialog(addData,"error");
								
							}
					else
					{
						JOptionPane.showMessageDialog(addData,"data added successfully");
					}
					conn.close();
				}
				catch (Exception exception)
				{
					exception.printStackTrace();
				}
			
				}
			
			
		});
		addData.setBounds(159, 210, 117, 29);
		contentPane.add(addData);
		
		JLabel lblNewLabel_3 = new JLabel("cost");
		lblNewLabel_3.setForeground(new Color(66, 66, 66));
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(104, 115, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		
	}
}

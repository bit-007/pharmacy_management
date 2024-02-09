package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class mainframe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainframe frame = new mainframe();
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
	public mainframe() {
		setTitle("WELCOME TO PHARMACY ALTERRA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(202, 210, 197));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WHAT WOULD YOU LIKE TO DO?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(93, 18, 264, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("1.");
		btnNewButton.setForeground(new Color(66, 66, 66));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				invoiceFrame invoice = new invoiceFrame();
				invoice.invoiceScreen();
			}
		});
		btnNewButton.setBounds(35, 61, 100, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2.");
		btnNewButton_1.setForeground(new Color(66, 66, 66));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				newStock stock = new newStock();
				stock.stockScreen();
			}
		});
		btnNewButton_1.setBounds(35, 102, 100, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("3.");
		btnNewButton_2.setForeground(new Color(66, 66, 66));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				locateMed locate = new locateMed();
				locate.locateScreen();
			}
		});
		btnNewButton_2.setBounds(35, 143, 100, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4.");
		btnNewButton_3.setForeground(new Color(66, 66, 66));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		btnNewButton_3.setBounds(35, 184, 100, 35);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Sell Medicine");
		lblNewLabel_1.setForeground(new Color(66, 66, 66));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(180, 68, 240, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Add New Stock");
		lblNewLabel_2.setForeground(new Color(66, 66, 66));
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(180, 109, 186, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Locate Medicine");
		lblNewLabel_3.setForeground(new Color(66, 66, 66));
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(180, 150, 171, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Check Availability of Medicine ");
		lblNewLabel_4.setForeground(new Color(66, 66, 66));
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(180, 191, 240, 16);
		contentPane.add(lblNewLabel_4);
	}
}

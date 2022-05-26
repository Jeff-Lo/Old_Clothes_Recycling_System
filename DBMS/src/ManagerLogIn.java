import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class ManagerLogIn extends JFrame {
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public ManagerLogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Manager log in");
		setBounds(100, 100, 1000, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblLogin = new JLabel("Manager Log In");
		springLayout.putConstraint(SpringLayout.NORTH, lblLogin, 35, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblLogin, 346, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblLogin, 104, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblLogin, 649, SpringLayout.WEST, getContentPane());
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("新細明體", Font.PLAIN, 45));
		getContentPane().add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Account:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 85, SpringLayout.SOUTH, lblLogin);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 37, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblPassword, 254, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPassword, -323, SpringLayout.SOUTH, getContentPane());
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblPassword);
		
		JTextField textField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -40, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.NORTH, textField, 79, SpringLayout.SOUTH, lblLogin);
		springLayout.putConstraint(SpringLayout.WEST, textField, 387, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, -197, SpringLayout.EAST, getContentPane());
		textField.setColumns(10);
		getContentPane().add(textField);
		
		JPasswordField textField_1 = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 387, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_1, -197, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -40, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, lblPassword, -25, SpringLayout.WEST, textField_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, 39, SpringLayout.NORTH, lblPassword);
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.NORTH, lblPassword);
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		JRadioButton rdbtnImNotA = new JRadioButton("I'm not a robot.");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnImNotA, 410, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, rdbtnImNotA, 409, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, rdbtnImNotA, -323, SpringLayout.EAST, getContentPane());
		rdbtnImNotA.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnImNotA.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(rdbtnImNotA);
		
		JButton btnLogin = new JButton("LogIn");
		springLayout.putConstraint(SpringLayout.SOUTH, rdbtnImNotA, -26, SpringLayout.NORTH, btnLogin);
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogin, -84, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnLogin, 0, SpringLayout.EAST, lblLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home_frame = new Home();
			}
		});
		btnLogin.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(btnLogin);
		
		JButton btnReturn = new JButton("Return");
		springLayout.putConstraint(SpringLayout.NORTH, btnReturn, 0, SpringLayout.NORTH, btnLogin);
		springLayout.putConstraint(SpringLayout.EAST, btnReturn, -152, SpringLayout.WEST, btnLogin);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login_frame = new Login();
				login_frame.setVisible(true);
				dispose();
			}
		});
		btnReturn.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(btnReturn);
		
		JLabel lblManagerPassword = new JLabel("Manager password:");
		springLayout.putConstraint(SpringLayout.NORTH, lblManagerPassword, 33, SpringLayout.SOUTH, lblPassword);
		springLayout.putConstraint(SpringLayout.WEST, lblManagerPassword, -86, SpringLayout.WEST, lblPassword);
		springLayout.putConstraint(SpringLayout.SOUTH, lblManagerPassword, 82, SpringLayout.SOUTH, lblPassword);
		springLayout.putConstraint(SpringLayout.EAST, lblManagerPassword, 0, SpringLayout.EAST, lblNewLabel);
		lblManagerPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblManagerPassword.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblManagerPassword);
		
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 9, SpringLayout.NORTH, lblManagerPassword);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 40, SpringLayout.EAST, lblManagerPassword);
		springLayout.putConstraint(SpringLayout.SOUTH, passwordField, -7, SpringLayout.SOUTH, lblManagerPassword);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -197, SpringLayout.EAST, getContentPane());
		passwordField.setColumns(10);
		getContentPane().add(passwordField);
		

		
		
		setLocationRelativeTo(null);
		setResizable(false);
	}

}

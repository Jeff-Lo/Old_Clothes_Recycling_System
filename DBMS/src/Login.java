import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.sql.SQLException;

public class Login extends JFrame {
	private UserInfo userInfo;

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Log in");
		setBounds(100, 100, 1000, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblLogin = new JLabel("Log In");
		springLayout.putConstraint(SpringLayout.NORTH, lblLogin, 35, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblLogin, 416, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblLogin, 104, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblLogin, 580, SpringLayout.WEST, getContentPane());
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("新細明體", Font.PLAIN, 45));
		getContentPane().add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Account:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 189, SpringLayout.NORTH, getContentPane());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 37, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblPassword, 254, SpringLayout.WEST, getContentPane());
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblPassword);
		
		JTextField textField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -40, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, textField, -197, SpringLayout.EAST, getContentPane());
		textField.setColumns(10);
		getContentPane().add(textField);
		
		JPasswordField textField_1 = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, textField_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -43, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 387, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_1, -197, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPassword, -25, SpringLayout.WEST, textField_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, -327, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 262, SpringLayout.NORTH, getContentPane());
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		JRadioButton rdbtnImNotA = new JRadioButton("I'm not a robot.");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnImNotA, 323, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, rdbtnImNotA, 411, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, rdbtnImNotA, -230, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, rdbtnImNotA, -321, SpringLayout.EAST, getContentPane());
		rdbtnImNotA.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnImNotA.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(rdbtnImNotA);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database database = new Database();
				String[] info = new String[6];
				String password = "";
				for (char word : textField_1.getPassword()) {
					password += word;
				}
				
				if (textField.getText().equals("") || password.length() == 0) {
					JOptionPane.showMessageDialog(null, "Please fill in your account number and password.");
				}

				else if(!rdbtnImNotA.isSelected()){
					JOptionPane.showMessageDialog(null, "Please check that I'm not a robot.");
				}
				
				else {
					//catch data in the database
					try {
						info = database.doSQL(String.format("SELECT * FROM finalproject.users WHERE users_account='%s' AND users_passwords='%s'", 
								textField.getText(), password));
					} catch (SQLException exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage() + "1");
					}
					
					
					try {
						userInfo = new UserInfo(info[1], info[2], info[3], info[4]);
						Home home_frame = new Home();
						home_frame.setVisible(true);
						setVisible(false);
					} catch (ArrayIndexOutOfBoundsException exception) {
						JOptionPane.showMessageDialog(null,
								"Account number/Password is wrong.\nClick sign up if this is your first time using this system.");
					} catch (SQLException exception) {
						JOptionPane.showMessageDialog(null, "SQL Error");
						exception.printStackTrace();
					}
				}
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, lblPassword, -117, SpringLayout.NORTH, btnLogin);
		springLayout.putConstraint(SpringLayout.NORTH, btnLogin, 416, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnLogin, -592, SpringLayout.EAST, getContentPane());
		btnLogin.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(btnLogin);
		
		JButton btnSignup = new JButton("SignUp");
		springLayout.putConstraint(SpringLayout.NORTH, btnSignup, 0, SpringLayout.NORTH, btnLogin);
		springLayout.putConstraint(SpringLayout.WEST, btnSignup, 107, SpringLayout.EAST, btnLogin);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup signup_frame = new Signup();
				signup_frame.setVisible(true);
				setVisible(false);
			}
		});
		btnSignup.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(btnSignup);
		
		JButton btnManagerLogin = new JButton("Manager Log In");
		btnManagerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerLogIn manager_login_frame = new ManagerLogIn();
				manager_login_frame.setVisible(true);
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnManagerLogin, 46, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnManagerLogin, -35, SpringLayout.SOUTH, getContentPane());
		btnManagerLogin.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(btnManagerLogin);
	
		
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
}

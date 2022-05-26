import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.sql.SQLException;

public class Signup extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Database database;
	
	/**
	 * Create the application.
	 */
	public Signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		database = new Database();
		
		setTitle("Sign up");
		setBounds(100, 100, 1000, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		springLayout.putConstraint(SpringLayout.NORTH, lblSignUp, 33, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblSignUp, 423, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblSignUp, -423, SpringLayout.EAST, getContentPane());
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("新細明體", Font.PLAIN, 45));
		getContentPane().add(lblSignUp);
		
		JLabel lblName = new JLabel("Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblName, 121, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblName, 278, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblName, 391, SpringLayout.WEST, getContentPane());
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblName);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, lblSignUp, -17, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, lblName);
		springLayout.putConstraint(SpringLayout.WEST, textField, 37, SpringLayout.EAST, lblName);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, lblName);
		springLayout.putConstraint(SpringLayout.EAST, textField, 347, SpringLayout.EAST, lblName);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPhoneNumber, 189, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblName, -37, SpringLayout.NORTH, lblPhoneNumber);
		springLayout.putConstraint(SpringLayout.WEST, lblPhoneNumber, 165, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPhoneNumber, 5, SpringLayout.EAST, lblName);
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblPhoneNumber);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 37, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 32, SpringLayout.EAST, lblPhoneNumber);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, -258, SpringLayout.EAST, getContentPane());
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		JLabel lblAccount = new JLabel("Account:");
		springLayout.putConstraint(SpringLayout.NORTH, lblAccount, 44, SpringLayout.SOUTH, lblPhoneNumber);
		springLayout.putConstraint(SpringLayout.WEST, lblAccount, 0, SpringLayout.WEST, lblName);
		springLayout.putConstraint(SpringLayout.EAST, lblAccount, 0, SpringLayout.EAST, lblName);
		lblAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccount.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblAccount);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, -37, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, -334, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 0, SpringLayout.NORTH, lblAccount);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 37, SpringLayout.EAST, lblAccount);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, -258, SpringLayout.EAST, getContentPane());
		textField_2.setColumns(10);
		getContentPane().add(textField_2);
		
		JLabel lblAccount_1 = new JLabel("Password:");
		springLayout.putConstraint(SpringLayout.NORTH, lblAccount_1, 42, SpringLayout.SOUTH, lblAccount);
		springLayout.putConstraint(SpringLayout.WEST, lblAccount_1, 278, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblAccount_1, 391, SpringLayout.WEST, getContentPane());
		lblAccount_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccount_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblAccount_1);
		
		JPasswordField textField_3 = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, -2, SpringLayout.NORTH, lblAccount_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 37, SpringLayout.EAST, lblAccount_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_3, 29, SpringLayout.NORTH, lblAccount_1);
		springLayout.putConstraint(SpringLayout.EAST, textField_3, -258, SpringLayout.EAST, getContentPane());
		textField_3.setColumns(10);
		getContentPane().add(textField_3);
		
		JLabel lblAccount_1_1 = new JLabel("Password again:");
		springLayout.putConstraint(SpringLayout.NORTH, lblAccount_1_1, 37, SpringLayout.SOUTH, lblAccount_1);
		springLayout.putConstraint(SpringLayout.EAST, lblAccount_1_1, 0, SpringLayout.EAST, lblPhoneNumber);
		lblAccount_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccount_1_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblAccount_1_1);
		
		JPasswordField textField_4 = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_4, 0, SpringLayout.NORTH, lblAccount_1_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_4, 32, SpringLayout.EAST, lblAccount_1_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_4, 31, SpringLayout.NORTH, lblAccount_1_1);
		springLayout.putConstraint(SpringLayout.EAST, textField_4, -258, SpringLayout.EAST, getContentPane());
		textField_4.setColumns(10);
		getContentPane().add(textField_4);
		
		JRadioButton rdbtnImNotA = new JRadioButton("I'm not a robot.");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnImNotA, 28, SpringLayout.SOUTH, textField_4);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnImNotA, -441, SpringLayout.EAST, getContentPane());
		rdbtnImNotA.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(rdbtnImNotA);
		
		JButton btnReback = new JButton("Return");
		btnReback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getUserInfoFromLogInFrame().setVisible(true);
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnReback, 32, SpringLayout.SOUTH, rdbtnImNotA);
		springLayout.putConstraint(SpringLayout.EAST, btnReback, -574, SpringLayout.EAST, getContentPane());
		btnReback.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(btnReback);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameString = textField.getText();
				String phoneNum = textField_1.getText();
				String account = textField_2.getText();
				
				//Password
				char[] passwordchar = textField_3.getPassword();
				String passwordNum = "";
				for (char password : passwordchar) {
					passwordNum += password;
				}
				
				//Password again
				char[] passwordchar_again = textField_4.getPassword();
				String passwordNum_again = "";
				for (char password : passwordchar_again) {
					passwordNum_again += password;
				}
				
				if (nameString.equals("") || phoneNum.equals("") || account.equals("") || passwordNum.equals("") || passwordNum_again.equals("")) {
					JOptionPane.showMessageDialog(null, "Name/Phone number/Account/Password/Password again  should be filled up.");
				} 
				else if(!rdbtnImNotA.isSelected()){
					JOptionPane.showMessageDialog(null, "Please check that I'm not a robot.");
				}
				else if(!passwordNum.equals(passwordNum_again)) {
					JOptionPane.showMessageDialog(null, "Password and password again is different.");
				}
				else {
					try {
//						if (database.hasUser(String.format("SELECT * FROM finalproject.users WHERE users_account='%s'", account))) {
//							JOptionPane.showMessageDialog(null, "That account has been used!");
//						}
						
						String SQLbase = "SELECT COUNT(users_account) FROM finalproject.users WHERE users_account= '" + account+"'";	
						if(Integer.parseInt(database.doSQL(SQLbase)[0]) > 0) {
							System.out.println(database.doSQL(SQLbase)[0]);
							JOptionPane.showMessageDialog(null, "That account has been used!");
						}
						
						else {/*
							String[] a = database.doSQL("SELLECT MAX(users_id) FROM finalproject.users");
							int id = Integer.parseInt(a[0]) + 1;
							*/
							database.doSQL(String.format("INSERT INTO finalproject.users(users_name,users_account,users_passwords,users_phone_number,users_identity)VALUES ('%s', '%s', '%s', '%s', %d)", 
									nameString, account, passwordNum, phoneNum, 0));
							
							JOptionPane.showMessageDialog(null, "You have signed in! Please log in to use this system.");
							
							getUserInfoFromLogInFrame().setVisible(true);
							dispose();
						}	
					} catch (SQLException exception) {
						System.out.print("Error");
					}
				}
				
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnSignUp, 0, SpringLayout.NORTH, btnReback);
		springLayout.putConstraint(SpringLayout.WEST, btnSignUp, 90, SpringLayout.EAST, btnReback);
		btnSignUp.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(btnSignUp);
		

		
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	private Login getUserInfoFromLogInFrame() {
		for (Frame frame : JFrame.getFrames()) {
			if (frame.getTitle().equals("Log in")) {
				Login LogInFrame = (Login) frame;
				return LogInFrame;
			}
		}
		return null;
	}
	
}

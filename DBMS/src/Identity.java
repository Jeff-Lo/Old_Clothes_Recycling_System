import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Identity extends JFrame {
	private JTextField NameField, AccField, PhoneField, checkField;
	JPasswordField PassField;
	private IdentityInfo iInfo;
	
	/**
	 * Create the application.
	 */
	public Identity() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setFont(new Font("新細明體", Font.PLAIN, 18));
		setBounds(100, 100, 1000, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Special Identity");
		
		JLabel TitleLabel = new JLabel("Special identity application",JLabel.CENTER);
		TitleLabel.setFont(new Font("新細明體", Font.PLAIN, 32));
		TitleLabel.setBounds(300, 10, 340, 105);
		getContentPane().add(TitleLabel);
		
		//Account / Name
		JLabel lblAccount = new JLabel("Account: ");
		String account = getUserInfoFromLogInFrame().getAccount();
		lblAccount.setText("Account: " + account);
		lblAccount.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblAccount.setBounds(25, 10, 346, 27);
		getContentPane().add(lblAccount);		
		
		JLabel lblName = new JLabel("Name: ");
		String name = getUserInfoFromLogInFrame().getName();
		lblName.setText("Name: " + name);
		lblName.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblName.setBounds(25, 40, 313, 27);
		getContentPane().add(lblName);
		
		JLabel IdentityLabel = new JLabel("Your identity");
		IdentityLabel.setFont(new Font("新細明體", Font.PLAIN, 24));
		IdentityLabel.setBounds(185, 124, 184, 34);
		getContentPane().add(IdentityLabel);
		
		JComboBox IdentityComboBox = new JComboBox();
		IdentityComboBox.setFont(new Font("新細明體", Font.PLAIN, 18));
		IdentityComboBox.setModel(new DefaultComboBoxModel(new String[] {"Please choose", "Orphanage", "low and middle-income people"}));
		IdentityComboBox.setBounds(413, 125, 198, 34);
		getContentPane().add(IdentityComboBox);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setFont(new Font("新細明體", Font.PLAIN, 24));
		NameLabel.setBounds(185, 188, 255, 76);
		getContentPane().add(NameLabel);
		
		JLabel AccLabel = new JLabel("Account");
		AccLabel.setFont(new Font("新細明體", Font.PLAIN, 24));
		AccLabel.setBounds(185, 270, 115, 40);
		getContentPane().add(AccLabel);
		
		JLabel PassLabel = new JLabel("Password");
		PassLabel.setFont(new Font("新細明體", Font.PLAIN, 24));
		PassLabel.setBounds(185, 330, 115, 40);
		getContentPane().add(PassLabel);
		
		JLabel PhoneLabel = new JLabel("Phone number");
		PhoneLabel.setFont(new Font("新細明體", Font.PLAIN, 24));
		PhoneLabel.setBounds(185, 390, 184, 40);
		getContentPane().add(PhoneLabel);
		
		JLabel CheckLabel = new JLabel("Check number");
		CheckLabel.setFont(new Font("新細明體", Font.PLAIN, 24));
		CheckLabel.setBounds(185, 450, 184, 40);
		getContentPane().add(CheckLabel);
		
		JButton ReturnButton = new JButton("Return");
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
		});
		ReturnButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		ReturnButton.setBounds(59, 515, 100, 30);
		getContentPane().add(ReturnButton);
		
		JButton SubmitButton = new JButton("Submit");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database database = new Database();
				String name = NameField.getText();
				String account = AccField.getText();
				String password = String.valueOf(PassField.getPassword());
				String phone = PhoneField.getText();
				String checkNum = checkField.getText();
				int identityNum = 0;
				String checker = "U";
				String[] info = new String[6];

				
				String text = IdentityComboBox.getSelectedItem().toString();
				
				if(text == "Orphanage") {
					identityNum = 1;
				} else if(text == "low and middle-income people") {
					identityNum = 2;
				}
				// check if users input the value
				if(text == "Please choose") {
					JOptionPane.showMessageDialog(null, "Please choose orphanage or low and middle-income people");
				} else if(text != "Please choose" && name.equals("") || account.equals("") || password.equals("") || phone.equals("") || checkNum.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill the textField");
					
				} else {
					
					//catch data in the database
					try { 
						info = database.doSQL(String.format("SELECT * FROM finalproject.users WHERE users_account='%s'", account ));
					} catch (SQLException exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage() + "1");
					}
					
					try { 
						iInfo = new IdentityInfo(info[1], info[2], info[3], info[4],checkNum,identityNum);	
						String str = "INSERT INTO finalproject.special_identity(users_name,users_account,users_passwords,users_phone_number,users_check_number,check_identity,checker)"
								+ "VALUES('"+name+"', '"+account+"', '"+password+"', '"+phone+"', '"+checkNum+"', '"+identityNum+"', '"+checker+"')";
						database.doSQL(str);
						JOptionPane.showMessageDialog(null, "do new IdentityInfo successfully");
					} catch (ArrayIndexOutOfBoundsException exception) {
						JOptionPane.showMessageDialog(null, "Account number/Password is wrong.\nCheck if your inputs are correct");
					} catch (SQLException exception) {
						JOptionPane.showMessageDialog(null, "SQL Error");
						exception.printStackTrace();
					}
				}
				
				
				}
			
		});
		SubmitButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		SubmitButton.setBounds(413, 515, 100, 30);
		getContentPane().add(SubmitButton);
		
		NameField = new JTextField();
		NameField.setBounds(413, 213, 133, 30);
		getContentPane().add(NameField);
		NameField.setColumns(10);
		
		AccField = new JTextField();
		AccField.setBounds(413, 273, 133, 30);
		getContentPane().add(AccField);
		AccField.setColumns(10);
		
		PassField = new JPasswordField();
		PassField.setBounds(413, 333, 133, 30);
		getContentPane().add(PassField);
		PassField.setColumns(10);
		PassField.setEchoChar('*');
		
		PhoneField = new JTextField();
		PhoneField.setBounds(413, 393, 133, 30);
		getContentPane().add(PhoneField);
		PhoneField.setColumns(10);
		
		checkField = new JTextField();
		checkField.setBounds(413, 453, 133, 30);
		getContentPane().add(checkField);
		checkField.setColumns(10);
		
		
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private UserInfo getUserInfoFromLogInFrame() {
		for (Frame frame : JFrame.getFrames()) {
			if (frame.getTitle().equals("Log in")) {
				Login LogInFrame = (Login) frame;
				return LogInFrame.getUserInfo();
			}
		}
		return null;
	}
}

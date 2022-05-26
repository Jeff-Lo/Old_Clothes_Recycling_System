import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.sql.SQLException;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Donate extends JFrame {
	private Database database;

	/**
	 * Create the application.
	 */
	public Donate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		database = new Database();

		setTitle("Donate clothes");
		setBounds(100, 100, 1000, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblDonate = new JLabel("Donate Clothes");
		springLayout.putConstraint(SpringLayout.NORTH, lblDonate, 42, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblDonate, 103, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblDonate, -354, SpringLayout.EAST, getContentPane());
		lblDonate.setFont(new Font("新細明體", Font.PLAIN, 45));
		lblDonate.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDonate);
		
		JLabel lblSize = new JLabel("Size:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSize, 243, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblSize, 93, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblSize, -344, SpringLayout.SOUTH, getContentPane());
		lblSize.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSize.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblSize);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 27, SpringLayout.EAST, lblSize);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -370, SpringLayout.EAST, getContentPane());
		comboBox.addItem("please choose");
		comboBox.addItem("XXS");
		comboBox.addItem("XS");
		comboBox.addItem("S");
		comboBox.addItem("M");
		comboBox.addItem("L");
		comboBox.addItem("XL");
		comboBox.addItem("XXL");
		getContentPane().add(comboBox);
		
		JLabel lblColor = new JLabel("Color:");
		springLayout.putConstraint(SpringLayout.NORTH, lblColor, 72, SpringLayout.SOUTH, lblDonate);
		springLayout.putConstraint(SpringLayout.SOUTH, lblColor, -423, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblSize, 0, SpringLayout.EAST, lblColor);
		springLayout.putConstraint(SpringLayout.WEST, lblColor, 342, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblColor, -585, SpringLayout.EAST, getContentPane());
		lblColor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColor.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblColor);
		
		JComboBox combobox_color = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 44, SpringLayout.SOUTH, combobox_color);
		springLayout.putConstraint(SpringLayout.WEST, combobox_color, 27, SpringLayout.EAST, lblColor);
		springLayout.putConstraint(SpringLayout.EAST, combobox_color, -370, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, combobox_color, 164, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, combobox_color, 24, SpringLayout.NORTH, lblColor);
		
		combobox_color.addItem("please choose");
		combobox_color.addItem("black");
		combobox_color.addItem("white");
		combobox_color.addItem("gray");
		combobox_color.addItem("brown");
		combobox_color.addItem("red");
		combobox_color.addItem("orange");
		combobox_color.addItem("yellow");
		combobox_color.addItem("green");
		combobox_color.addItem("blue");
		combobox_color.addItem("indigo");
		combobox_color.addItem("purple");
		getContentPane().add(combobox_color);
		
		JLabel lblClothingCondition = new JLabel("Type:");
		springLayout.putConstraint(SpringLayout.NORTH, lblClothingCondition, 411, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblClothingCondition, 40, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblClothingCondition, -179, SpringLayout.SOUTH, getContentPane());
		lblClothingCondition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClothingCondition.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblClothingCondition);
		
		JLabel lblClothingCondition_1 = new JLabel("Old to new(1~10):");
		springLayout.putConstraint(SpringLayout.NORTH, lblClothingCondition_1, 39, SpringLayout.SOUTH, lblSize);
		springLayout.putConstraint(SpringLayout.SOUTH, lblClothingCondition_1, -251, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblClothingCondition_1, -212, SpringLayout.EAST, comboBox);
		lblClothingCondition_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClothingCondition_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblClothingCondition_1);
		
		JButton btnReturn = new JButton("Return");
		springLayout.putConstraint(SpringLayout.WEST, lblClothingCondition_1, 0, SpringLayout.WEST, btnReturn);
		springLayout.putConstraint(SpringLayout.WEST, btnReturn, 56, SpringLayout.WEST, getContentPane());
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
		});
		btnReturn.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(btnReturn);
		
		JComboBox comboBox_1_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1_1, 411, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_1_1, -176, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblClothingCondition, -31, SpringLayout.WEST, comboBox_1_1);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1_1, 438, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1_1, 0, SpringLayout.EAST, comboBox);
		comboBox_1_1.addItem("please choose");
		comboBox_1_1.addItem("man");
		comboBox_1_1.addItem("woman");
		comboBox_1_1.addItem("children");
		getContentPane().add(comboBox_1_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, -48, SpringLayout.NORTH, comboBox_1_1_1);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1_1_1, 11, SpringLayout.NORTH, lblClothingCondition_1);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1_1_1, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_1_1_1, -259, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1_1_1, 0, SpringLayout.EAST, comboBox);
		comboBox_1_1_1.addItem("please choose");
		comboBox_1_1_1.addItem(1);
		comboBox_1_1_1.addItem(2);
		comboBox_1_1_1.addItem(3);
		comboBox_1_1_1.addItem(4);
		comboBox_1_1_1.addItem(5);
		comboBox_1_1_1.addItem(6);
		comboBox_1_1_1.addItem(7);
		comboBox_1_1_1.addItem(8);
		comboBox_1_1_1.addItem(9);
		comboBox_1_1_1.addItem(10);
		getContentPane().add(comboBox_1_1_1);
		
		JButton btnDonate = new JButton("Donate");
		springLayout.putConstraint(SpringLayout.SOUTH, btnDonate, -26, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnReturn, 0, SpringLayout.NORTH, btnDonate);
		btnDonate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//clothes_id
//				int id_clothes = 0;
//				try {
//					String[] a = database.doSQL("SELLECT MAX(clothes_id) FROM finalproject.clothes");
//					id_clothes = Integer.parseInt(a[0]) + 1;
//				} catch (SQLException exception) {
//					System.out.print("Error");
//				}
				
				//clothes_color
				String strColor = "";
				if(!combobox_color.getSelectedItem().equals("please choose")) {
					strColor = (String) combobox_color.getSelectedItem();
				}
				else {
					JOptionPane.showMessageDialog(null, "Please choose color.");
				}
				
				
				//clothes_size
				String strSize = "";
				if(!comboBox.getSelectedItem().equals("please choose")) {
					strSize = (String) comboBox.getSelectedItem();
				}
				else {
					JOptionPane.showMessageDialog(null, "Please choose size.");
				}
				
				//clothes_situation
				String strSituation = "";
				if(!comboBox_1_1_1.getSelectedItem().equals("please choose")) {
				     strSituation = ""+comboBox_1_1_1.getSelectedItem()+"";
				    }
				else {
					JOptionPane.showMessageDialog(null, "Please choose situation of the clothes.");
				}
				
				//clothes_type
				String strType = "";
				if(!comboBox_1_1.getSelectedItem().equals("please choose")) {
					strType = (String) comboBox_1_1.getSelectedItem();
				}
				else {
					JOptionPane.showMessageDialog(null, "Please choose situation of the clothes.");
				}
				
				//clothes_price set "0"

				//clothes_from_users_id
				int id_users = getUserInfoFromLogInFrame().getID();
				String str_id_users = "" + id_users;
				
				//clothes_donate_date
//				SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//				Date date = new Date();
//				String strDate = sdFormat.format(date);
				
				//clothes_check set "U"
				
				//images set null				
				
				try {
					database.doSQL(String.format("INSERT INTO finalproject.clothes(clothes_color, clothes_size, clothes_situation, clothes_type, clothes_price, clothes_from_users_id, clothes_check, images,clothes_sold) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s','%s')", 
							strColor, strSize, strSituation, strType, "0", str_id_users, "U", null,null));
					JOptionPane.showMessageDialog(null, "You successfully donate it.");
				}catch (SQLException exception) {
					System.out.print("Error");
				}

			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnDonate, -140, SpringLayout.EAST, getContentPane());
		btnDonate.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(btnDonate);
		
		JLabel lblAccount = new JLabel("Account: ");
		String account = getUserInfoFromLogInFrame().getAccount();
		lblAccount.setText("Account: " + account);
		springLayout.putConstraint(SpringLayout.NORTH, lblAccount, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblAccount, 25, SpringLayout.WEST, getContentPane());
		lblAccount.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblAccount);
		
		JLabel lblName = new JLabel("Name: ");
		String name = getUserInfoFromLogInFrame().getName();
		lblName.setText("Name: " + name);
		springLayout.putConstraint(SpringLayout.WEST, lblName, 25, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblName, -667, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblAccount, 0, SpringLayout.EAST, lblName);
		springLayout.putConstraint(SpringLayout.WEST, lblDonate, 24, SpringLayout.EAST, lblName);
		springLayout.putConstraint(SpringLayout.NORTH, lblName, 50, SpringLayout.NORTH, getContentPane());
		lblName.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblName);
		
		
		
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
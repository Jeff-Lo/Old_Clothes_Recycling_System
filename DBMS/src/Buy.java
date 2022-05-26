import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

import java.sql.SQLException;

//import entities.Clothing;
//import models.ClothingModel;

public class Buy extends JFrame {
	private Database database;
	private String[] info;
	private int info_length;
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Buy() {
		database = new Database();
		info_length = 0;
		info = new String[0];
		int users_id = getUserInfoFromLogInFrame().getID();
		
		
		setTitle("Buy Clothes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel titleLabel =  new JLabel("Buy Clothes");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("新細明體", Font.PLAIN, 45));
		titleLabel.setBounds(350, 40, 273, 54);
		contentPane.add(titleLabel);
		
		//Account / Name
//		JLabel lblAccount = new JLabel("Account: ");
//		String account = getUserInfoFromLogInFrame().getAccount();
//		lblAccount.setText("Account: " + account);
//		lblAccount.setFont(new Font("新細明體", Font.PLAIN, 20));
//		lblAccount.setBounds(25, 10, 346, 27);
//		contentPane.add(lblAccount);		
//		
//		JLabel lblName = new JLabel("Name: ");
//		String name = getUserInfoFromLogInFrame().getName();
//		lblName.setText("Name: " + name);
//		lblName.setFont(new Font("新細明體", Font.PLAIN, 20));
//		lblName.setBounds(25, 40, 313, 27);
//		contentPane.add(lblName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 199, 901, 352);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JComboBox sizeComboBox = new JComboBox();
		sizeComboBox.setFont(new Font("新細明體", Font.PLAIN, 18));
		sizeComboBox.setModel(new DefaultComboBoxModel(new String[] {"please choose", "XXS", "XS", "S", "M", "L", "XL", "XXL"}));
		sizeComboBox.setBounds(203, 145, 127, 27);
		contentPane.add(sizeComboBox);
		
		JComboBox colorComboBox = new JComboBox();
		colorComboBox.setModel(new DefaultComboBoxModel(new String[] {"please choose", "black", "white", "gray", "brown", "red", "orange", "yellow", "green", "blue", "indigo", "purple"}));
		colorComboBox.setFont(new Font("新細明體", Font.PLAIN, 18));
		colorComboBox.setBounds(49, 145, 127, 27);
		contentPane.add(colorComboBox);
		
		JComboBox conComboBox = new JComboBox();
		conComboBox.setFont(new Font("新細明體", Font.PLAIN, 18));
		conComboBox.setModel(new DefaultComboBoxModel(new String[] {"please choose", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		conComboBox.setBounds(523, 145, 127, 27);
		contentPane.add(conComboBox);
		
		JComboBox typeComboBox = new JComboBox();
		typeComboBox.setFont(new Font("新細明體", Font.PLAIN, 18));
		typeComboBox.setModel(new DefaultComboBoxModel(new String[] {"please choose", "man", "woman", "children"}));
		typeComboBox.setBounds(363, 145, 127, 27);
		contentPane.add(typeComboBox);
		
		JComboBox priceComboBox = new JComboBox();
		priceComboBox.setFont(new Font("新細明體", Font.PLAIN, 18));
		priceComboBox.setModel(new DefaultComboBoxModel(new String[] {"please choose", "0~50", "50~100", "100~150", "150~200"}));
		priceComboBox.setBounds(680, 145, 127, 27);
		contentPane.add(priceComboBox);
		
		JLabel colorLabel =  new JLabel("Color");
		colorLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		colorLabel.setBounds(88, 106, 127, 27);
		contentPane.add(colorLabel);
		
		JLabel sizeLabel =  new JLabel("Size");
		sizeLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		sizeLabel.setBounds(244, 106, 127, 27);
		contentPane.add(sizeLabel);
		
		JLabel situationLabel =  new JLabel("Old to new(1~10)");
		situationLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		situationLabel.setBounds(519, 106, 151, 27);
		contentPane.add(situationLabel);
		
		JLabel typeLabel =  new JLabel("Type");
		typeLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		typeLabel.setBounds(399, 106, 127, 27);
		contentPane.add(typeLabel);
		
		JLabel priceLabel =  new JLabel("Price");
		priceLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		priceLabel.setBounds(717, 106, 127, 27);
		contentPane.add(priceLabel);
	
		textField = new JTextField();
		textField.setBounds(353, 575, 94, 22);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Buy");
		btnNewButton.setBounds(457, 571, 101, 28);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//抓使用者輸入的ID
				String clothes_id = textField.getText();
				
				if(clothes_id.equals(null)) {
					JOptionPane.showMessageDialog(null, "Please input ID first!");
				}
				
				else if(info.length==0) {
					JOptionPane.showMessageDialog(null, "Please search first!");
				}
				try {
					String check = "SELECT finalproject.clothes.clothes_sold FROM finalproject.clothes WHERE clothes_sold = 'N' AND clothes_id = '"+clothes_id+"'";
					
					String buyRecord = "INSERT INTO finalproject.buy(buyer_id, buy_clothes_id,buy_way)"
					  		 + "VALUES('"+users_id+"', '"+clothes_id+"', 'Buy')";
			
					String changeTable = "UPDATE finalproject.clothes SET clothes_sold = 'Y' WHERE clothes_id = '"+clothes_id+"'";
					database.doSQL(check);
					database.doSQL(buyRecord);
					database.doSQL(changeTable);
					JOptionPane.showMessageDialog(null, "You buy the clothes.");
					
					int info_new_length = info.length -7;
					for(int i=0;i<info.length;i+=7) {
						if(info[i].equals(clothes_id)) {
							String[] a = new String[info_new_length];
							for(int j=0;j<i;j++) {
								a[j] = info[j];
							}
							for(int k=i;k<info_new_length;k++) {
								a[k] = info[k+7];
							}
							info = new String[info_new_length];
							info = a;
							break;
						}						
					}
					loadData();
				}
				catch(SQLException exception) {
					JOptionPane.showMessageDialog(null, "This clothes has been bought :(");
					exception.printStackTrace();
				}
			}
		});
		/*
		JButton btnNewButton_1 = new JButton("Shopping cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getUserInfoFromLogInFrame2()==null) {
					Buycart buyCart = new Buycart();
					buyCart.setVisible(true);
					setVisible(false);
				}
				else {
					getUserInfoFromLogInFrame2().setVisible(true);
					setVisible(false);
				}
			}
		});
		btnNewButton_1.setBounds(696, 571, 130, 28);
		contentPane.add(btnNewButton_1);
		*/
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				//抓使用者的input
				String color = (String) colorComboBox.getSelectedItem();
				String size = (String) sizeComboBox.getSelectedItem();
				String situation = (String) conComboBox.getSelectedItem();
				String type = (String) typeComboBox.getSelectedItem();
				String price = (String) priceComboBox.getSelectedItem();
				
				//變數用來設定WHERE的搜尋條件
				String sqlColor = "";
				String sqlSize = "";
				String sqlSituation = "";
				String sqlType = "";
				String sqlPrice = "";
				
				//如果都沒選條件就不search
				if(color.equals("please choose") && size.equals("please choose") && situation.equals("please choose") && type.equals("please choose") && price.equals("please choose")) {
					JOptionPane.showMessageDialog(null, "Please set condition to search.");
				}
				
				else {
					//設定WHERE的搜尋條件
					if(!color.equals("please choose")) {
						sqlColor = " AND clothes_color=" + "'" + color + "'";
					}
					
					if(!size.equals("please choose")) {
						sqlSize = " AND clothes_size=" + "'" + size + "'";
					}
					
					if(!situation.equals("please choose")) {
						sqlSituation = " AND clothes_situation=" + "'" + situation + "'";
					}
					
					if(!type.equals("please choose")) {
						sqlType = " AND clothes_type=" + "'" + type + "'";
					}
					
					if(!price.equals("please choose")) {
						if(price.equals("0~50")) {
							price = "'50')";
						}
						
						else if(price.equals("50~100")) {
							price = "'50' OR clothes_price='100')";
						}
						
						else if(price.equals("100~150")) {
							price = "'100' OR clothes_price='150')";
						}
						
						else if(price.equals("150~200")) {
							price = "'150' OR clothes_price='200')";
						}
						
						sqlPrice = " AND (clothes_price=" + price;
					}
					
					//連線資料庫search
					try {
						if(database.doSQL("SELECT COUNT(clothes_id) FROM finalproject.clothes WHERE clothes_check='Y' AND clothes_sold = 'N'" + sqlColor + sqlSize + sqlSituation + sqlType)[0].equals("0")) {
							JOptionPane.showMessageDialog(null, "Don't have clothes with conditions you set.");
							return;
						}
						String[] information = database.doSQL("SELECT clothes_id, clothes_color, clothes_size, clothes_situation, clothes_type, clothes_price, images FROM finalproject.clothes WHERE clothes_check='Y' AND clothes_sold = 'N'" + sqlColor + sqlSize + sqlSituation + sqlType + sqlPrice);
						
						if(information.equals(null)) {
							JOptionPane.showMessageDialog(null, "Don't have clothes with conditions you set.");
						}
						
						else{
							info = new String[information.length];
							info = information;
							loadData();
						}
					}catch (SQLException exception) {
						System.out.print("Error");
					}
				}
			}
		});
		btnNewButton_2.setBounds(847, 144, 100, 28);
		contentPane.add(btnNewButton_2);
		
		JButton returnBtn = new JButton("Return");
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
		});
		returnBtn.setBounds(49, 571, 130, 28);
		contentPane.add(returnBtn);
		
	}
	
	private void loadData() {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Color");
		defaultTableModel.addColumn("Size");
		defaultTableModel.addColumn("Situation");
		defaultTableModel.addColumn("Type");
		defaultTableModel.addColumn("Price");
		defaultTableModel.addColumn("Photo");
		for(int i=0;i<info.length;i+=7) {
			defaultTableModel.addRow(new Object[] {
					//加入東西
					info[i],
					info[i+1],
					info[i+2],
					info[i+3],
					info[i+4],
					info[i+5],
					info[i+6]	
			});
		}
		table.setModel(defaultTableModel);
		table.setRowHeight(50);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(6).setCellRenderer(new ImageRender());
	}
	
	private class ImageRender extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			String photoName = value.toString();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("clothing/" + photoName).getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
					
			return new JLabel(imageIcon);
		}
		
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
	
	private Buycart getUserInfoFromLogInFrame2() {
		for (Frame frame : JFrame.getFrames()) {
			if (frame.getTitle().equals("Shopping Cart")) {
				Buycart buycartFrame = (Buycart) frame;
				return buycartFrame;
			}
		}
		return null;
	}
}

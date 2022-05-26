import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

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

import entities.Clothing;
import models.ClothingModel;

public class Receive extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private int index = 1, searchIndex = 1;
	private String size, color, type, condition;
	private JTextField textField;
	private int clothesCount, clothesID;
	private String[] info;
	private List<Object> addArray = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	    } catch(Throwable e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receive frame = new Receive();
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
	public Receive() {
		Database database = new Database();
		setTitle("Receive");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 100, 728, 421);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JLabel sizeLabel = new JLabel("Size");
		sizeLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		sizeLabel.setBounds(90, 20, 84, 23);
		contentPane.add(sizeLabel);
		
		JLabel colorLabel = new JLabel("Color");
		colorLabel.setBounds(250, 20, 84, 23);
		colorLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(colorLabel);
		
		JLabel typeLabel = new JLabel("Type");
		typeLabel.setBounds(410, 20, 84, 23);		
		typeLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(typeLabel);
		
		JLabel conLabel = new JLabel("Situation");
		conLabel.setBounds(550, 20, 100, 23);
		conLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(conLabel);
		
		JComboBox sizeComboBox = new JComboBox();
		sizeComboBox.setFont(new Font("新細明體", Font.PLAIN, 18));
		sizeComboBox.setModel(new DefaultComboBoxModel(new String[] {"please choose", "XXS", "XS", "S", "M", "L", "XL", "XXL"}));
		sizeComboBox.setBounds(50, 49, 127, 27);
		contentPane.add(sizeComboBox);
		
		JComboBox colorComboBox = new JComboBox();
		colorComboBox.setModel(new DefaultComboBoxModel(new String[] {"please choose", "black", "blue", "brown", "gray", "green", "indigo", "orange", "purple", "red", "white", "yellow"}));
		colorComboBox.setFont(new Font("新細明體", Font.PLAIN, 18));
		colorComboBox.setBounds(210, 49, 127, 27);
		contentPane.add(colorComboBox);
		
		JComboBox typeComboBox = new JComboBox();
		typeComboBox.setFont(new Font("新細明體", Font.PLAIN, 18));
		typeComboBox.setModel(new DefaultComboBoxModel(new String[] {"please choose", "man", "woman", "children"}));
		typeComboBox.setBounds(370, 49, 127, 27);
		contentPane.add(typeComboBox);
		
		JComboBox conComboBox = new JComboBox();
		conComboBox.setFont(new Font("新細明體", Font.PLAIN, 18));
		conComboBox.setModel(new DefaultComboBoxModel(new String[] {"please choose", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		conComboBox.setBounds(530, 49, 127, 27);
		contentPane.add(conComboBox);
		
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
		defaultTableModel.addColumn("Photo");
		
				
		//JButton btnNewButton = new JButton("Add");
		//btnNewButton.setBounds(380, 535, 101, 28);
		//contentPane.add(btnNewButton);
		Object value[][] = new Object[30][6];

		
		textField = new JTextField();
		textField.setBounds(280, 538, 94, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Receive");
		btnNewButton.setBounds(380, 535, 101, 28);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String clothes_id = textField.getText();
					int users_id = getUserInfoFromLogInFrame().getID();
					String[] check = new String[6];
					
					try {
						String checkIdentity = "SELECT COUNT(users_identity) FROM finalproject.users WHERE users_id = '" + users_id + "' AND users_identity != '0'";
						if(database.doSQL(checkIdentity)[0].equals("0")) {
							JOptionPane.showMessageDialog(null, "Wrong Identity");
							return;
						}
						//抓使用者輸入的ID
						if(clothes_id.equals(null)) {
							JOptionPane.showMessageDialog(null, "Please input ID first!");
						}
						
						else if(info.length==0) {
							JOptionPane.showMessageDialog(null, "Please search first!");
						}
						try {
							String buyRecord = "INSERT INTO finalproject.buy(buyer_id, buy_clothes_id, buy_way)"
							  		 + "VALUES('"+users_id+"', '"+clothes_id+"', 'Receive')";
					
							String changeTable = "UPDATE finalproject.clothes SET clothes_sold = 'Y' WHERE clothes_id = '"+clothes_id+"'";
							database.doSQL(buyRecord);
							database.doSQL(changeTable);
							JOptionPane.showMessageDialog(null, "You receive the clothes.");

						}
						catch(SQLException exception) {
							JOptionPane.showMessageDialog(null, "SQL Error");
							exception.printStackTrace();
						}
					}
					catch(ArrayIndexOutOfBoundsException exc){
						JOptionPane.showMessageDialog(null, "Wrong Identity");
						exc.printStackTrace();
					}
					catch(SQLException exception) {
						JOptionPane.showMessageDialog(null, "SQL Error");
						exception.printStackTrace();
					}
			}
		});
		
		/*
		JButton btnNewButton_1 = new JButton("Shopping cart");
		btnNewButton_1.setBounds(524, 535, 130, 28);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(getUserInfoFromLogInFrame2()==null) {
					ShoppingCart shoppingCart = new ShoppingCart();
					shoppingCart.setVisible(true);
					setVisible(false);
				}
				else {
					getUserInfoFromLogInFrame2().setVisible(true);
					setVisible(true);
				}
				
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setVisible(true);
			}
		});
		*/
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setBounds(680, 48, 100, 28);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				size = (String) sizeComboBox.getSelectedItem();
				color = (String) colorComboBox.getSelectedItem();
				type = (String) typeComboBox.getSelectedItem();
				condition = (String) conComboBox.getSelectedItem();
				String[] image = new String[6];
				/*
				//catch count of image
				String SQLbase1 = "SELECT COUNT(clothes_id) FROM finalproject.clothes "
						+ "WHERE clothes_color = '"+ color +"'"
						+ "AND clothes_size = '"+ size +"'"
						+ "AND clothes_situation = '"+ condition +"'"
						+ "AND clothes_type = '"+ type +"'";
				
				try {
					//catch image from DB
					clothesCount = Integer.parseInt(database.doSQL(SQLbase1)[0]);//找出符合的資料的數量
					
					image = (database.doSQL(String.format("SELECT images FROM finalproject.clothes"
							+ " WHERE clothes_color='%s' AND clothes_size='%s' AND clothes_situation='%s' AND clothes_type='%s'"
							, color, size, condition, type)));
					
				} catch (SQLException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage() + "1");
				}	
				JOptionPane.showMessageDialog(null, size);
				loadSelectData(clothesCount,size,color,type,condition,image);
				*/
				
				String color = (String) colorComboBox.getSelectedItem();
				String size = (String) sizeComboBox.getSelectedItem();
				String situation = (String) conComboBox.getSelectedItem();
				String type = (String) typeComboBox.getSelectedItem();
				
				//變數用來設定WHERE的搜尋條件
				String sqlColor = "";
				String sqlSize = "";
				String sqlSituation = "";
				String sqlType = "";
				
				//如果都沒選條件就不search
				if(color.equals("please choose") && size.equals("please choose") && situation.equals("please choose") && type.equals("please choose")) {
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
					
					//連線資料庫search
					try {
						if(database.doSQL("SELECT COUNT(clothes_id) FROM finalproject.clothes WHERE clothes_check='Y' AND clothes_sold = 'N'" + sqlColor + sqlSize + sqlSituation + sqlType)[0].equals("0")) {
							JOptionPane.showMessageDialog(null, "Don't have clothes with conditions you set.");
							return;
						}
						String[] information = database.doSQL("SELECT clothes_id, clothes_color, clothes_size, clothes_situation, clothes_type, images FROM finalproject.clothes WHERE clothes_check='Y' AND clothes_sold = 'N'" + sqlColor + sqlSize + sqlSituation + sqlType);
						info = information;
						if(info.equals(null)) {
							JOptionPane.showMessageDialog(null, "Don't have clothes with conditions you set.");
						}
						else {
							for(int i=defaultTableModel.getRowCount(); i>0; i--) {
								defaultTableModel.removeRow(i-1);
							}
							for(int i=0;i<info.length;i+=6) {
								defaultTableModel.addRow(new Object[] {
										//加入東西
										info[i],
										info[i+1],
										info[i+2],
										info[i+3],
										info[i+4],
										info[i+5]
								});
								searchIndex++;
							}
							
							int column = defaultTableModel.getColumnCount();
							int row = defaultTableModel.getRowCount();
							// row | column ---
							for(int i=0; i<row; i++) {
								for(int j=0; j<column; j++) {
									value[i][j] = defaultTableModel.getValueAt(i, j);
								}
							}
							
							table.setModel(defaultTableModel);
							table.setRowHeight(50);
							table.getTableHeader().setReorderingAllowed(false);
							table.getColumnModel().getColumn(5).setCellRenderer(new ImageRender());
						}
					}catch (SQLException exception) {
						System.out.print("Error");
					}
				}
			}
		});
		
		JButton btnNewButton_3 = new JButton("Return");
		btnNewButton_3.setBounds(50, 535, 130, 28);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Home home = new Home();
				home.setVisible(true);
				dispose();
				
			}
		});

		//loadData();

	}
	
	private void loadSelectData(String[] info)  {
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
		defaultTableModel.addColumn("Photo");
		int searchIndex = 1;
		int len = info.length/6;
		for(int i=0;i<len;i+=6) {
			defaultTableModel.addRow(new Object[] {
					//加入東西
					searchIndex,
					info[i+1],
					info[i+2],
					info[i+3],
					info[i+4],
					info[i+5]
			});
			searchIndex++;
		}
		
		int column = defaultTableModel.getColumnCount();
		int row = defaultTableModel.getRowCount();
		Object value[][] = new Object[row][column];
		// row | column ---
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				value[i][j] = defaultTableModel.getValueAt(i, j);
			}
		}
		ShoppingCart shoppingCart = new ShoppingCart();
		
		textField = new JTextField();
		textField.setBounds(280, 538, 94, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(380, 535, 101, 28);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(getUserInfoFromLogInFrame2()==null) {
					//ShoppingCart shoppingCart = new ShoppingCart();
					//shoppingCart.setVisible(false);
				
					int id = Integer.parseInt(textField.getText())-1;
		
					addArray.add(value[id][1]);
					addArray.add(value[id][2]);
					addArray.add(value[id][3]);
					addArray.add(value[id][4]);
					addArray.add(value[id][5]);
					
					shoppingCart.setVisible(false);
					if(id == 5) {
						shoppingCart.setVisible(true);
					}
					shoppingCart.addData(addArray);
					//JOptionPane.showMessageDialog(null, addArray.get(2));
				//}
			}
		});
		
		table.setModel(defaultTableModel);
		table.setRowHeight(50);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(5).setCellRenderer(new ImageRender());
	}
	
	private void loadData() {
		
		ClothingModel clothingModel = new ClothingModel();
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("size");
		defaultTableModel.addColumn("color");
		defaultTableModel.addColumn("type");
		defaultTableModel.addColumn("condition");
		defaultTableModel.addColumn("photo");
		
		for(Clothing product : clothingModel.findAll()) {
			defaultTableModel.addRow(new Object[] {
					index,
					product.getSize(),
					product.getColor(),
					product.getType(),
					product.getCondition(),
					product.getPhoto()
			});
			index++;
		}
		
		
		table.setModel(defaultTableModel);
		table.setRowHeight(50);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(5).setCellRenderer(new ImageRender());
		int column = defaultTableModel.getColumnCount();
		int row = defaultTableModel.getRowCount();
		Object value[][] = new Object[row][column];
		// row | column ---
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				value[i][j] = defaultTableModel.getValueAt(i, j);
			}
		}
		
		textField = new JTextField();
		textField.setBounds(280, 538, 94, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		int i = defaultTableModel.getRowCount();
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
	
	private Receive getUserInfoFromLogInFrame2() {
		for (Frame frame : JFrame.getFrames()) {
			if (frame.getTitle().equals("Shopping Cart")) {
				Receive shopcartFrame = (Receive) frame;
				return shopcartFrame;
			}
		}
		return null;
	}
	
}

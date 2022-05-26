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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

//import Buy.ImageRender;

//import entities.Clothing;
//import models.ClothingModel;

public class Buycart extends JFrame {
	private String[] info;
	private int info_length;
	private DefaultTableModel defaultTableModel;
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Buycart() {
		info_length = 0;
		info = new String[0];
		defaultTableModel = new DefaultTableModel() {
		
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
		
		
		setTitle("Shopping Cart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel titleLabel =  new JLabel("Shopping cart");
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
		scrollPane.setBounds(83, 124, 826, 422);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(365, 561, 94, 22);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.setBounds(471, 558, 101, 28);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//移除購物車裡的某列資料
				
				//抓使用者輸入的ID
				String id = textField.getText();
				
				if(id.equals(null)) {
					JOptionPane.showMessageDialog(null, "Please input ID first!");
				}
				
				else if(info.length==0) {
					JOptionPane.showMessageDialog(null, "Not have clothes in the shopping cart!");
				}
				
				else {
					
					//對比使用者輸入的ID和JTable表格裡的ID有沒有相符
					boolean find = false;
					
					for(int i=0;i<info.length;i+=7) {
						if(info[i].equals(id)) {
							
							//移除那筆資料
							removeInfo(id);
							
							find = true;
							break;
						}
					}
					
					if(find==true) {
						loadData();
						JOptionPane.showMessageDialog(null, "You successfully remove it.");
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Not have this ID!");
					}
				}
			}
		});
		
		JButton returnBtn = new JButton("Return");
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getUserInfoFromLogInFrame2().setVisible(true);
				setVisible(false);
			}
		});
		returnBtn.setBounds(38, 558, 130, 28);
		contentPane.add(returnBtn);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//把資料庫裡的資料price歸0
				
				
			}
		});
		submitBtn.setBounds(775, 558, 101, 28);
		contentPane.add(submitBtn);

//		loadData();
	}
	
	//新增
	public void addInfo(String str) {
		info_length += 1;
		
		if(info_length==1) {
			info = new String[info_length];
			info[info_length - 1] = str;
		}
		
		else {
			String[] a = new String[info_length];
			
			for(int x=0;x<info.length-1;x++) {
				a[x] = info[x];
			}
			a[a.length-1] = str;
			info = new String[info_length];
			info = a;
		}
		
	}
	
	//確認新增資料的時候有沒有重複
	public boolean check(String str) {
		if(info_length==0) {
			return true;
		}
		
		else {
			for(int i=0;i<info.length;i+=7) {
				if(info[i]==str) {
					return false;
				}
			}
			return true;
		}
	}
	
	//移除
	public void removeInfo(String str) {
		info_length -= 7;
		
		String[] a = new String[info_length];
		
		int x = 0;	
		for(int i=0;i<info.length;i+=7) {
			if(info[i]==str) {
				x = i; //id的index
			}
			break;
		}
		
		//把id的index之前的info都加進a裡面
		for(int j=0;j<x;j++) {
			a[j] = info[j];
		}
		
		for(int k=x;k<a.length;k++) {
			a[k] = info[k+7];
		}
		
		info = new String[info_length];
		info = a;
	}
	
	public String[] getInfo() {
		return info;
	}
	
	public void loadData() {
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
	
	private Buy getUserInfoFromLogInFrame2() {
		for (Frame frame : JFrame.getFrames()) {
			if (frame.getTitle().equals("Buy Clothes")) {
				Buy buyFrame = (Buy) frame;
				return buyFrame;
			}
		}
		return null;
	}
	
}

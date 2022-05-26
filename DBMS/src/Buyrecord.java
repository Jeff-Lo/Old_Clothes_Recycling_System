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

public class Buyrecord extends JFrame {
	private Database database;
	private String[] info;
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	
	/**
	 * Create the application.
	 */
	public Buyrecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		database = new Database();
		info = new String[0];
		
		setTitle("Buy Record");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel titleLabel =  new JLabel("Buy Record");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("新細明體", Font.PLAIN, 45));
		titleLabel.setBounds(350, 40, 273, 54);
		contentPane.add(titleLabel);
		
		//Account / Name
		JLabel lblAccount = new JLabel("Account: ");
		String account = getUserInfoFromLogInFrame().getAccount();
		lblAccount.setText("Account: " + account);
		lblAccount.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblAccount.setBounds(25, 10, 346, 27);
		contentPane.add(lblAccount);		
		
		JLabel lblName = new JLabel("Name: ");
		String name = getUserInfoFromLogInFrame().getName();
		lblName.setText("Name: " + name);
		lblName.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblName.setBounds(25, 40, 313, 27);
		contentPane.add(lblName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 118, 901, 433);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		String id = "" + getUserInfoFromLogInFrame().getID();
		String check = "SELECT COUNT(finalproject.clothes.clothes_id) "
				+ "FROM finalproject.clothes, finalproject.users, finalproject.buy "
				+ "WHERE finalproject.buy.buyer_id = finalproject.users.users_id AND finalproject.buy.buy_way = 'Buy' AND finalproject.users.users_id='"+id+"' AND finalproject.buy.buy_clothes_id = finalproject.clothes.clothes_id AND finalproject.clothes.clothes_sold = 'Y'";
		String SQL = String.format("SELECT finalproject.clothes.clothes_id, finalproject.clothes.clothes_color, finalproject.clothes.clothes_size, finalproject.clothes.clothes_situation, finalproject.clothes.clothes_type, finalproject.clothes.clothes_price, finalproject.buy.buy_date " + 
				"FROM finalproject.clothes, finalproject.users, finalproject.buy " + 
				"WHERE finalproject.buy.buyer_id = finalproject.users.users_id AND finalproject.buy.buy_way = 'Buy' AND finalproject.users.users_id='%s' AND finalproject.buy.buy_clothes_id = finalproject.clothes.clothes_id AND finalproject.clothes.clothes_sold = 'Y'", id);

		try {
			if(database.doSQL(check)[0].equals("0")){
				JOptionPane.showMessageDialog(null, "You didn't buy any clothes. : (");
				Home home = new Home();
				home.setVisible(false);
				dispose();
			}
			info = database.doSQL(SQL);
		}catch (SQLException exception) {
			System.out.print("Error");
		}

		//Return
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
		
		loadData();
		
	}
	
	private void loadData() {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		defaultTableModel.addColumn("Clothes ID");
		defaultTableModel.addColumn("Color");
		defaultTableModel.addColumn("Size");
		defaultTableModel.addColumn("Situation");
		defaultTableModel.addColumn("Type");
		defaultTableModel.addColumn("Price");
		defaultTableModel.addColumn("Buy date");
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
		//table.getColumnModel().getColumn(6).setCellRenderer(new ImageRender());
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

}

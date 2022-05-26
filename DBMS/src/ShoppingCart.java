import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

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

public class ShoppingCart extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private int index = 1;
	private String size, color, type;
	private int condition;
	private JTextField textField;

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
					ShoppingCart frame = new ShoppingCart();
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
	public ShoppingCart() {
		setTitle("Shopping cart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 30, 400, 200);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setBounds(160, 260, 101, 28);
		contentPane.add(btnNewButton_1);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//loadData();
	}
	
	public void addData(List<Object> addArray) {
		ClothingModel clothingModel = new ClothingModel();
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		int length = addArray.size();
		int times = length/5;
		//JOptionPane.showMessageDialog(null, "¦³¶i¨ìshopcart");
		
		defaultTableModel.addColumn("size");
		defaultTableModel.addColumn("color");
		defaultTableModel.addColumn("type");
		defaultTableModel.addColumn("condition");
		defaultTableModel.addColumn("photo");
		int begin = 0;
		for(int i=0; i<times; i++) {
			defaultTableModel.addRow(new Object[] {addArray.get(begin),addArray.get(begin+1),addArray.get(begin+2),addArray.get(begin+3),addArray.get(begin+4)});
			begin += 5;
		}
		//defaultTableModel.addRow(new Object[] {index,size,color,type,condition,photo});
		
		table.setModel(defaultTableModel);
		table.setRowHeight(50);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(4).setCellRenderer(new ImageRender());
	}
	
	private void loadData() {
		ClothingModel clothingModel = new ClothingModel();
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		defaultTableModel.addColumn("size");
		defaultTableModel.addColumn("color");
		defaultTableModel.addColumn("type");
		defaultTableModel.addColumn("condition");
		defaultTableModel.addColumn("photo");
		for(Clothing product : clothingModel.findAll()) {
			defaultTableModel.addRow(new Object[] {
					product.getSize(),
					product.getColor(),
					product.getType(),
					product.getCondition(),
					product.getPhoto()
			});
		}
		table.setModel(defaultTableModel);
		table.setRowHeight(50);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(4).setCellRenderer(new ImageRender());
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
	
}

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import javax.swing.SwingConstants;

//import demo.Home;

import javax.swing.JButton;

public class Home extends JFrame {
	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Home page");
		setBounds(100, 100, 1000, 650);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblHomePage = new JLabel("Home Page");
		springLayout.putConstraint(SpringLayout.NORTH, lblHomePage, 47, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblHomePage, 368, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblHomePage, 618, SpringLayout.WEST, getContentPane());
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setFont(new Font("新細明體", Font.PLAIN, 45));
		getContentPane().add(lblHomePage);
		
		JLabel lblAction = new JLabel("Today I want to do......");
		springLayout.putConstraint(SpringLayout.NORTH, lblAction, 34, SpringLayout.SOUTH, lblHomePage);
		springLayout.putConstraint(SpringLayout.WEST, lblAction, 157, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAction, 107, SpringLayout.SOUTH, lblHomePage);
		springLayout.putConstraint(SpringLayout.EAST, lblAction, -158, SpringLayout.EAST, getContentPane());
		lblAction.setFont(new Font("新細明體", Font.PLAIN, 30));
		lblAction.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblAction);
		
		JButton btnDonate = new JButton("Donate");
		springLayout.putConstraint(SpringLayout.SOUTH, btnDonate, -166, SpringLayout.SOUTH, getContentPane());
		btnDonate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Donate donate_frame = new Donate();
				donate_frame.setVisible(true);
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnDonate, 6, SpringLayout.SOUTH, lblAction);
		springLayout.putConstraint(SpringLayout.WEST, btnDonate, 124, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnDonate, 293, SpringLayout.WEST, getContentPane());
		btnDonate.setFont(new Font("新細明體", Font.PLAIN, 30));
		getContentPane().add(btnDonate);
		
		JButton btnBuy = new JButton("Buy");
		springLayout.putConstraint(SpringLayout.NORTH, btnBuy, 6, SpringLayout.SOUTH, lblAction);
		springLayout.putConstraint(SpringLayout.WEST, btnBuy, 102, SpringLayout.EAST, btnDonate);
		springLayout.putConstraint(SpringLayout.SOUTH, btnBuy, -166, SpringLayout.SOUTH, getContentPane());
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buy buy_frame = new Buy();
				buy_frame.setVisible(true);
				dispose();
			}
		});
		btnBuy.setFont(new Font("新細明體", Font.PLAIN, 30));
		getContentPane().add(btnBuy);
		
		JButton btnTake = new JButton("Receive");
		springLayout.putConstraint(SpringLayout.EAST, btnBuy, -94, SpringLayout.WEST, btnTake);
		springLayout.putConstraint(SpringLayout.NORTH, btnTake, 6, SpringLayout.SOUTH, lblAction);
		springLayout.putConstraint(SpringLayout.WEST, btnTake, 657, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnTake, 0, SpringLayout.SOUTH, btnDonate);
		springLayout.putConstraint(SpringLayout.EAST, btnTake, -170, SpringLayout.EAST, getContentPane());
		btnTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Receive receive = new Receive();
				receive.setVisible(true);
				dispose();
			}
		});
		btnTake.setFont(new Font("新細明體", Font.PLAIN, 30));
		getContentPane().add(btnTake);
		
		JButton btnNewButton = new JButton("Apply for special identification");
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -64, SpringLayout.EAST, getContentPane());
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Identity Identity_frame = new Identity();
				Identity_frame.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnLogOut = new JButton("Log Out");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnLogOut);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 513, SpringLayout.EAST, btnLogOut);
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogOut, -34, SpringLayout.SOUTH, getContentPane());
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login_frame = new Login();
				login_frame.setVisible(true);
				getUserInfoFromLogInFrame2().dispose();
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnLogOut, 47, SpringLayout.WEST, getContentPane());
		btnLogOut.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(btnLogOut);
		
		JButton btnDonateReccord = new JButton("Donate Record");
		  btnDonateReccord.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
		    Donaterecord donateRecord = new Donaterecord();
		    donateRecord.setVisible(true);
		    dispose();
		   }
		  });
		  springLayout.putConstraint(SpringLayout.NORTH, btnDonateReccord, 22, SpringLayout.SOUTH, btnDonate);
		  springLayout.putConstraint(SpringLayout.WEST, btnDonateReccord, 0, SpringLayout.WEST, btnDonate);
		  springLayout.putConstraint(SpringLayout.EAST, btnDonateReccord, 0, SpringLayout.EAST, btnDonate);
		  btnDonateReccord.setFont(new Font("新細明體", Font.PLAIN, 20));
		  getContentPane().add(btnDonateReccord);
		  
		  JButton btnBuyReccord = new JButton("Buy Record");
		  btnBuyReccord.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
		    Buyrecord buyRecord = new Buyrecord();
		    buyRecord.setVisible(true);
		    dispose();
		   }
		  });
		  springLayout.putConstraint(SpringLayout.NORTH, btnBuyReccord, 22, SpringLayout.SOUTH, btnBuy);
		  springLayout.putConstraint(SpringLayout.WEST, btnBuyReccord, 0, SpringLayout.WEST, btnBuy);
		  springLayout.putConstraint(SpringLayout.EAST, btnBuyReccord, 0, SpringLayout.EAST, btnBuy);
		  btnBuyReccord.setFont(new Font("新細明體", Font.PLAIN, 20));
		  getContentPane().add(btnBuyReccord);
		
		  JButton btnReceiveReccord = new JButton("Receive Record");
		  btnReceiveReccord.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
		    Receiverecord receiveRecord = new Receiverecord();
		    receiveRecord.setVisible(true);
		    dispose();
		   }
		  });
		  springLayout.putConstraint(SpringLayout.NORTH, btnReceiveReccord, 22, SpringLayout.SOUTH, btnTake);
		  springLayout.putConstraint(SpringLayout.WEST, btnReceiveReccord, 94, SpringLayout.EAST, btnBuyReccord);
		  springLayout.putConstraint(SpringLayout.EAST, btnReceiveReccord, 0, SpringLayout.EAST, btnTake);
		  btnReceiveReccord.setFont(new Font("新細明體", Font.PLAIN, 20));
		  getContentPane().add(btnReceiveReccord);
		
		JLabel lblAccount = new JLabel("Account: ");
		String account = getUserInfoFromLogInFrame().getAccount();
		lblAccount.setText("Account: " + account);
		springLayout.putConstraint(SpringLayout.NORTH, lblAccount, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblAccount, 25, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblAccount, 0, SpringLayout.WEST, lblHomePage);
		lblAccount.setFont(new Font("新細明體", Font.PLAIN, 20));
		getContentPane().add(lblAccount);
		
		JLabel lblName = new JLabel("Name: ");
		String name = getUserInfoFromLogInFrame().getName();
		lblName.setText("Name: " + name);
		springLayout.putConstraint(SpringLayout.NORTH, lblName, 50, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblName, 25, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblName, 0, SpringLayout.WEST, lblHomePage);
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
	
	private Login getUserInfoFromLogInFrame2() {
		for (Frame frame : JFrame.getFrames()) {
			if (frame.getTitle().equals("Log in")) {
				Login LogInFrame = (Login) frame;
				return LogInFrame;
			}
		}
		return null;
	}

}

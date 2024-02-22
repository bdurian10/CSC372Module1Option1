package module1option1;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class BankBalanceFrame extends JFrame {
	//Label for account number
	private JLabel accountNumLabel = new JLabel("Enter Account Number:");
	//Displays account number
	private JTextField accountNumField = new JTextField(5);
	//Triggers login
	private JButton loginButton = new JButton("Login");
	
	public BankBalanceFrame() {
		//Create new panel with GridBagLayout
		JPanel loginPanel = new JPanel(new GridBagLayout());
		
		//Used to specify GUI component layout
		GridBagConstraints positionConst = new GridBagConstraints();
		positionConst.anchor = GridBagConstraints.WEST;
		positionConst.insets = new Insets(10, 10, 10, 10);
		
		//add account number label
		positionConst.gridx = 0;
		positionConst.gridy = 0;
		loginPanel.add(accountNumLabel, positionConst);
		
		//Add account number field
		positionConst.gridx = 1;
		loginPanel.add(accountNumField, positionConst);
		
		//Add login button
		positionConst.gridx = 0;
		positionConst.gridy = 1;
		positionConst.gridwidth = 2;
		positionConst.anchor = GridBagConstraints.CENTER;
		loginPanel.add(loginButton, positionConst);
		
		//Set panel border
		loginPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), 
				"Login Panel"));
		
		//Add panel to the frame
		add(loginPanel);
		
		//Set frames Title
		setTitle("BankBalance");
		
	}
	
	public static void main(String[] args) {
		
		//set look and feel to the system look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Create new BankBalance Frame
		BankBalanceFrame bankFrame = new BankBalanceFrame();
		bankFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bankFrame.pack();
		bankFrame.setVisible(true);
	}

}

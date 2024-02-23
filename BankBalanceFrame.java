package module1option1;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class BankBalanceFrame extends JFrame implements ActionListener {
	/**
	 * I don't know what this 
	 */
	private static final long serialVersionUID = -9018377602139359277L;
	//Label for account number
	private JLabel accountNumLabel = new JLabel("Enter Account Number:");
	//Displays account number
	private JTextField accountNumField = new JTextField(5);
	//Label for account number on account panel
	private JLabel accountLabel = new JLabel("Account Number:" );
	//Field for account number on account panel
	private JTextField accountField = new JTextField(5);
	//Label for balance
	private JLabel balanceLabel = new JLabel("Balance: $");
	//Displays balance
	private JFormattedTextField balanceField = new JFormattedTextField(NumberFormat.getNumberInstance());
	//Label for deposit 
	private JLabel depositLabel = new JLabel("Enter Amount to Deposit: $");
	//Displays deposit field
	private JFormattedTextField depositField = new JFormattedTextField(NumberFormat.getNumberInstance());
	//Trigger deposit
	private JButton depositButton = new JButton("Process Deposit");
	//Label for Withdrawal
	private JLabel withdrawalLabel = new JLabel("Enter Amout to Withdraw: $");
	//Displays withdrawal field
	private JFormattedTextField withdrawalField = new JFormattedTextField(NumberFormat.getNumberInstance());
	//Trigger withdrawal
	private JButton withdrawButton = new JButton("Process Withdrawal");
	//Triggers login
	private JButton loginButton = new JButton("Login");
	//Bank Account for login. Test case with 1 account. Could upgrade to read account info from a database
	private BankAccount account1 = new BankAccount("Doe", "John", 12345, 23000.3);
	//Create 2 panels with GridBagLayout
	private JPanel loginPanel = new JPanel(new GridBagLayout());
	private JPanel accountPanel = new JPanel(new GridBagLayout());
	public BankBalanceFrame() {
		
		//Use 'this' class to handle button presses
		loginButton.addActionListener(this);
		depositButton.addActionListener(this);
		withdrawButton.addActionListener(this);
		
		//Used to specify GUI component layout
		GridBagConstraints positionConst = new GridBagConstraints();
		positionConst.anchor = GridBagConstraints.WEST;
		positionConst.insets = new Insets(10, 10, 10, 10);
		
		//add account number label to login panel
		positionConst.gridx = 0;
		positionConst.gridy = 0;
		loginPanel.add(accountNumLabel, positionConst);
		
		//Add account number field to login panel
		positionConst.gridx = 1;
		loginPanel.add(accountNumField, positionConst);
		
		//Add login button to login panel
		positionConst.gridx = 0;
		positionConst.gridy = 1;
		positionConst.gridwidth = 2;
		positionConst.anchor = GridBagConstraints.CENTER;
		loginPanel.add(loginButton, positionConst);
		
		//Set panel border
		loginPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), 
				"Login Panel"));
		
		//Add account label to account panel
		positionConst.gridwidth = 1;
		positionConst.gridx = 0;
		positionConst.gridy = 0;
		accountPanel.add(accountLabel, positionConst);
		
		//Add account field to account panel
		accountField.setEditable(false);
		accountField.setText(Integer.toString(account1.getAccountID()));
		positionConst.gridx = 1;
		accountPanel.add(accountField, positionConst);
		
		//Add balance label to account panel
		positionConst.gridx = 0;
		positionConst.gridy = 1;
		accountPanel.add(balanceLabel, positionConst);
		
		//Add balance field to account panel
		balanceField.setEditable(false);
		balanceField.setColumns(15);
		positionConst.gridx = 1;
		positionConst.gridy = 1;
		accountPanel.add(balanceField, positionConst);
		
		//Add Deposit Label to account panel
		positionConst.anchor = GridBagConstraints.WEST;
		positionConst.gridx = 0;
		positionConst.gridy = 2;
		accountPanel.add(depositLabel, positionConst);
		
		//Add Deposit field to account panel
		positionConst.gridx = 1;
		depositField.setEditable(true);
		depositField.setColumns(15);
		accountPanel.add(depositField, positionConst);
		
		//Add Deposit Button to account panel
		positionConst.gridx = 2;
		accountPanel.add(depositButton, positionConst);
		
		//Add withdrawal label to account panel
		positionConst.gridx = 0;
		positionConst.gridy = 3;
		accountPanel.add(withdrawalLabel, positionConst);
		
		//Add withdrawal field to account panel
		positionConst.gridx = 1;
		withdrawalField.setEditable(true);
		withdrawalField.setColumns(15);
		accountPanel.add(withdrawalField, positionConst);
		
		//Add withdraw button to account panel
		positionConst.gridx = 2;
		accountPanel.add(withdrawButton, positionConst);		
		
		//Set panel border
		accountPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), 
				"Login Panel"));
		//Add panel to the frame
		add(loginPanel);
		
		//Set frames Title
		setTitle("BankBalance");
		
	}
	
	//Method is automatically called when an event occurs
	//e.g., when a button is pressed
	@Override
	public void actionPerformed(ActionEvent event) {
		String userAccountNum; //User specified account number
		int accountNumber; //Used for casting the userAccountNum string to double
		double balance = account1.getBalance(); //Stores the balance of the test bank account
		double deposit; //User specified deposit
		double withdrawal; //User specified withdrawal
		
		//Actions if loginButton pressed
		if(event.getSource() == loginButton) {
			//Get user's account number input
			userAccountNum = accountNumField.getText();
			
			//Convert from String to an integer
			accountNumber = Integer.parseInt(userAccountNum);
			
			//Determine if account number matches test account
			if(accountNumber == account1.getAccountID()) {
				//Update balanceField with the value of balance
				balance = account1.getBalance();
				balanceField.setValue(balance);
				
				//Hide the login screen and show the account screen
				loginPanel.setVisible(false);
				add(accountPanel);
			}
			
			//Inform user of bad login
			else {
				JOptionPane.showMessageDialog(null, "Login Failed. Please Try Again", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		//Actions if deposit button pressed
		if(event.getSource() == depositButton) {
			if(depositField.getValue() == null) {
				JOptionPane.showMessageDialog(null, "Null Value", "Error", JOptionPane.ERROR_MESSAGE);
			}
			//get user input from deposit field
			deposit = ((Number) depositField.getValue()).doubleValue();
			
			//Truncate deposit to two decimal places
			deposit = Double.parseDouble(String.format("%.2f", deposit));
			//Check for negative numbers
			if(deposit < 0) {
				JOptionPane.showMessageDialog(null, "Please Enter a Positive Number", "Error", JOptionPane.ERROR_MESSAGE);
			}

			else {
				//Use BankAccounts deposit method to process deposit
				account1.deposit(deposit);
				
				//Update balance
				balance = account1.getBalance();
				balanceField.setValue(balance);
			}
		}
		
		//Actions if withdraw button pressed
		if(event.getSource() == withdrawButton) {
			if(withdrawalField.getValue() == null) {
				JOptionPane.showMessageDialog(null, "Null Value", "Error", JOptionPane.ERROR_MESSAGE);
			}
			//get user input from deposit field
			withdrawal = ((Number) withdrawalField.getValue()).doubleValue();
			
			//Truncate withdrawal to two decimal places
			withdrawal = Double.parseDouble(String.format("%.2f", withdrawal));
			//Check for negative numbers
			if(withdrawal < 0) {
				JOptionPane.showMessageDialog(null, "Please Enter a Positive Number", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				//Use BankAccounts deposit method to process deposit
				account1.withdrawal(withdrawal);
				
				//Update balance
				balance = account1.getBalance();
				balanceField.setValue(balance);
			}
		}
		
		
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
		bankFrame.setSize(500, 300);
		bankFrame.setVisible(true);
	}

}

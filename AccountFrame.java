package module1option1;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AccountFrame extends JFrame {
	private BankAccount bankAccount;
	public AccountFrame(BankAccount bankAcct) {
		bankAccount = bankAcct;
		JLabel balanceLabel = new JLabel("Balance: $" + bankAccount.getBalance());
		
		//Add balance
		add(balanceLabel);
		
		//Set frame title
		setTitle("Account Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}

}

package module1option1;

public class CheckingAccount extends BankAccount {
	
	protected double interestRate;
	
	//Processes withdrawal, if balance is negative, 
	//withdrawals 30 additional dollars as an overdraft fee
	//Returns string 
	public String processWithdrawal() {
		
		if(this.getBalance() < 0) {
			
			this.withdrawal(30);
			return "Overdraft Fee of $30 Applied to Your Account";
		
		}
		
		else {
			
			String withdrawalMessage = "Withdrawal Processed. New Balance: " + this.getBalance();
			return withdrawalMessage;
			
		}
	}

}

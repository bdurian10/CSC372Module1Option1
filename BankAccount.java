package module1option1;

public class BankAccount {
	
	protected String firstName;
	protected String lastName;
	protected int accountID;
	protected double balance;
	
	//Default Constructor
	public BankAccount() {
		
		balance = 0;
		accountID = 0;
	
	}
	
	//Parameterized constructor
	public BankAccount(String firstName, String lastName, int accountID, double balance) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = balance;
	}
	
	//Method to deposit money into an account
	public double deposit(double deposit) {
		
		balance += deposit;
		return balance;
		
	}
	
	public double withdrawal(double withdrawal) {
		
		balance -= withdrawal;
		return balance;
		
	}
	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
		
	}
	
	public String getFirstName() {
		
		return firstName;
		
	}
	
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
		
	}
	
	public String getLastName() {
		
		return lastName;
		
	}
	
	public void setAccountID(int accountID) {
		
		this.accountID = accountID;
		
	}
	
	public int getAccountID() {
		
		return accountID;
		
	}
	 
	public double getBalance() {
		
		return balance;
		
	}
	
	//Prints account information
	public void accountSummary() {
		
		System.out.println(lastName + ", " + firstName);
		System.out.println("Account ID: " + accountID);
		System.out.printf("Balance: %f.2\n", balance);
		
	}

}

package module1option1;

public class TestBench {

	public static void main(String[] args) {
		//Create instance of BankAccount for testing
		BankAccount account = new BankAccount();
		
		//Test getter and setter for firstName
		account.setFirstName("John");
		if(account.getFirstName() != "John") {
			System.out.println("Expected: John Result: " + account.getFirstName());
		}
		
		//Test getter and setter for lastName
		account.setLastName("Doe");
		if(account.getLastName() != "Doe") {
			System.out.println("Expected: Doe Result: " + account.getLastName());
		}
		
		//Test getter and setter for accountID
		account.setAccountID(12345);
		if(account.getAccountID() != 12345) {
			System.out.println("Expected: 12345 Result: " + account.getAccountID());
		}
		
		//Test accountSummary method
		account.accountSummary();
		
		//Test deposit method. Test exception for negative arguments in the deposit method.
		System.out.println("Deposit $15: " + account.deposit(15));
		System.out.println("Deposit -$15: " + account.deposit(-15.5));
		
		//Test withdrawal method
		System.out.println("Withdrawal $15: " + account.withdrawal(15));
		
		//Create instance of CheckingAccount Class
		CheckingAccount account2 = new CheckingAccount();
		
		//Test getter and setter for firstName
		account2.setFirstName("Jane");
		if(account2.getFirstName() != "Jane") {
			System.out.println("Expected: Jane Result: " + account2.getFirstName());
		}
		
		//Test getter and setter for lastName
		account2.setLastName("Dane");
		if(account2.getLastName() != "Dane") {
			System.out.println("Expected: Doe Result: " + account2.getLastName());
		}
		
		//Test getter and setter for accountID
		account2.setAccountID(54321);
		if(account2.getAccountID() != 54321) {
			System.out.println("Expected: 54321 Result: " + account2.getAccountID());
		}
		
		//Test account summary method
		account2.accountSummary();
		
		//Test withdrawal and processWithdrawal when overdraft occurs. Should charge $30 fee and display negative balance with message
		System.out.println("Withdrawal $1888: " + account2.withdrawal(1888));
		System.out.println(account2.processWithdrawal());
		
		//Test deposit method
		System.out.println("Deposit $1950: " + account2.deposit(1950));
		
		//Test withdrawal and processWithdrawal when overdraft does not occur.
		System.out.println("Withdrawal $20: " + account2.withdrawal(20));
		System.out.println(account2.processWithdrawal());
		
		//Test exception for negative argument in deposit
		System.out.println("Deposit -$15.5: " + account2.deposit(-15.5));
		
		//Test displayAccount method
		account2.displayAccount();
	}
}

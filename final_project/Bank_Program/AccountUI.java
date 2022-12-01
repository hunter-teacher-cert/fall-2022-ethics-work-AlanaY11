import java.util.Scanner;

//import javax.swing.JOptionPane;

public class AccountUI {
	
	final static double FEE = 5.0;
	//static int addAcctCt = -1;
	//static Account newAccount = new Account();

	public static void main(String[] args) {
		System.out.println("***************************************");
		System.out.println("*        Red Line Express Bank        *");
		System.out.println("***************************************");
		System.out.println("     Where Your Money is Our Money     ");
		System.out.println();
		menu();
		
	}
	public static void menu() {
		int userOption = 1;
		
		while (userOption != 0) {
			
			do {
				Scanner userInput = new Scanner(System.in);
				System.out.println("+-------------------------------------+");
				System.out.println("|              Main Menu              |");
				System.out.println("+-------------------------------------+");
				System.out.println("|Select option number and press enter:|");
				System.out.println("+-------------------------------------+");
				System.out.println("|Option 1: Add New Account            |");         
				System.out.println("|Option 2: See Balance                |");
				System.out.println("|Option 3: Transaction                |");
				System.out.println("|Option 0: Exit                       |");
				System.out.println("+-------------------------------------+");
				userOption = userInput.nextInt();
				
				switch(userOption) {
					case 0:
						goodBye();
						break;
					case 1:
						//addAcctCt++;
						addAccount();
					  break;
					case 2:
						balanceView();
						break;
					case 3:
					    transact();
						break;
					default:
						System.out.println("No such option as " + userOption + ". Please enter"
								+ " 1,2,3, or 0 to exit.");
				}
				
			} while (userOption > 0 && userOption < 4);
			
		}
		
	}
	public static void addAccount() {
		
		String zip = "";
		String firstName = "";
		String lastName = "";
		double balance;
		Account newAccount = new Account();
		Scanner userInput = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Enter First Name:");
		firstName = userInput.nextLine();
		System.out.println("Enter Last Name:");
		lastName = userInput.nextLine();
		System.out.println("Enter Zip Code:");
		zip = userInput.nextLine();
		System.out.println("Enter Starting Balance:");
		balance =  Double.parseDouble(userInput.nextLine());
		Scanner clrInput = new Scanner(System.in);
		
		newAccount.set_accountName(lastName, firstName);
		newAccount.deposit(balance);
		
		if (newAccount.feeCheck(zip)) {
			newAccount.withdrawal(FEE);
			
			System.out.println();
			System.out.println();
			System.out.printf("Your Account has a $%.2f monthly fee.\nYour first payment is due at"
					+ " the time of opening your account.\n", FEE);
			System.out.printf(" Initial Depost: $ %6.2f\n", balance);
			System.out.printf("            Fee: $-%6.2f\n", FEE);
			System.out.printf("Current Balance: $ %6.2f\n", newAccount.seeBalance(lastName, firstName));
			System.out.println();
			System.out.println();
//			JOptionPane.showMessageDialog(null, "Sorry!\nYou Have been digitally RED-LINED. ");
//			JOptionPane.showMessageDialog(null, "Your Account has a $" + String.format("%.2f", FEE)
//					+ " monthly fee.\n"
//			+ "Your first payment is due at the time of opening your account.\n " 
//			+ "Initial Depost: $" + String.format("%.2f", balance) + "\n"
//			+ "Fee: $" + String.format("-%.2f", FEE) + "\n"
//			+ "Current Balance: $" + String.format("%.2f", newAccount.seeBalance(lastName, firstName))
//			+ "\n");
			//userInput.close();
		}
		
		else {
			System.out.println();
			System.out.println();
			System.out.printf("Your Account is free, with no monthly fees.\nWe value your business.\n");
			System.out.printf("  Initial Depost: $%6.2f\n", balance);
			System.out.printf("             Fee: $%6.2f\n", 0.0);
			System.out.printf(" Current Balance: $%6.2f\n", newAccount.seeBalance(lastName, firstName));
			System.out.println();
			System.out.println();
			
//			JOptionPane.showMessageDialog(null, "Your Account is free, with no monthly fees\n"
//					
//			+ "We value your business.\n" 
//			+ "Initial Depost: $" + String.format("%.2f", balance) + "\n"
//			+ "Fee: $" + String.format("%.2f", 0.0) + "\n"
//			+ "Current Balance: $" + String.format("%.2f", newAccount.seeBalance(lastName, firstName))
//			+ "\n");
			//userInput.close();
		}
		
		newAccount = null;	
		
	}
	public static void balanceView() {
		String firstName = "";
		String lastName = "";
		String balance;
		Account viewAccount = new Account();
		Scanner userInput = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Enter First Name:");
		firstName = userInput.nextLine();
		System.out.println("Enter Last Name:");
		lastName = userInput.nextLine();
		
		//viewAccount.seeBalance(lastName, firstName);
		balance = String.format("$%.2f", viewAccount.seeBalance(lastName, firstName));
		
		System.out.println();
		System.out.println();
		System.out.printf("%s %s\nBalance: %s\n",firstName, lastName, balance);
		System.out.println();
		System.out.println();
	}
	public static void transact() {
		int userOption = 1;
		
		while (userOption != 0) {
			
			do {
				Scanner userInput = new Scanner(System.in);
				System.out.println("+-------------------------------------+");
				System.out.println("|           Transaction Menu          |");
				System.out.println("+-------------------------------------+");
				System.out.println("|Select option number and press enter:|");
				System.out.println("+-------------------------------------+");
				System.out.println("|Option 1: Deposit                    |");
				System.out.println("|Option 2: Withdrawal                 |");
				System.out.println("|Option 0: Exit to Main Menu          |");
				System.out.println("+-------------------------------------+");
				System.out.println();
				userOption = userInput.nextInt();
				
				switch(userOption) {
					case 0:
						return;
						//break;
					case 1:
						deposit();
					  break;
					case 2:
						withdrawal();
						break;
					default:
						System.out.println("No such option as " + userOption + ". Please enter"
								+ " 1,2, or 0 to exit to Main Menu.");
				}
				
			} while (userOption > 0 && userOption < 4);
			
		}
		
	}
	public static void deposit() {
		String firstName = "";
		String lastName = "";
		String balance;
		double amount;
		Account creditAccount = new Account();
		Scanner userInput = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Enter First Name:");
		firstName = userInput.nextLine();
		System.out.println("Enter Last Name:");
		lastName = userInput.nextLine();
		System.out.println("Enter the Amount to Deposit:");
		amount = userInput.nextFloat();
		
		creditAccount.set_accountName(lastName, firstName);
		creditAccount.setBalance();
		creditAccount.deposit(amount);
		balance = String.format("$%.2f", creditAccount.seeBalance(lastName, firstName));
		
		System.out.println();
		System.out.println();
		System.out.printf("%s %s\nBalance: %s\n",firstName, lastName, balance);
		System.out.println();
		System.out.println();
//		JOptionPane.showMessageDialog(null, firstName + " " + lastName + "\n"
//				+ "Balance: " + balance);
		
	}
	public static void withdrawal() {
		String firstName = "";
		String lastName = "";
		String balance;
		double amount;
		Account debitAccount = new Account();
		Scanner userInput = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Enter First Name:");
		firstName = userInput.nextLine();
		System.out.println("Enter Last Name:");
		lastName = userInput.nextLine();
		System.out.println("Enter the Amount to Withdrawal:");
		amount = userInput.nextFloat();
		
		//debitAccount.accountNameTransact(lastName, firstName);
		debitAccount.set_accountName(lastName, firstName);
		debitAccount.setBalance();
		debitAccount.withdrawal(amount);
		balance = String.format("$%.2f", debitAccount.seeBalance(lastName, firstName));
		
		System.out.println();
		System.out.println();
		System.out.printf("%s %s\nBalance: %s\n",firstName, lastName, balance);
		System.out.println();
		System.out.println();
		
//		JOptionPane.showMessageDialog(null, firstName + " " + lastName + "\n"
//				+ "Balance: " + balance);
		
	}
	public static void goodBye() {
		System.out.println("***************************************");
		System.out.println("*        Red Line Express Bank        *");
		System.out.println("***************************************");
		System.out.println("  Thank you for banking with us today! ");
		System.out.println();
		System.exit(0);
	}


}

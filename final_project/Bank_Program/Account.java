import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Account{
	private long Balance;
	private String AccountName;
	//private String accountMaster;
	
	
		

	public Account() {
			
		Balance = 0;
		AccountName = "CustomerA";
		
		
				
	}
//	public Account(String last, String first) {
//		
//		Balance = 0;
//		accountName = last + first;
//		appendLastAccountToAccounts();
//			
//				
//	}
	

	private void set_Balance(long bal) {
			
		try {
			
			Balance = bal;
				
			FileWriter file = new FileWriter(AccountName + "balance.txt"); BufferedWriter buffer = new
			BufferedWriter(file);
			buffer.write(Long.toString(bal)); buffer.newLine();
			buffer.close();	
		}
		catch (IOException e) {
				
			System.out.println("Error!");	
		}
	}
	private double get_Balance() {
		
		double bal = 0;
			
		try { 
			FileReader file = new FileReader(AccountName + "balance.txt");
			BufferedReader buffer = new BufferedReader(file);
			String line = "";
			
			while ((line = buffer.readLine() )!= null)
				Balance = Long.parseLong(line);			
			buffer.close();
		}
		catch (IOException e) {
			
			System.out.println("Error!");
			
		}
	
			
		bal = Balance / (double) 100; 
			
		return bal;
		}
		public void setBalance() {
			
			try { 
				FileReader file = new FileReader(AccountName + "balance.txt");
				BufferedReader buffer = new BufferedReader(file);
				String line = "";
				
				while ((line = buffer.readLine() )!= null)
					Balance = Long.parseLong(line);			
				buffer.close();
			}
			catch (IOException e) {
				
				System.out.println("Error!");
				
			}
			
		}
//		private long get_Balance() {
//			
//			long bal = 0;
//				
//			try { 
//				FileReader file = new FileReader(AccountName + "balance.txt");
//				BufferedReader buffer = new BufferedReader(file);
//				String line = "";
//				
//				while ((line = buffer.readLine() )!= null)
//					Balance = Long.parseLong(line);			
//				buffer.close();
//			}
//			catch (IOException e) {
//				
//				//System.out.println("Error!");
//				
//			}
//		
//				
//			
//				
//			return bal;
//			}
		
		public void set_accountName(String last, String first) {
			AccountName = last + first;
			//saveAccountMasterString();
			//appendAccountMasterString();
			//saveLastAccount();
			
			//appendLastAccountToAccounts();
			
			
			
		}
//		public void accountNameTransact(String last, String first) {
//			AccountName = last + first;
//			
//			
//		
//			
//			
//			
//		}
		
		public void deposit(double val) {
			//long oldBalance = get_Balance();	
			long amt = (long) (val * 100);
			set_Balance(Balance += amt);	
			//set_Balance(Balance = amt + oldBalance);
		}
		public void withdrawal(double val) {
			//long oldBalance = get_Balance();	
			long amt = (long) (val * 100);
			set_Balance(Balance -= amt);	
			//set_Balance(Balance = oldBalance - amt);
		}
		public boolean feeCheck(String zip) {
			
			try { 
				FileReader file = new FileReader("feeZips.txt");
				BufferedReader buffer = new BufferedReader(file);
				String line = "";
				
				while ((line = buffer.readLine() )!= null)
					if (line.equals(zip)) {
						buffer.close();
						return true;
					}
				buffer.close();
			}
			catch (IOException e) {
				
				System.out.println("Error!");
				
			}
			
			return false;
		}
		public double seeBalance(String last, String first) {
			double bal = 0;
			
			try { 
				FileReader file = new FileReader(last + first + "balance.txt");
				BufferedReader buffer = new BufferedReader(file);
				String line = "";
				
				while ((line = buffer.readLine() )!= null)
					Balance = Long.parseLong(line);			
				buffer.close();
			}
			catch (IOException e) {
				
				System.out.println("Error!");
				
			}
				
			bal = Balance / (double) 100;
			
			return bal;
		}
		
		
//			private void appendAccountMasterString () {
//				//String temp = "";
//				
//				try { 
//					FileReader file = new FileReader("accounts.txt");
//					BufferedReader buffer = new BufferedReader(file);
//					String line = "";
//					
//					while ((line = buffer.readLine() )!= null)
//						//temp = AccountName + "," + line;	
//						accountMaster = AccountName + "," + line;
//					buffer.close();
//				}
//				catch (IOException e) {
//					
//					System.out.println("Error!");
//					
//				}
//				
//		}
//			private void appendLastAccountToAccounts() {
//				String temp = "";
//				
//				try { 
//					FileReader file = new FileReader("accounts.txt");
//					BufferedReader buffer = new BufferedReader(file);
//					String line = "";
//					
//					while ((line = buffer.readLine() )!= null)
//						temp = temp + AccountName + "," + line;	
//						
//					buffer.close();
//				}
//				catch (IOException e) {
//					
//					System.out.println("Error!");
//					
//				}
//				try {
//					
//						
//					FileWriter file = new FileWriter("accounts.txt"); 
//					BufferedWriter buffer = new BufferedWriter(file);
//					buffer.write(temp);
//					buffer.newLine();
//					buffer.close();	
//				}
//				catch (IOException e) {
//						
//					System.out.println("Error!");	
//				}
//			}
				
				
		
//		public String[] getAccounts() {
//			
//			Scanner sc;
//			int count = 0;
//			
//			
//			try {
//				sc = new Scanner(new File("accounts.txt"));
//				sc.useDelimiter(",");
//				while (sc.hasNext()){ 
//					
//					count++;
//				  
//				  }
//				  
//			    sc.close();
//			} catch (FileNotFoundException e) {
//				
//				e.printStackTrace();
//			}
//			
//			String [] accounts = new String [5];
//			
//			try {
//				sc = new Scanner(new File("accounts.txt"));
//				sc.useDelimiter(",");
//				int i = 0;
//				while (sc.hasNext()){ 
//					
//					accounts[i] = sc.next();
//					
//					i++;
//				  
//				  }
//				  
//			    sc.close();
//			} catch (FileNotFoundException e) {
//				
//				e.printStackTrace();
//			}
//			
//			return accounts;
//		}
		
//		private void saveLastAccount () { 
//			try { 
//		  
//		  
//				FileWriter file = new FileWriter("lastAccount.txt"); 
//				BufferedWriter buffer = new BufferedWriter(file); 
//				buffer.write(AccountName); buffer.newLine();
//				buffer.close(); 
//			} 
//			catch (IOException e) {
//		  
//				System.out.println("Error!"); 
//			} 
//		}
//		private void saveAccountMasterString() { 
//			try { 
//		  
//		  
//				FileWriter file = new FileWriter("accounts.txt"); 
//				BufferedWriter buffer = new BufferedWriter(file); 
//				buffer.write(accountMaster); buffer.newLine();
//				buffer.close(); 
//			} 
//			catch (IOException e) {
//		  
//				System.out.println("Error!"); 
//			} 
//		}
		 
		
		
		public String toString() {
			//double balFloat = get_Balance() / (double) 100;
			//String bal = String.format("$%.2f",balFloat);
			return String.format("$%.2f", get_Balance());
		}
}


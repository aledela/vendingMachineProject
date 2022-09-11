package vend;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Vending Machine Homework Assignment
 * VendingMachineTester -- main method testing of the VendingMachine Class
 * 
 * @author Anonymous for grading purposes
 * 
 * @version October 14, 2018
 */
public class VendingMachineTester {
	/**
	 * The <code>depositScan</code> field contains the scanner for the user's deposit
	 */
	private static Scanner depositScan;
	
	/**
	 * The <code>choiceScan</code> field contains the scanner for the user's choice of Soda
	 */
	private static Scanner choiceScan;
	
	public static void main(String[] args) throws FileNotFoundException {
		VendingMachine Vend = new VendingMachine();  
		Prompts allPrompts = new Prompts();

		//Used for terminal	input	
		depositScan = new Scanner(System.in);
		choiceScan = new Scanner(System.in);
		
		while (Vend.getTotalSodaAmount() != 0) {
			if (Vend.getExactChangeLight()) { //checks whether Exact Change Light should be on or off
				System.out.println("Exact Change Light is on"); 
			}
			else {
				System.out.println("Exact Change Light is off");
			}
			System.out.println("New transaction started\n");
			allPrompts.DepositPrompt();
			if (ScanningDeposit(Vend, allPrompts) == 0) {
				allPrompts.ChoicePrompt();
				ScanningChoice(Vend, allPrompts);
			}
			System.out.println("Transaction completed \n");
			Vend.depositToChange(); 
			Vend.resetCurrentBillDeposit();
		}
			System.out.println("All sodas are Sold Out");
	}
	
	/*
	 * The <code>ScanningDeposit</code> method automates the user input process for the money deposit
	 *  and calls the appropriate VendingMachine methods.
	 */
	public static int ScanningDeposit(VendingMachine Vend, Prompts allPrompts) {
		String deposit = null;
		int leverVariable = 0;
		int price;
		while (depositScan.hasNext()) {
			deposit = depositScan.nextLine();
			if(Vend.getExactChangeLight()) {
				price = Vend.getPrice();
				if (deposit.equals("dollar")) {
					System.out.println("Dollar bills are not accepted, please choose a different option");
					allPrompts.DepositPrompt();
					ScanningDeposit(Vend, allPrompts);
				}
			} else {
				price = 200;
			} 
			Vend.deposit(deposit, Vend.getPrice());
			if (Vend.getTotalCurrentDeposit() <= price) {
				if ((deposit.compareTo("Lever") == 0)) {
					Vend.returnLever();
					leverVariable++;
					break;
				} else if ((deposit.compareTo("Price") == 0)) {
					System.out.println("Soda Price: $" + Vend.getPrice() / 100.00);
				} else if (deposit.equals("Vend")) {
					System.out.println("You have deposited: $" + Vend.getTotalCurrentDeposit() / 100.00);
					break;
				}
				
				System.out.println("You have deposited: $" + Vend.getTotalCurrentDeposit() / 100.00);
			}
			else {
				System.out.println("Amount exceeded $" + price/100.00 + ", extra bill or coin has been returned"); // Stops the
				Vend.retrieve(deposit);
				System.out.println("Total Deposited " + Vend.getTotalCurrentDeposit()/100.0);// enter money
				break;
			}
			

			allPrompts.DepositPrompt();
		}
		return leverVariable;
	}
	
	/*
	 * The <code>ScanningChoice</code> method automates the user input process for the soda choice, vending, and change
	 *  and calls the appropriate VendingMachine methods.
	 */
	public static void ScanningChoice(VendingMachine Vend, Prompts allPrompts) {
		String choice = null;
		int price;
		boolean vended;

		choice = choiceScan.nextLine();
		price = Vend.getPrice();
		if ((choice.compareTo("Lever") == 0)) {
			System.out.println("Transaction cancelled");
			Vend.returnLever();
		}
			while (Vend.getMoreDepositLight()) {
				System.out.println("The funds you deposited are less than the price of the soda you chose, \n"
						+ "please insert more coins or bills or choose a different Soda\n");
				allPrompts.DepositPrompt();
				if (ScanningDeposit(Vend, allPrompts) != 0)
					break;
			}
			vended = Vend.vendSodaStock(choice);
//			if (Vend.getTotalSodaAmount() == 0)
//				Vend.returnLever();
			if (!vended) {
				System.out.println("Soda not found, please choose another soda option");
				allPrompts.ChoicePrompt();
				ScanningChoice(Vend, allPrompts);
			} else {
				System.out.println("One " + choice + " vended");
				Vend.change(price);
				if(Vend.getExactChangeLight()) {
					System.out.println("Exact Change Light is on");
				}
			}
		
	}

}

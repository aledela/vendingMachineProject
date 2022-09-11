package vend;

/**
 * Vending Machine Homework Assignment
 * Vending Machine -- simulates the workings of a real life vending machine
 * 
 * @author Anonymous for grading purposes
 * 
 * @version October 14, 2018
 * 
 *          An object of the <code>Vending Machine</code> class models a vending
 *          machine with a full stockpile of soda cans and a large supply of
 *          change in its change box.
 */
public class VendingMachine {

	/**
	 * The <code>pepsiStock</code> field contains a Stockpile object for the soda
	 * cans.
	 */
	private Stockpile pepsiStock = new Stockpile();

	/**
	 * The <code>mountainDewStock</code> field contains a Stockpile object for the
	 * soda cans.
	 */
	private Stockpile mountainDewStock = new Stockpile();

	/**
	 * The <code>cocaColaStock</code> field contains a Stockpile object for the soda
	 * cans.
	 */
	private Stockpile cocaColaStock = new Stockpile();

	/**
	 * The <code>sevenUpStock</code> field contains a Stockpile object for the soda
	 * cans.
	 */
	private Stockpile sevenUpStock = new Stockpile();

	/**
	 * The <code>fantaStock</code> field contains a Stockpile object for the soda
	 * cans.
	 */
	private Stockpile fantaStock = new Stockpile();

	/**
	 * The <code>spriteStock</code> field contains a Stockpile object for the soda
	 * cans.
	 */
	private Stockpile spriteStock = new Stockpile();

	/**
	 * The <code>doctorPepperStock</code> field contains a Stockpile object for the
	 * soda cans.
	 */
	private Stockpile doctorPepperStock = new Stockpile();

	/**
	 * The <code>sierraMistStock</code> field contains a Stockpile object for the
	 * soda cans.
	 */
	private Stockpile sierraMistStock = new Stockpile();

	/**
	 * The <code>depositCoinBox</code> field contains a CoinBox object that contains
	 * the deposits made in coins.
	 */
	private CoinBox depositCoinBox = new CoinBox();

	/**
	 * The <code>changeBoxx</code> field contains a CoinBox object that contains
	 * change in coins.
	 */
	private CoinBox changeBox = new CoinBox();

	/**
	 * The <code>depositBillBox</code> field contains a BillBox object that contains
	 * the deposits made in bills.
	 */
	private BillBox depositBillBox = new BillBox();

	/**
	 * The <code>currentBillDeposit</code> field contains whether the Exact Change
	 * Light is on.
	 */
	private int currentBillDeposit;

	// initial amounts
	private int cans;

	private int price;

	private int amount;

	/**
	 * The <code>VendingMachine</code> constructor allocates storage for a new
	 * <code>Vending Machine</code>, initializes a stockpile for each Soda, two
	 * coinboxes, billbox and the initial amounts and prices.
	 */
	public VendingMachine() {
		cans = 10;
		price = 125;
		amount = 3;

		changeBox.depositAll(amount);
		if (changeBox.cashValue() < 100)
			changeBox.turnChangeLight(true); // “Exact Change Only” light
		else
			changeBox.turnChangeLight(false);
		depositCoinBox.turnChangeLight(true); // “Deposit More Money” light

		currentBillDeposit = 0;

		pepsiStock.amountSet(cans);
		pepsiStock.priceSet(price);

		mountainDewStock.amountSet(cans);
		mountainDewStock.priceSet(price);

		cocaColaStock.amountSet(cans);
		cocaColaStock.priceSet(price);

		sevenUpStock.amountSet(cans);
		sevenUpStock.priceSet(price);

		fantaStock.amountSet(cans);
		fantaStock.priceSet(price);

		spriteStock.amountSet(cans);
		spriteStock.priceSet(price);

		doctorPepperStock.amountSet(cans);
		doctorPepperStock.priceSet(price);

		sierraMistStock.amountSet(cans);
		sierraMistStock.priceSet(price);
	}

	/*
	 * The <code>deposit</code> deposits a quarter, or a dime, a nickel, or a
	 * dollar.
	 */
	public void deposit(String choice, int price) {
		if (choice.equals("quarter"))
			depositCoinBox.depositQuarters();
		else if (choice.equals("dime"))
			depositCoinBox.depositDimes();
		else if (choice.equals("nickel"))
			depositCoinBox.depositNickels();
		else if (choice.equals("dollar")) {
			currentBillDeposit++;
		} else if (choice.equals("Lever"))
			;
		else if (choice.equals("Vend"))
			;
		else if (choice.equals("Price"))
			;
		else
			System.out.println("Choice entered was not found, please enter one of the options given above");
		if (getTotalCurrentDeposit() >= price) {
			depositCoinBox.turnChangeLight(false);
		}
	}

	/*
	 * The <code>currentToBillDeposit</code> method transfers the dollar bills deposited in
	 * the current transaction to the deposit Bill Box.
	 */
	public void currentToBillDeposit() {
		while (currentBillDeposit > 0) {
			depositBillBox.depositBill();
			currentBillDeposit--;
		}
	}

	/*
	 * The <code>depositToChange</code> method transfers coins deposited in the
	 * depositCoinBox to the changeBox.
	 */
	public void depositToChange() {
		int i;
		for (i = depositCoinBox.getQuarters(); i > 0; i--) {
			depositCoinBox.retrieveQuarters();
			changeBox.depositQuarters();
		}
		for (i = depositCoinBox.getDimes(); i > 0; i--) {
			depositCoinBox.retrieveDimes();
			changeBox.depositDimes();
		}
		for (i = depositCoinBox.getNickels(); i > 0; i--) {
			depositCoinBox.retrieveNickels();
			changeBox.depositNickels();
		}
	}

	/*
	 * The <code>returnLever</code> method drops the amount of total current
	 * deposits as change from the changeBox
	 */
	public void returnLever() {
		int i;
		for (i = depositCoinBox.getQuarters(); i > 0; i--) {
			changeBox.retrieveQuarters();
		}
		for (i = depositCoinBox.getDimes(); i > 0; i--) {
			changeBox.retrieveDimes();
		}
		for (i = depositCoinBox.getNickels(); i > 0; i--) {
			changeBox.retrieveNickels();
		}
		for (i = (4 * currentBillDeposit); i > 0; i--) {
			changeBox.retrieveQuarters();
		}
		currentToBillDeposit();
		System.out.println("All deposits have been returned, please pick up the change if you made a deposit");
	}

	/*
	 * The <code>change</code> method returns change from the changeBox based on the
	 * price of the soda. If not enough change is left in the changeBox then the
	 * Exact Change Light is turned on. If the exact price was paid, a message is
	 * returned and no change is taken from the changeBox.
	 */
	public void change(int price) {
		int totalDeposit = currentBillDeposit * 100 + depositCoinBox.cashValue();
		int changeRetrieved = totalDeposit - price;
		int changeRetrievedCounter = changeRetrieved;
		while ((changeRetrievedCounter >= 25) && (changeBox.getQuarters() > 0)) {
			changeBox.retrieveQuarters();
			changeRetrievedCounter -= 25;
		}
		while ((changeRetrievedCounter >= 10) && (changeBox.getDimes() > 0)) {
			changeBox.retrieveDimes();
			changeRetrievedCounter -= 10;
		}
		while ((changeRetrievedCounter >= 5) && (changeBox.getNickels() > 0)) {
			changeBox.retrieveNickels();
			changeRetrievedCounter -= 5;
		}
		if (changeRetrievedCounter > 0) {
			changeBox.turnChangeLight(true);
			System.out
					.println("Only change of " + (changeRetrieved - changeRetrievedCounter)/100.00 + " was available. Please pick up the change");

		} else if (changeRetrieved == 0)
			System.out.println("Exact amount paid, no change was returned");
		else
			System.out.println("Change of " + changeRetrieved / 100.00 + " . Please pick up the change.");
	}

	/*
	 * The <code>retrieve</code> method takes coins or bills out of the
	 * depositCoinBox or currentBillDeposit based on the option given.
	 */
	public void retrieve(String choice) {
		if (choice.equals("quarter"))
			depositCoinBox.retrieveQuarters();
		else if (choice.equals("dime"))
			depositCoinBox.retrieveDimes();
		else if (choice.equals("nickle"))
			depositCoinBox.retrieveNickels();
		else if (choice.equals("dollar"))
			currentBillDeposit--;
		else
			System.out.println("Choice entered was not found, please enter one of the option given above");
	}

	// Get methods

	/*
	 * The <code>getTotalCurrentDeposit</code> method returns the total amount
	 * deposited during the current transaction in cash value.
	 */
	public int getTotalCurrentDeposit() {
		int total = (currentBillDeposit * 100) + depositCoinBox.cashValue();
		return total;
	}

	/*
	 * The <code>getCurrentBillDeposit</code> method returns the amount of dollar
	 * bills deposited not in cash value.
	 */
	public int getCurrentBillDeposit() {
		return currentBillDeposit;
	}

	/*
	 * The <code>resetCurrentBillDeposit</code> method sets the amount of dollar
	 * bills deposited to 0.
	 */
	public void resetCurrentBillDeposit() {
		currentBillDeposit = 0;
	}

	/*
	 * The <code>etTotalBillDepositBox</code> method returns the total amount of
	 * dollar bills in the vending machine.
	 * 
	 */
	public int getTotalBillDepositBox() {
		return depositBillBox.cashValue();
	}

	/*
	 * The <code>getTotalChange</code> method returns the total amount of change in
	 * the changeBox in cash value.
	 */
	public int getTotalChange() {
		return changeBox.cashValue();
	}

	/*
	 * The <code>getTotalSodaAmount</code> return the total amount of all soda in
	 * the Vending Machine.
	 */
	public int getTotalSodaAmount() {
		int total = pepsiStock.getAmount() + mountainDewStock.getAmount() + cocaColaStock.getAmount()
				+ sevenUpStock.getAmount() + fantaStock.getAmount() + spriteStock.getAmount()
				+ doctorPepperStock.getAmount() + sierraMistStock.getAmount();
		return total;
	}

	/*
	 * The <code>getPrice</code> returns the price of the soda.
	 */
	public int getPrice() {
		return price;
	}

	/*
	 * The <code>getMoreDepositLight</code> returns whether the “Deposit More Money”
	 * light is on or off.
	 */
	public boolean getMoreDepositLight() {
		return depositCoinBox.getChangeLight();
	}

	/*
	 * The <code>getExactChangeLight</code> returns whether the “Exact Change Light”
	 * light is on or off.
	 */
	public boolean getExactChangeLight() {
		return changeBox.getChangeLight();
	}

	/*
	 * The <code>vendSodaStock</code> vends a can of soda depending on the choice
	 * given, reduces the amount of the chosen soda by 1.
	 */
	public boolean vendSodaStock(String s) {
		boolean vended = false;
		if ((s.equals("Pepsi")))
			vended = pepsiStock.vend();
		else if ((s.equals("Mountain Dew")))
			vended = mountainDewStock.vend();
		else if ((s.equals("Coca Cola")))
			vended = cocaColaStock.vend();
		else if ((s.equals("Seven Up")))
			vended = sevenUpStock.vend();
		else if ((s.equals("Fanta")))
			vended = fantaStock.vend();
		else if ((s.equals("Sprite")))
			vended = spriteStock.vend();
		else if ((s.equals("Doctor Pepper")))
			vended = doctorPepperStock.vend();
		else if ((s.equals("Sierra Mist")))
			vended = sierraMistStock.vend();
		return vended;
	}
}

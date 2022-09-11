package vend;
/**
 * Vending Machine Homework Assignment
 * Stockpile -- creates a stockpile of a certain type of soda
 * 
 * @author Anonymous for grading purposes
 * 
 * @version October 14, 2018
 * 
 *          An object of the <codeStockpile</code> contains the amount and price of a 
 *          type of soda, and a SoldOut warning light.
 */
public class Stockpile {

	/**
	 * The <code>amount</code> field contains the amount of soda in the stockpile
	 */
	private int amount;
	
	/**
	 * The <code>price</code> field contains the price the soda in the stockpile
	 */
	private int price;
	
	/**
	 * The <code>soldOut</code> field contains a switch that indicates whether the soda
	 * in the stockpile is Sold Out
	 */
	private Switch soldOut = new Switch();
	
	/**
	 * The <code>Stockpile</code> constructor allocates storage for a new
	 * <code>Stockpile</code>, initializes the amount and price of the soda, and turns
	 * the sold Out light on since amount = 0 initially
	 */
	public Stockpile(){
		amount = 0;
		price = 0;
		soldOut.turn(true);
	}
	
	//Get Methods
	/**
	 * The <code>getAmount</code> method returns the amount of soda in the Stockpile.
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * The <code>getPrice</code> method returns the price of soda in the Stockpile.
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * The <code>getSoldState</code> method returns the whether the soda in the Stockpile is
	 * Sold Out
	 */
	public boolean getSoldState() {
		return soldOut.report();
	}
	
	//Vend
	/**
	 * The <code>vend</code> method vends a soda in the Stockpile by reducing the amount
	 * of soda by 1 and turns the "SoldOut" light on.
	 */
	public boolean vend() {
		boolean vended = true;
		if(amount == 0) {
			soldOut.turn(true);
			System.out.println("Sold Out");
		}
		else {
			amount--;
		}
		return vended; //if true then the process of vending went through
	}
	
	//Set methods
	/**
	 * The <code>amountSet</code> method set the amount of soda in the Stockpile to amountNum.
	 */
	public void amountSet(int amountNum){
		if(amountNum != 0)
			soldOut.turn(false);
		amount = amountNum;
	}
	
	/**
	 * The <code>priceSet</code> method sets the price of soda in the Stockpile to priceNum.
	 */
	public void priceSet(int priceNum) {
		price = priceNum;
	}
}
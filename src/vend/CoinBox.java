package vend;
/**
 * Vending Machine Homework Assignment
 * CoinBox -- simulates a Coin Box inside a Vending Machine
 * 
 * @author Anonymous for grading purposes
 * 
 * @version October 14, 2018
 * 
 *          An object of the <code>CoinBox</code> contains quarters, dimes, nickels
 *          and a switch object for the "Exact Change Light" and "Deposit More Money” lights.
 */
public class CoinBox {
	/** The <code>quarters</code> field
    contains the amount of quarters deposited.
    */
	private int quarters;
	
	/** The <code>dimes</code> field
    contains the amount of dimes deposited.
    */
	private int dimes;
	
	/** The <code>nickels</code> field
    contains the amount of nickels deposited.
    */
	private int nickels;
	
	/** The <code>exactChangelight</code> field
    contains whether the is on.
    */
	private Switch changeLight = new Switch();
	
	/** The <code>CoinBox</code> constructor
    allocates storage for a new <code>CoinBox</code>,
    initializes quarters, dimes and nickelss amount, and
    turns the light switch on since all coins are initialized to 0.
*/
	
	public void Coinbox(){
		quarters = 0;
		dimes = 0;
		nickels = 0;
		changeLight.turn(false);
		
	}
	//Deposit Methods
	/**
	 * The <code>depositQuarters</code> method deposits a quarter into the CoinBox.
	 */
	public void depositQuarters ()
	{
		quarters++;
	}
	
	/**
	 * The <code>depositDimes</code> method deposits a dime into the CoinBox.
	 */
	public void depositDimes ()
	{
		dimes++;
	}
	
	/**
	 * The <code>depositNickels</code> method deposits a nickel into the CoinBox.
	 */
	public void depositNickels ()
	{
		nickels++;
	}
	
	/**
	 * The <code>turnChangeLight</code> method changes the state of the changeLight to "state".
	 */
	public void turnChangeLight(boolean state) {
		changeLight.turn(state);
	}
	
	//Retrieve Methods
	
	/**
	 * The <code>retrieveQuarters</code> method moves one quarter out of the coinBox.
	 */
	public void retrieveQuarters ()
	{
		quarters--;
	}
	
	/**
	 * The <code>retrieveDimes</code> method moves one dime out of the coinBox.
	 */
	public void retrieveDimes ()
	{
		dimes--;
	}
	
	/**
	 * The <code>retrieveNickels</code> method moves one nickel out of the coinBox.
	 */
	public void retrieveNickels ()
	{
		nickels--;
	}
	
	//get amount of coins
	/**
	 * The <code>getQuarters</code> method returns amount of quarters in the CoinBox.
	 */
	public int getQuarters()
	{
		return quarters;
	}
	
	/**
	 * The <code>getDimes</code> method returns amount of dimes in the CoinBox.
	 */
	public int getDimes()
	{
		return dimes;
	}
	
	/**
	 * The <code>getNickels</code> method returns amount of nickels in the CoinBox.
	 */
	public int getNickels()
	{
		return nickels;
	}
	
	/**
	 * The <code>getChangeLgiht</code> method returns the state of the changeLight.
	 */
	public boolean getChangeLight()
	{
		return changeLight.report();
	}
	
	/**
	 * The <code>cashValue</code> method returns the amount of money in the CoinBox 
	 * in cash value.
	 */
	public int cashValue () {
		int total = 25*quarters + 10*dimes + 5*nickels;
		return total;
	}
	
	/**
	 * The <code>depositAll</code> method deposits "amount" of quarters, dimes, 
	 * and nickels into the CoinBox.
	 */
	public void depositAll(int amount) {
		for(int i  = 0; i < amount; i++) {
			depositQuarters();
			depositNickels();
			depositDimes();
		}
	}
}
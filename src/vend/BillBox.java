package vend;
/**
 * Vending Machine Homework Assignment
 * BillBox -- simulates a Bill Box inside a Vending Machine
 * 
 * @author Anonymous for grading purposes
 * 
 * @version October 14, 2018
 * 
 *          An object of the <code>BillBox</code> contains contains dollar bills.
 */
public class BillBox {

	/** The <code>dollarBill</code> field
    contains the amount of one dollar bills deposited.
    */
	private int dollarBill;
	
	/** The <code>BillBox</code> constructor
    allocates storage for a new <code>BillBox</code>,
    initializes a dollarBill field.
*/
	public BillBox() {
		dollarBill = 0;
	}
	
	/**
	 * The <code>depositBill</code> method deposits a dollar bill into the BillBox.
	 */
	public void depositBill ()
	{
		dollarBill++;
	}
	
	/**
	 * The <code>retrieveBill</code> method moves a dollar bill out of the BillBox.
	 */
	public void retrieveBill ()
	{
		dollarBill--;
	}
	
	/**
	 * The <code>cashValue</code> method returns the amount of money in the BillBox 
	 * in cash value.
	 */
	public int cashValue () {
		return dollarBill*100;
	}
}

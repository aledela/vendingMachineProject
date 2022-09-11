package vend;
/**
 * Vending Machine Homework Assignment
 * Prompts -- used for methods of different user prompts
 * 
 * @author Anonymous for grading purposes
 * 
 * @version October 14, 2018
 * 
 *          An object of the <code>Prompts</code> does not contain anything, used for the methods.
 */
public class Prompts {

	/**
	 * The <code>Prompts</code> constructor does not initialize any variables.
	 */
	public Prompts()
	{
		;
	}
	
	/**
	 * The <code>DepositPrompt</code> method outputs as side effect the prompt used for deposit input.
	 */
	public void DepositPrompt() {
		System.out.println("Enter \"Price\" to know the price of the sodas");
		System.out.println(
				"Enter one of the following : \"quarter\", \"dime\", \"nickel\" to insert the corresponding coin");
		System.out.println("Enter \"dollar\" to enter a dollar bill, only if Exact Change Light is on");
		System.out.println("Enter \"Lever\" to end all transaction");
		System.out.println("Enter \"Vend\" to end all transaction \n");
	}

	/**
	 * The <code>ChoicePrompt</code> method outputs as side effect the prompt used for choosing a soda input.
	 */
	public void ChoicePrompt() {
		System.out.println("Please enter one of the following choices for soda:");
		System.out.println("Pepsi, Mountain Dew, Coca Cola, Seven Up, Fanta, Sprite, Doctor Pepper, or Sierra Mist");
	}
}

/**
 * This class represents a single Die which can be rolled.
 * @author martin
 *
 */
public class Die {

	protected int value; // The value of the die.
	
	/**
	 * Constructor for die. If not parameter is passed, it's rolled.
	 * @throws InterruptedException 
	 */
	public Die() {
		roll();
	}
	
	/**
	 * Constructor for die. Allows assignment of the die to an initial value.
	 * @param value The value of the die.
	 * @throws InterruptedException 
	 */
	public Die(int value) throws IllegalArgumentException {
		
		try {
			if(value < 1 || value > 6)
				throw new IllegalArgumentException("Die value must be between 1 and 6.");
			this.value = value;
		}
		catch(Exception e) {
			System.out.println("Die value must be between 1 and 6. Die have been assigned a random value.");
			this.roll();
		}
		
	}
	
	/**
	 * Represents a roll of the die. Randomly assigns a value to the
	 * die between 1 and 6.
	 * @throws InterruptedException 
	 */
	public void roll() {		
		value = (int) (1 + Math.random() * 6);		
	}
	
	/**
	 * Gets the value of the die.
	 * @return The value.
	 */
	public int getValue() {
		return value;
	}
	
}


public class TestDie {

	private static Die die1;
	private static Die die2;
	
	public static void main(String[] args) {
			
		die1 = new Die();
		die2 = new Die();

		for(int i = 0; i < 100; i++) {
		
			System.out.println("Die 1 roll: " + die1.getValue());
			System.out.println("Die 2 roll: " + die2.getValue());
		
			die1.roll();
			die2.roll();
			
		}
		
	}

}

import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {
	private int count = 0;
	/** play the game. */
	public void play(NumberGame game) {

		boolean correct = false;

		// describe the game
		System.out.println( game.toString() );

		// This is just an example.
		System.out.println( game.getMessage() );
		/**
		 * keep ask then show hint until correct
		 */
		while (!correct){
			Scanner console = new Scanner(System.in);
			System.out.print("Your answer? ");
			int guess = console.nextInt();
			correct = game.guess(guess);
			System.out.println( game.getMessage() );
			
		}
		/**
		 * show total count
		 */
		System.out.println("Counter " + game.getCounter());

	}


}
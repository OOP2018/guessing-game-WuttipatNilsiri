/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new GuessingGame(upperBound);
		GameConsole ui = new GameConsole( );
		GameSolver AI = new GameSolver();
		GameSolver_Recursive HIE = new GameSolver_Recursive();
		HIE.play(game);
		AI.play(game);
		
		//TODO display the answer returned by play
		
		//TODO display how many guesses the user made
	}
}

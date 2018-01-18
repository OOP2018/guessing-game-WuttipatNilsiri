/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = Integer.MAX_VALUE;
		NumberGame game = new WutGame(upperBound);
		GameConsole ui = new GameConsole( );
		GameSolver AI = new GameSolver();
		GameSolver_Rercur AI2 = new GameSolver_Rercur();
		AI2.play(game);
		AI.play(game);
		ui.play(game);
		//TODO display the answer returned by play
		
		//TODO display how many guesses the user made
	}
}

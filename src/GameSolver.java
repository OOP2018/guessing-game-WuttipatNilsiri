
/**
 * class that contain Algolithm for Solve guessing game
 * @author ARZ
 *
 */
public class GameSolver {
	/**
	 * let AI play game
	 * @param game
	 * @return true Answer
	 */
	public int play(NumberGame game){
		// make it easy to test
		System.out.println("True Ans is " + game.getTrueAnswer());
		System.out.println("----------------------------------");
		// init max 
		int max = game.getUpperBound();
		// init min
		int min = 1;
		// init answer
		int trueAns = 0;
		// keep random by re-arrage the range 
		while(true){
			int range = (max - min) + 1; 
			int solvedNumber = (int)((Math.random() * range) + min);
			System.out.println(solvedNumber);
			game.guess(solvedNumber);
			String hint = game.getMessage();
			if (hint.contains("big") || hint.contains("large")){
				max = solvedNumber;
			}
			else if (hint.contains("small") || hint.contains("low")){
				min = solvedNumber;
			}
			else if (hint.contains("correct") || hint.contains("right")){
				trueAns = solvedNumber;
				System.out.println("i got it !");
				break;
			}
		}
		return trueAns;
	}
}

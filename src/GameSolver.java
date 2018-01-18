
/**
 * class that contain Algolithm for Solve guessing game
 * @author wuttipat nilsiri
 *
 */
public class GameSolver {
	/**
	 * let AI play game
	 * @param game
	 * @return true Answer
	 */
	private int count = 0;
	public int play(NumberGame game){
		System.out.println("----------------------------------");
		// make it easy to test
		System.out.println("random solve");
		System.out.println("True Ans is " + game.getTrueAnswer());
		System.out.println("----------------------------------");
		// init max 
		int max = game.getUpperBound();
		// init min
		int min = 1;
		// init answer
		int trueAns = 0;
		// keep random by	 re-arrage the range 
		boolean isCorrect = false;
		while(!isCorrect){
			int range = (max - min) + 1; 
			int solvedNumber = (int)((Math.random() * range) + min);
			count++;
			System.out.println(count+" : "+solvedNumber);
			isCorrect = game.guess(solvedNumber);
			String hint = game.getMessage();
			if (hint.contains("too big") || hint.contains("large")){
				max = solvedNumber - 1;
			}
			else if (hint.contains("too small") || hint.contains("low")){
				min = solvedNumber + 1;
			}
			else if (hint.contains("correct") || hint.contains("right")){
				trueAns = solvedNumber;
				System.out.println("i got it !");
			}
		}
		System.out.println("total : "+count);
		return trueAns;
	}
}

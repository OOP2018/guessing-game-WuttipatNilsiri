
/**
 * class that contain Algolithm for Solve guessing game
 * @author ARZ
 *
 */
public class GameSolver_Recursive {
	/**
	 * let AI play game
	 * @param gg
	 */
	public void play(NumberGame gg){
		System.out.println("True Ans is " + gg.getTrueAnswer());
		System.out.println("----------------------------------");
		int max = gg.getUpperBound();
		int min = 1;
		int initSolvedNumber = (int) Math.floor( (max + min)/2 );
		int ans = solveAlgolithm(gg,initSolvedNumber,max,min,'N');
		System.out.println("i got ");
		System.out.println(ans);
		
	}
	/**
	 * solver Algolithm recursively by re-setting the sign and max || min 
	 * @param gg
	 * @param solvedNumber
	 * @param max
	 * @param min
	 * @param sign
	 * @return solvedNumber
	 */
	public int solveAlgolithm(NumberGame gg,int solvedNumber, int max, int min,char sign){
		//new guessing Number condition
		// B is too big, S is  too small, N is Not correct, C is correct 
		if (sign == 'B' || sign == 'N') {
			solvedNumber = (int) Math.floor( (max + min)/2 );
		}
		if (sign == 'S' || sign == 'N') {
			solvedNumber = (int) Math.ceil( (max + min)/2 );
		}
		if (sign == 'C') {
			return solvedNumber;
		}
		System.out.println(solvedNumber);
		//let it guess
		gg.guess(solvedNumber);
		String hint = gg.getMessage();
		//re-setting max min condition
		if (hint.contains("big") || hint.contains("large")){
			sign = 'B';
			max = solvedNumber;
		}
		else if (hint.contains("small") || hint.contains("low")){
			sign = 'S';
			min = solvedNumber;
		}
		else if (hint.contains("correct") || hint.contains("right")){
			sign = 'C';
		}
		return solveAlgolithm(gg,solvedNumber,max,min,sign);	
	}

}

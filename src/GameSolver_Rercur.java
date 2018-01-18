/**
 * Game Solver Algolithm with recursion 
 * @author Wuttipat Nilsiri
 *
 */
public class GameSolver_Rercur {
	/**
	 * let AI play with this Algolithm 
	 * @param game : NumberGame
	 */
	public void play (NumberGame game){
		System.out.println("True Ans is " + game.getTrueAnswer());
		System.out.println("----------------------------------");
		int ans = solve(game, game.getUpperBound(), 1);
		System.out.println(ans);
	}
	/**
	 * Solver Algolithm recursion
	 * @param game : NumberGame
	 * @param max : int
	 * @param ans : int
	 * @return ans : int
	 */
	public int solve(NumberGame game,int max , int ans){
	System.out.println(ans);
	//let AI that ans value
	game.guess(ans);
	if (game.getMessage().contains("small") || game.getMessage().contains("low")){
		//when max and min differ only 1 so it need to plus 1 to guess higher one  
		if ( (max - ans) == 1 ){
				System.out.println(ans+1);
				game.guess(ans+1);
				return ans+1;
			}
		//if not correct + half of ans and max
		else return solve(game,max, ans + (max - ans)/2);
	}
	else
		if (game.getMessage().contains("big") || game.getMessage().contains("large")){
			//forgot the ans by -1 
			return solve(game,ans-1 , ans/2);
		}
	return ans;
	}
	
}

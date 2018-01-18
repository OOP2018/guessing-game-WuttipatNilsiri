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
	//own count
	private int count = 0;
	public void play (NumberGame game){
		System.out.println("----------------------------------");
		System.out.println("O(logn) sovler");
		System.out.println("True Ans is " + game.getTrueAnswer());
		System.out.println("----------------------------------");
		int max = game.getUpperBound();
		int min = 1;
		int ans = min + (max-min)/2;
		ans = solve(game, game.getUpperBound(),1, ans);
		System.out.println(ans);
		System.out.println("total : " +count);
	}
	/**
	 * Solver Algolithm recursion
	 * @param game : NumberGame
	 * @param max : int
	 * @param ans : int
	 * @return ans : int
	 */
	public int solve(NumberGame game,int max,int min, int ans){
	count++;
	System.out.println(count+" : "+ans);
	//let AI that ans value
	game.guess(ans);
	//terminate condition
	if (game.getMessage().contains("correct") || game.getMessage().contains("right")){
		return ans;
	}
	else if (game.getMessage().contains("small") || game.getMessage().contains("low")){
		//SPcase when max and min differ only 1 so it need to plus 1 to guess higher one  
		if ( (max - ans) == 1 ){
				System.out.println(ans+1);
				game.guess(ans+1);
				return ans+1;
			}
		min = ans + 1;	//forgot the ans by +1 as min	
	}
	else if (game.getMessage().contains("big") || game.getMessage().contains("large")){
		max = ans - 1;	//forgot the ans by -1 as max
	}
	
	ans = min + (max-min)/2;
	return solve(game,max,min,ans);
		
	
	}
	
}

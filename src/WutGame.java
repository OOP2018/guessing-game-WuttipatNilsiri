
import java.math.*;
/**
 * Guessing Game that random one number which input that upperbound and let user solve
 * @author wuttipat nilsiri
 *
 */
public class WutGame extends NumberGame{
	/** upper bound for secret number */
    private int max;
    /** the solution to the game */
    private int secret;
	/** hint for user to guess next */
	private String hint;
	/** user  answer */
	private int ans;
	/** minimum value for guessing game */
	private int min = 1;
	/** counter of guessing */
	private int counter = 0;
	/**
	 * initial GuessingGame with upperbound number 
	 * @param max : upperbound of guessing game
	 */
	public WutGame(int max){
		AnalyseMaxMin(max,min);
		int range = (this.max - this.min) + 1;     
		this.secret = (int)((Math.random() * range) + min);
		hint = "It's between "+ (int) this.max + " and " + (int) this.min;
	}
	/**
	 * to know random Number that is true answer of game
	 * @return secret
	 */
	public int getRandomnum(){
		return secret;
	}
	/**
	 * let user know hint for answer next
	 * @return hint 
	 */
	public String getMessage(){
		return hint;
	}
	/**
	 * check what answer is secret number or not
	 * @return true or false
	 */
	public Boolean isCorrect(){
		return ans == secret;
	}
	/**
	 * to know upperbound of guessing game
	 * @return max
	 */
	public int getUpperBound() {
		return max;
	}
	/**
	 * check whatever answer higher or lower than secret
	 */
	public void setHint(){
		
		if (ans > secret){
			hint = "too big";
			if (ans > max) hint = "Out of Bound";
		}else if (ans < secret){
			hint = "too small";
			if (ans < min) hint = "Out of Bound low";
		}else 
			hint = "correct";	
	}
	/**
	 * set answer that come from user
	 * @param ans
	 */
	
	public boolean guess(int ans){
		this.ans = ans;
		setHint();
		counter++;
		return isCorrect();
		
	}
	/**
     *  to know count that user guess
     * @return counter Number of guess
     */
	public int getCount(){
		return counter;
	}
	
	public String toString(){
		return this.getClass().getSimpleName();
	}
	/**
	 * to know secret
	 */
	public int getTrueAnswer(){
		return secret;
	}
	
	/**
	 * AnalyseMaxMin algolithm whatever x or y is higher
	 */
	public void AnalyseMaxMin(int x,int y){
		if (x >= y){
			max = x;
			min = y;
		}else if(x < y){
			max = y;
			min = x;
		}
	}
	
	

}
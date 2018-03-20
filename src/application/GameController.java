package application;


import Game.NumberGame;
import Game.WutGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
public class GameController {
	@FXML
	TextField input;
	@FXML
	Label hint;
	
	Boolean correct = false;
	
	int upperBound = 100;
	NumberGame game = new WutGame(upperBound);
	
	CountView cview = new CountView(game);
	AnswerView aview = new AnswerView(game);
	
	@FXML
	public void initialize() {
		// This is for testing
		System.out.println("Running initialize");
		hint.setText(game.getMessage());
		hint.setAlignment(Pos.CENTER);
		cview.run();
		aview.run();
		
	}
	
	public void summitAnswer(){
		int guess = Integer.parseInt(input.getText());
		correct = game.guess(guess);
		String message = game.getMessage();
		hint.setText(message);
		input.setText("");
	}
	
	public void handleKey(KeyEvent ke){
		if (ke.getCode().equals(KeyCode.ENTER)){
			summitAnswer();
		}
		if (ke.getCode().equals(KeyCode.ESCAPE)){
			System.exit(0);
		}
	}
}

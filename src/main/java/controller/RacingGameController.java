package controller;

import java.util.List;

import domain.CarNamesInput;
import domain.RacingGame;
import domain.TryCountInput;
import view.InputView;
import view.MessageView;

public class RacingGameController {
	private final MessageView messageView = new MessageView();
	private final InputView inputView = new InputView();

	public void startGame() {
		RacingGame racingGame = new RacingGame(initCarNameData());

		setTryCount();
	}

	public List<String> initCarNameData() {
		messageView.printCarNameMessage();
		String inputCarNames = inputView.inputCarNames();

		CarNamesInput carNamesInput = new CarNamesInput(inputCarNames);
		return carNamesInput.getNames();
	}

	public void setTryCount() {
		messageView.printTryCountMessage();
	}
}

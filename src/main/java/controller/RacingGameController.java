package controller;

import domain.CarNamesInput;
import domain.TryCountInput;
import view.InputView;
import view.MessageView;

public class RacingGameController {
	private final MessageView messageView = new MessageView();
	private final InputView inputView = new InputView();

	public void startGame() {
		CarNamesInput carNamesInput = initCarNameData();
		TryCountInput tryCountInput = setTryCount();

	}

	public void startRace(CarNamesInput carNamesInput, TryCountInput tryCountInput) {

	}

	public CarNamesInput initCarNameData() {
		messageView.printCarNameMessage();
		String inputCarNames = inputView.inputCarNames();
		return new CarNamesInput(inputCarNames);
	}

	public TryCountInput setTryCount() {
		messageView.printTryCountMessage();

		String inputTryCount = inputView.inputTryCount();
		return new TryCountInput(inputTryCount);
	}
}

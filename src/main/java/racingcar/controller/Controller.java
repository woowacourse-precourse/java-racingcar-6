package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;

public class Controller {

	private final InputView inputView = new InputView();
	private Race race;

	public void run() {
		initRace();
	}

	private void initRace() {
		String[] carNames = inputView.getCarsName();
		race = new Race(carNames);
	}
}
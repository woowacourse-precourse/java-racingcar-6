package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;

public class Controller {

	private final InputView inputView = new InputView();
	private Race race;

	public void run() {
		initRace();

		startRace();
	}

	private void initRace() {
		String[] carNames = inputView.getCarsName();
		race = new Race(carNames);
	}

	private void startRace() {
		int rounds = inputView.getNumberOfAttempts();

		for (int i = 0; i < rounds; i++) {
			race.run();

			printResult();
		}
	}

	private void printResult() {
		// TODO : 기능구현 예정
	}
}
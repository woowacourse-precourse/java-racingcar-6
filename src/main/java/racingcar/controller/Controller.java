package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Controller {

	private static final String RESULT_MESSAGE = "실행 결과";

	private final InputView inputView = new InputView();
	private final ResultView resultView = new ResultView();
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
		System.out.println(RESULT_MESSAGE);

		for (int i = 0; i < rounds; i++) {
			race.run();

			resultView.getResult(race);
		}
	}
}
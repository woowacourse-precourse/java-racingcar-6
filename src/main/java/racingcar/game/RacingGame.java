package racingcar.game;

import java.util.List;

import racingcar.domain.RacingCarManager;
import racingcar.ui.GameUI;

public class RacingGame {
	private final RacingCarManager racingCarManager;
	private final GameUI ui;

	public RacingGame(GameUI ui) {
		this.racingCarManager = new RacingCarManager();
		this.ui = ui;
	}

	public void run() {
		String[] carNames = ui.inputCarNames();
		racingCarManager.createCars(carNames);
		int repeat = ui.inputRepeat();
		racing(repeat);
		List<String> winners = racingCarManager.findWinner();
		ui.printResult(winners);
	}

	public void racing(int repeat) {
		for (int i = 0; i < repeat; i++) {
			racingCarManager.moveCars();
			ui.printHistory(racingCarManager.getPositionHistory());
			ui.enter();
		}
	}
}

package racingcar;

import java.util.List;

public class RacingGame {
	private final CarManger carManger;
	private final GameUI ui;

	public RacingGame(GameUI ui) {
		this.carManger = new CarManger();
		this.ui = ui;
	}

	public void run() {
		String[] carNames = ui.inputCarNames();
		carManger.createCars(carNames);
		int repeat = ui.inputRepeat();
		racing(repeat);
		List<String> winners = carManger.findWinner();
		ui.printResult(winners);
	}

	public void racing(int repeat) {
		for (int i = 0; i < repeat; i++) {
			carManger.moveCars();
			ui.printHistory(carManger.getPositionHistory());
			ui.enter();
		}
	}
}

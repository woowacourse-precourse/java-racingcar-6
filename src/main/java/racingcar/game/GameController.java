package racingcar.game;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private GameController() {
	}

	public static void start() {
		RacingGame racingGame = new RacingGame(InputView.readNames());

		racingGame.progressGame(InputView.readTurnCount());

		OutputView.printResultHeader();
		OutputView.printWinners(racingGame.getWinners());
	}
}

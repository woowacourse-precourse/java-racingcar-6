package racingcar.game;

import java.util.List;

import racingcar.domain.Car;
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

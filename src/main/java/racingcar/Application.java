package racingcar;

import racingcar.game.RacingGame;
import racingcar.provider.RacingInputProvider;
import racingcar.provider.RacingOutputProvider;
import racingcar.service.RacingService;

public class Application {
	public static void main(String[] args) {

		RacingInputProvider racingInputProvider = new RacingInputProvider();
		RacingOutputProvider racingOutputProvider = new RacingOutputProvider();
		RacingService racingService = new RacingService();

		RacingGame racingGame = new RacingGame(racingInputProvider, racingOutputProvider, racingService);
		racingGame.start();
	}
}

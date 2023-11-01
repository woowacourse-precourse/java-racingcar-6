package racingcar.game;

import java.util.List;

import racingcar.domain.Car;
import racingcar.provider.RacingInputProvider;
import racingcar.provider.RacingOutputProvider;
import racingcar.service.RacingService;

public class RacingGame {

	private static final int MAX_CAR_NAME_LENGTH = 5;

	private final RacingInputProvider racingInputProvider;
	private final RacingOutputProvider racingOutputProvider;
	private final RacingService racingService;

	public RacingGame(RacingInputProvider racingInputProvider,
		RacingOutputProvider racingOutputProvider,
		RacingService racingService) {
		this.racingInputProvider = racingInputProvider;
		this.racingOutputProvider = racingOutputProvider;
		this.racingService = racingService;
	}

	public void start() {
		List<Car> racingCars = racingInputProvider.getRacingCars();
		int tryCount = racingInputProvider.getInputTryCount();

		racingOutputProvider.printRacingStart();
		for (int i = 0; i < tryCount; i++) {
			racingService.racing(racingCars);
			racingOutputProvider.printRacing(racingCars);
		}

		List<Car> winners = racingService.getWinners(racingCars);
		racingOutputProvider.printWinners(winners);
	}

}

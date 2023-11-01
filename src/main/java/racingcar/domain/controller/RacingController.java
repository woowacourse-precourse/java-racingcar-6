package racingcar.domain.controller;

import static racingcar.global.utils.constant.OutputType.EMPTY;
import static racingcar.global.utils.constant.OutputType.OUTPUT_CARS_NAME;
import static racingcar.global.utils.constant.OutputType.OUTPUT_NUMBER_OF_ATTEMPTS;
import static racingcar.global.utils.constant.OutputType.OUTPUT_RESULT;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarList;
import racingcar.domain.RacingCarManager;
import racingcar.domain.service.ClientService;
import racingcar.domain.service.RacingService;
import racingcar.global.utils.console.ConsoleUtil;

public class RacingController {

	private final ClientService clientService;
	private final RacingService racingService;

	public RacingController(ClientService clientService, RacingService racingService) {
		this.clientService = clientService;
		this.racingService = racingService;
	}

	public void run() {
		List<RacingCar> racingCars = getCars();
		int numberOfAttempt = getNumberOfAttempt();
		RacingCarManager racingCarManager = new RacingCarManager(numberOfAttempt, new RacingCarList(racingCars));
		racingService.startRacing(racingCarManager);
		ConsoleUtil.outputWinners(racingCarManager.getWinnersName());
	}

	private int getNumberOfAttempt() {
		ConsoleUtil.commonOutputLine(OUTPUT_NUMBER_OF_ATTEMPTS.getComment());
		int numberOfAttempt = clientService.getNumberOfAttempt();
		ConsoleUtil.commonOutputLine(EMPTY.getComment() + OUTPUT_RESULT.getComment());
		return numberOfAttempt;
	}

	private List<RacingCar> getCars() {
		ConsoleUtil.commonOutputLine(OUTPUT_CARS_NAME.getComment());
		List<String> carsName = clientService.getCarsName();
		return carsName.stream()
				.map(RacingCar::new)
				.toList();
	}
}

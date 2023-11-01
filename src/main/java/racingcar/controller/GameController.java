package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Lap;
import racingcar.model.RaceStatus;
import racingcar.model.RacingCar;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.Collectors;

public class GameController {
	private final InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private Lap lap;

	private void gameStart() {
		Cars cars = new Cars(inputView.inputCarName().stream()
				.map(carName -> new RacingCar(carName))
				.collect(Collectors.toList()));

		Round round = new Round(inputView.inputRoundNumber());
		lap = new Lap(cars, round);
	}

	private void runLap() {
		outputView.printGameStartMessage();
		while (!lap.isGameEnd()) {
			RaceStatus raceStatus = lap.getRaceStatus();
			outputView.printLapStatus(raceStatus);
		}
	}

	private void pickWinner() {
		outputView.printWinner(lap.getWinner());
	}

	public void initGame() {
		gameStart();
		runLap();
		pickWinner();
	}
}

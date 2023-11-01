package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.*;

import java.util.ArrayList;
import java.util.List;

import racingcar.controller.*;

public class GameController {

	private Input input = new Input();
	private Output output = new Output();
	private DetermineNameController determineNameController = new DetermineNameController();
	private CarMovementController carMovementController = new CarMovementController();
	private SelectWinnerController selectWinnerController = new SelectWinnerController();

	public void start() {
		Car[] cars = createCars();
		roundProceed(cars);
		winnerProceed(cars);
	}

	private Car[] createCars() {
		String[] carNames = determineNameController.isPossibleName(input.carNames());
		Car[] cars = new Car[carNames.length];
		for (int i = 0; i < carNames.length; i++) {
			cars[i] = new Car(carNames[i]);
		}
		return cars;
	}

	private void roundProceed(Car[] cars) {
		int round = input.rounds();
		output.resultMessage();
		for (int i = 0; i < round; i++) {
			carMovementController.forward(cars);
			output.roundResult(cars);
		}
	}

	private void winnerProceed(Car[] cars) {
		List<Car> winnerCars = selectWinnerController.resultCars(cars);
		output.winner(winnerCars);
	}
}

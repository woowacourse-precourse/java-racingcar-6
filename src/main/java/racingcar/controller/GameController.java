package racingcar.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.CommonSymbol;
import racingcar.constant.GameConfig;
import racingcar.model.Car;
import racingcar.validation.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

	public GameController() {
	}

	public void startGame() {
		List<Car> cars = createCars(readCarNames());
		int attemptCount = readAttemptCount();

		OutputView.printExecutionResultMessage();
		for (int i = 0; i < attemptCount; i++) {
			moveAllCarsForward(cars);
			displayAllCarsPosition(cars);
		}

		List<Car> winners = findWinners(cars);
		displayWinnerNames(winners);
	}

	private List<Car> findWinners(List<Car> cars) {
		List<Car> sortedCars = sortCarsByPosition(cars);
		int maxPosition = sortedCars.get(0).getPosition();

		return sortedCars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.collect(Collectors.toList());
	}

	private void displayWinnerNames(List<Car> winners) {
		OutputView.printWinner(winners.stream()
			.map(Car::getName)
			.collect(Collectors.toList()));
	}

	private List<Car> sortCarsByPosition(List<Car> cars) {
		return cars.stream()
			.sorted(Comparator.comparingInt(Car::getPosition).reversed())
			.collect(Collectors.toList());
	}

	private void displayAllCarsPosition(List<Car> cars) {
		for (Car car : cars) {
			OutputView.printCarPosition(car.getName(), car.getPosition());
		}

		OutputView.printNewLine();
	}

	private void moveAllCarsForward(List<Car> cars) {
		for (Car car : cars) {
			moveForward(car);
		}
	}

	private void moveForward(Car car) {
		int randomValue = Randoms.pickNumberInRange(GameConfig.RANDOM_MINIMUM_RANGE, GameConfig.RANDOM_MAXIMUM_RANGE);

		if (randomValue >= GameConfig.MINIMUM_NUMBER_FOR_FORWARD) {
			car.forward();
		}
	}

	private int readAttemptCount() {
		String inputCount = InputView.readAttemptCount();

		InputValidator.validateNumericInput(inputCount);

		return Integer.parseInt(inputCount);
	}

	private List<Car> createCars(List<String> names) {
		return names.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	private List<String> readCarNames() {
		String inputNames = InputView.readCarNames();

		return Arrays.stream(inputNames.split(CommonSymbol.SYMBOL_COMMA))
			.peek(InputValidator::validateInputNameLength)
			.collect(Collectors.toList());
	}
}

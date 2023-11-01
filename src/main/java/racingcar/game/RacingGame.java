package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.domain.Car;
import racingcar.view.OutputView;

public class RacingGame {
	public static final int SCORE_LIMIT = 4;
	private final List<Car> cars;

	public RacingGame(List<String> names) {
		cars = initialize(names);
	}

	private List<Car> initialize(List<String> names) {
		List<Car> cars = new ArrayList<>();
		names.forEach(name -> cars.add(Car.from(name)));
		return cars;
	}

	public void progressGame(int turn) {
		validateTurn(turn);
		IntStream.range(0, turn).forEach(i -> progressTurn());
	}

	private void validateTurn(int turn) {
		if (turn < 0) {
			throw new IllegalArgumentException("올바른 turn 값이 아닙니다.");
		}
	}

	private void progressTurn() {
		cars.stream()
			.filter(car -> availableMove(Dice.throwDice()))
			.forEach(Car::move);

		OutputView.printTurnUserResult(cars);
	}

	private boolean availableMove(int diceNumber) {
		return diceNumber >= SCORE_LIMIT;
	}

	public List<Car> getWinners() {
		int maxDistance = getMaxDistance();

		return cars.stream()
			.filter(car -> car.getDistance() == maxDistance)
			.collect(Collectors.toList());
	}

	private int getMaxDistance() {
		return cars.stream()
			.mapToInt(Car::getDistance)
			.max()
			.orElse(0);
	}
}

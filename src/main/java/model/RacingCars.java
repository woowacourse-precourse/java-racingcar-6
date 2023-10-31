package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import view.OutputView;

public class RacingCars {
	private final List<Car> cars = new ArrayList<>();

	public RacingCars(List<String> carNames) {
		carNames.forEach(car -> cars.add(new Car(car)));
	}

	public void playRound() {
		moveCars();
		OutputView.printRoundResult(cars.stream()
				.map(Car::getRoundResult)
				.collect(Collectors.toList())
		);
	}

	public void showWinners() {
		GameResult finalResult = new GameResult(cars);
		OutputView.printWinner(finalResult.getWinnerNames());
	}

	private void moveCars() {
		cars.forEach(Car::move);
	}
}

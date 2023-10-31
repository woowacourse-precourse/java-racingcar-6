package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {
	private final InputView inputView;
	private final OutputView outputView;

	private int tryCount;
	private List<Car> cars;
	private List<String> names;

	public GameController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void run() {
		setupGame();
		executeGame();
	}

	private void setupGame() {
		String input = inputView.askCarName();
		Validator.validateCarCount(input);
		names = List.of(input.split(","));
		cars = setupCars(names);
		tryCount = Integer.parseInt(inputView.askTryCount());
	}

	private void executeGame() {
		final String DELIMITER = ", ";
		NumberGenerator numberGenerator = new NumberGenerator();
		Referee referee = new Referee();
		List<String> winner = new ArrayList<>();

		boolean printPrefix = true;
		for (int i = 0; i < tryCount; i++) {
			List<Integer> numbers = numberGenerator.generateRandomNumbers(cars.size());
			Map<String, Boolean> tryResult = referee.checkTryOutcome(names, numbers);
			Map<String, Integer> moveResult = moveCars(cars, tryResult);
			outputView.printGameResult(moveResult, printPrefix);
			printPrefix = false;

			int index = 1;
			if (tryCount - index == i) {
				winner = referee.checkWinner(moveResult);
			}
		}

		String winnerResult = String.join(DELIMITER, winner);
		outputView.printGameWinner(winnerResult);
	}

	private List<Car> setupCars(List<String> names) {
		List<Car> cars = new ArrayList<>(names.size());
		for (String name : names) {
			Car car = new Car(name);
			cars.add(car);
		}

		return cars;
	}

	private Map<String, Integer> moveCars(List<Car> cars, Map<String, Boolean> tryResult) {
		Map<String, Integer> moveResult = new HashMap<>();
		for (Car car : cars) {
			car.move(tryResult.get(car.getName()));
			moveResult.put(car.getName(), car.getStep());
		}

		return moveResult;
	}
}

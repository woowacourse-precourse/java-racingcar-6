package controller;

import java.util.List;

import domain.Car;
import domain.CarNamesInput;
import domain.RacingCar;
import domain.RandomNumberGenerator;
import domain.TryCountInput;
import view.InputView;
import view.MessageView;

public class RacingGameController {
	private final MessageView messageView = new MessageView();
	private final InputView inputView = new InputView();
	private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

	public void startGame() {
		CarNamesInput carNamesInput = initCarNameData();
		TryCountInput tryCountInput = setTryCount();

	}

	public void startRace(CarNamesInput carNamesInput, TryCountInput tryCountInput) {
		RacingCar racingCar = new RacingCar(carNamesInput.getNames());
		List<Car> cars = racingCar.getCars();
		movePerRounds(tryCountInput, cars);
	}

	public void movePerRounds(TryCountInput tryCountInput, List<Car> cars) {
		for (int count = 0; count < tryCountInput.getTryCount(); count++) {
			moveForRound(cars);
		}
	}

	public void moveForRound(List<Car> cars) {
		for (Car car : cars) {
			car.moveByNumber(randomNumberGenerator.generateNumber());
		}
	}

	public CarNamesInput initCarNameData() {
		messageView.printCarNameMessage();
		String inputCarNames = inputView.inputCarNames();
		return new CarNamesInput(inputCarNames);
	}

	public TryCountInput setTryCount() {
		messageView.printTryCountMessage();

		String inputTryCount = inputView.inputTryCount();
		return new TryCountInput(inputTryCount);
	}
}

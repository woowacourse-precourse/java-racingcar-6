package controller;

import domain.Car;
import domain.CarNamesInput;
import domain.RacingCar;
import domain.RandomNumberGenerator;
import domain.TryCountInput;
import domain.Winners;
import view.InputView;
import view.MessageView;
import view.OutputView;

public class RacingGameController {
	private final MessageView messageView = new MessageView();
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

	public void runGame() {
		CarNamesInput carNamesInput = initCarNameData();
		TryCountInput tryCountInput = setTryCount();

		RacingCar raceOutcome = getRaceOutcome(carNamesInput, tryCountInput);

		awardWinners(raceOutcome);
	}

	public RacingCar getRaceOutcome(CarNamesInput carNamesInput, TryCountInput tryCountInput) {
		RacingCar racingCar = new RacingCar(carNamesInput.getNames());
		movePerRounds(tryCountInput, racingCar);

		return racingCar;
	}

	public void movePerRounds(TryCountInput tryCountInput, RacingCar racingCar) {
		for (int count = 0; count < tryCountInput.getTryCount(); count++) {
			moveForRound(racingCar);
		}
	}

	public void moveForRound(RacingCar racingCar) {
		for (Car car : racingCar.getCars()) {
			car.moveByNumber(randomNumberGenerator.generateNumber());
			outputView.printRacingCarStatus(car);
		}
		messageView.printEmptyLine();
	}

	private void awardWinners(RacingCar raceOutcome) {
		Winners winners = new Winners(raceOutcome.getWinners());
		receiveAward(winners);
	}

	private void receiveAward(Winners winners) {
		messageView.printAwardMessage();

		outputView.printAwardWinner(winners);
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

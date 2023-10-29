package racingcar.Controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.Car;
import racingcar.Model.CarListService;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class GameController {
	CarListService carListService = new CarListService();

	public void playGame() {

		List<Car> carList = inputCarList();
		int attemptCount = inputAttemptCount();

		OutputView.printResult();

		conductRound(attemptCount, carList);

		String winnerList = carListService.findWinner();

		OutputView.printWinner(winnerList);

	}

	private List<Car> inputCarList() {

		InputView.printCarList();
		String enteredCarList = Console.readLine();

		return carListService.make(enteredCarList);
	}

	private int inputAttemptCount() {

		InputView.printAttemptCount();
		String inputAttemptCount = Console.readLine();

		validateAttemptCount(inputAttemptCount);
		return Integer.parseInt(inputAttemptCount);

	}

	private void validateAttemptCount(String inputAttemptCount) {
		boolean errorSign = false;

		try {
			Integer.parseInt(inputAttemptCount);
		} catch (IllegalArgumentException ill) {
			errorSign = true;
		}

		if (errorSign) {
			throw new IllegalArgumentException("숫자만 입력해주세요.");
		}
	}

	private void conductRound(int attemptCount, List<Car> carList) {

		for (int i = 0; i < attemptCount; i++) {

			carListService.move();
			OutputView.printEachRound(carList);

		}
	}

}

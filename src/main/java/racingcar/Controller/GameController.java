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

		System.out.println();
		OutputView.printResult();

		conductRound(attemptCount, carList);

		String winnerList = carListService.findWinner();

		OutputView.printWinner(winnerList);

	}

	private int inputAttemptCount() {

		InputView.printAttemptCount();
		String inputAttemptCount = Console.readLine();

		return Integer.parseInt(inputAttemptCount);

	}

	private void conductRound(int attemptCount, List<Car> carList) {

		for (int i = 0; i < attemptCount; i++) {

			carListService.moveCarList();
			OutputView.printEachRound(carList);

		}
	}

	private List<Car> inputCarList() {
		InputView.printCarList();
		String enteredCarList = Console.readLine();

		return carListService.makeCarList(enteredCarList);
	}

}

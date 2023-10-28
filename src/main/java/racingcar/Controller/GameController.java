package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.CarList;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class GameController {

	public void playGame() {

		CarList carList = CarListMaker.makeList();
		int attemptCount = inputAttemptCount();

		System.out.println();
		OutputView.printResult();

		conductRound(attemptCount, carList);

		String winnerList = carList.findWinner();

		OutputView.printWinner(winnerList);

	}

	private int inputAttemptCount() {

		InputView.printAttemptCount();
		String inputAttemptCount = Console.readLine();

		return Integer.parseInt(inputAttemptCount);

	}

	private void conductRound(int attemptCount, CarList carList) {

		for (int i = 0; i < attemptCount; i++) {

			carList.moveCarList();
			OutputView.printEachRound(carList);

		}
	}

}

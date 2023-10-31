package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.CarsService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	CarsService carsService = new CarsService();

	public void playGame() {

		String inputCars = inputCars();
		carsService.make(inputCars);

		int attemptCount = inputAttemptCount();

		OutputView.printResult();

		conductRound(attemptCount);

		String winnerList = carsService.findWinner();

		OutputView.printWinner(winnerList);

	}

	public String inputCars() {

		InputView.printCarList();
		return Console.readLine();
	}

	private int inputAttemptCount() {

		InputView.printAttemptCount();
		String inputAttemptCount = Console.readLine().trim();

		validateAttemptCount(inputAttemptCount);
		return Integer.parseInt(inputAttemptCount);

	}

	public void validateAttemptCount(String inputAttemptCount) {
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

	private void conductRound(int attemptCount) {

		for (int i = 0; i < attemptCount; i++) {

			List<Integer> randomNumbers = makeRandomNumbers(carsService.size());
			carsService.moveOrStop(randomNumbers);
			OutputView.printEachRound(carsService);

		}
	}

	private List<Integer> makeRandomNumbers(int carListSize) {

		final int MIN_NUMBER = 0;
		final int MAX_NUMBER = 9;

		List<Integer> randomNumbers = new ArrayList<>();

		for (int i = 0; i < carListSize; i++) {
			randomNumbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
		}

		return randomNumbers;
	}

}

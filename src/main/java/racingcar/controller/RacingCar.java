package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {


	public void startGame() {
		List<String> players = InputView.insertName();
		InputValidator.validatePlayers(players);

		String inputNumber = InputView.insertTryNumber();
		InputValidator.validateTryNumber(inputNumber);

		int tryNumber = Integer.parseInt(inputNumber);

		List<Integer> results = new ArrayList<>();

		for (int i = 0; i < players.size(); i++) {
			results.add(0);
		}
		OutputView.printResultsMessage();
		for (int i = 0; i < tryNumber; i++) {
			isDrive(players, results);
			OutputView.printCurrentRacingResults(players, results);
		}

		List<String> winners = new ArrayList<>();
		int winnerDistance = 0;
		for (Integer result : results) {
			if (winnerDistance < result) {
				winnerDistance = result;
			}
		}

		for (int i = 0; i < players.size(); i++) {
			if (results.get(i) == winnerDistance) {
				winners.add(players.get(i));
			}
		}
		OutputView.printFinalRacingResults(winners);
	}


	private void isDrive(List<String> players, List<Integer> results) {
		for (int i = 0; i < players.size(); i++) {
			int randomNumber = Randoms.pickNumberInRange(0, 9);
			if (randomNumber >= 4) {
				results.set(i, results.get(i) + 1);
			}
		}
	}
}

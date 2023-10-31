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
		String inputNumber = InputView.insertTryNumber();

		InputValidator.validatePlayers(players);
		InputValidator.validateTryNumber(inputNumber);
		int tryNumber = Integer.parseInt(inputNumber);

		List<Integer> results = setResults(players);
		OutputView.printFirstResultsMessage();

		for (int i = 0; i < tryNumber; i++) {
			isDrive(players, results);
			OutputView.printCurrentRacingResults(players, results);
		}

		int winnerDistance = getWinnerDistance(results);
		List<String> winners = getWinners(players, results, winnerDistance);

		OutputView.printFinalRacingResults(winners);
	}

	private List<Integer> setResults(List<String> players) {
		List<Integer> results = new ArrayList<>();
		for (int i = 0; i < players.size(); i++) {
			results.add(0);
		}
		return results;
	}

	private int getWinnerDistance(List<Integer> results) {
		int winnerDistance = 0;
		for (Integer result : results) {
			if (winnerDistance < result) {
				winnerDistance = result;
			}
		}
		return winnerDistance;
	}

	private List<String> getWinners(List<String> players, List<Integer> results, int winnerDistance) {
		List<String> winners = new ArrayList<>();
		for (int i = 0; i < players.size(); i++) {
			if (results.get(i) == winnerDistance) {
				winners.add(players.get(i));
			}
		}
		return winners;
	}


	private void isDrive(List<String> players, List<Integer> results) {
		for (int i = 0; i < players.size(); i++) {
			int randomNumber = randomNumberGenerate();
			if (randomNumber >= 4) {
				results.set(i, results.get(i) + 1);
			}
		}
	}

	private int randomNumberGenerate() {
		return Randoms.pickNumberInRange(0, 9);
	}
}

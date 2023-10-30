package racingcar;

import java.util.List;

public class OutputView {

	public void printGameResult(List<String> carName, List<Integer> step) {
		final String ONE_STEP = "-";
	}

	public void printGameWinner(String gameWinner) {
		final String WINNER_PREFIX = "최종 우승자 : ";
		System.out.println(WINNER_PREFIX + gameWinner);
	}
}

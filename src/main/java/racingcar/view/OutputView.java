package racingcar.view;

import java.util.List;

import racingcar.view.constant.OutputConstant;

public class OutputView {
	private final StringBuilder gameResult;

	public OutputView() {
		this.gameResult = new StringBuilder();
		gameResult.append(OutputConstant.GAME_RESULT.getRequestMessage());
	}

	public void printGameResult() {
		System.out.println(gameResult);
	}

	public void printWinner(List<String> cars) {
		System.out.println(String.join(OutputConstant.WINNER_DELIMITER.getRequestMessage(), cars));
	}
}

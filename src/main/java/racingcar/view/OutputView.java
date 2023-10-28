package racingcar.view;

import java.util.List;

import racingcar.domain.Car;
import racingcar.view.constant.OutputConstant;

public class OutputView {
	private final StringBuilder gameResult;

	public OutputView() {
		this.gameResult = new StringBuilder();
		gameResult.append(OutputConstant.GAME_RESULT.getRequestMessage());
	}

	public String getRoundResult(List<Car> cars) {
		StringBuilder roundResult = new StringBuilder();
		for (Car car : cars) {
			roundResult.append(car.getName()).append(OutputConstant.SEPERATOR.getRequestMessage());
			for (int count = 0; count < car.getForwardCount(); count++) {
				roundResult.append(OutputConstant.FORWARD_MARK.getRequestMessage());
			}
			roundResult.append("\n");
		}
		roundResult.append("\n");
		return roundResult.toString();
	}

	public void stackRoundResult(String roundResult) {
		gameResult.append(roundResult);
	}

	public void printGameResult() {
		System.out.println(gameResult);
	}

	public void printWinner(List<String> cars) {
		System.out.println(String.join(OutputConstant.WINNER_DELIMITER.getRequestMessage(), cars));
	}
}

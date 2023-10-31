package racingcar.view;

import static racingcar.view.constant.OutputConstant.*;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
	private final StringBuilder gameResult;

	public OutputView() {
		this.gameResult = new StringBuilder();
		gameResult.append(GAME_RESULT.getValue());
	}

	public String getRoundResult(List<Car> cars) {
		StringBuilder roundResult = new StringBuilder();
		for (Car car : cars) {
			roundResult.append(car.getName()).append(SEPERATOR.getValue());
			for (int count = 0; count < car.getForwardCount(); count++) {
				roundResult.append(FORWARD_MARK.getValue());
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
		System.out.print(gameResult);
	}

	public void printWinner(List<String> cars) {
		System.out.print(WINNER_RESULT.getValue() + String.join(WINNER_DELIMITER.getValue(), cars));
	}
}

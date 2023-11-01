package racingcar.view;

import static racingcar.utils.GameConstants.*;

import java.util.List;

public class OutputView {
	public static void printError(String message) {
		System.out.println(ERROR_OCCURED+ message);
	}

	public static void printGameResultMessage() {
		System.out.println(RACING_RESULT_MESSAGE);
	}

	public static void printCarName(String carName) {
		System.out.print(carName + " : ");
	}

	public static void printCarPosition(Integer position) {
		StringBuilder carPosition = new StringBuilder();
		for (int i = 0; i < position; i++) {
			carPosition.append("-");
		}
		System.out.println(carPosition);
	}

	public static void printNextLine() {
		System.out.println();
	}

	public static void printWinner(List<String> winnerNames) {
		StringBuilder resultMessage = new StringBuilder();
		resultMessage.append(WINNER_MESSAGE);
		for (int idx = 0; idx < winnerNames.size() - 1; idx++) {
			resultMessage.append(winnerNames.get(idx));
			resultMessage.append(", ");
		}
		resultMessage.append(winnerNames.get(winnerNames.size() - 1));
		System.out.println(resultMessage);
	}
}

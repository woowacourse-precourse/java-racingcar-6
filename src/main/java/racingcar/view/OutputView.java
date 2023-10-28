package racingcar.view;

import racingcar.util.Message;

public class OutputView {
	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printInputCarNameMessage() {
		printMessage(Message.INPUT_CAR_NAME_MESSAGE);
	}

	public static void printInputTryNumberMessage() {
		printMessage(Message.INPUT_TRY_NUMBER_MESSAGE);
	}

	public static void printGameStartMessage() {
		printMessage(Message.GAME_START_MESSAGE);
	}

	public static void printWinnerMessage(String winner) {
		printMessage(Message.WINNER_MESSAGE + winner);
	}
}

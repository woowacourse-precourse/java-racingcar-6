package view;


import java.util.List;
import racingcar.Constants;

public class OutputView {

	public static void printPlayMessage() {
		System.out.println(Constants.ROUND_RESULT);
	}

	public static void printRoundResult(List<String> roundResults) {
		roundResults.forEach(System.out::println);
		System.out.println();
	}

	public static void printWinner(List<String> winners) {
		System.out.println(Constants.WINNER_RESULT + String.join(Constants.DELIMITER_WINNER, winners));
	}
}

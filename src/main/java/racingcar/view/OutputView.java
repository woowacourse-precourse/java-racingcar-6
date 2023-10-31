package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String EMPTY_STRING = "";

    private OutputView() {

    }

    public static void printGameResult() {
        System.out.println(GAME_RESULT);
    }

    public static void printWinnersMessage() {
        System.out.print(WINNER_MESSAGE);
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners));
    }

    public static void printEmptyLine() {
        System.out.println(EMPTY_STRING);
    }
}

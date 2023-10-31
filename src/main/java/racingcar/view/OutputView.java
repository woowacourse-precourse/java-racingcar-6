package racingcar.view;

import racingcar.models.GameStatus;

import java.util.List;

public class OutputView {
    private final static String OUTPUT_RESULT_MESSAGE = "실행 결과";
    private final static String OUTPUT_WINNER_START_MESSAGE = "최종 우승자 : ";

    public static void printPerGameStatusesMessage(List<GameStatus> gameStatuses) {
        printEmptyLine();
        System.out.println(OUTPUT_RESULT_MESSAGE);
        gameStatuses.forEach(System.out::println);
    }

    public static void printGameWinnersMessage(List<String> winners) {
        System.out.println(OUTPUT_WINNER_START_MESSAGE + String.join(", ", winners));
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}

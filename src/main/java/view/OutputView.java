package view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_START_MESSAGE = "\n실행 결과";
    private static final String PRINT_SCORES = "%s : %s\n";
    private static final String WINNER_MESSAGE = "\n최종 우승자 : %s";
    private static final String REPEAT = "-";
    private static final String DELIMITER = ", ";

    public static void printInputNameMessage() {
        System.out.println(INPUT_NAME_MESSAGE);
    }

    public static void printInputTryCountMessage() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
    }

    public static void printResultStartMessage() {
        System.out.println(RESULT_START_MESSAGE);
    }

    public static void printScores(Map<String, Integer> scores) {
        scores.entrySet().forEach(entry ->
                System.out.printf(PRINT_SCORES, entry.getKey(), REPEAT.repeat(entry.getValue())));
    }

    public static void printWinnerMessage(List<String> winner) {
        System.out.printf(WINNER_MESSAGE, String.join(DELIMITER, winner));
    }
}

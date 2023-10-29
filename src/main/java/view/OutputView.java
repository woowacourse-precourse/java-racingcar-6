package view;

import java.util.Map;

public class OutputView {
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String PRINT_SCORES = "%s : %s\n";
    private static final String REPEAT = "-";

    public static void printInputCarName() {
        System.out.println(INPUT_NAME_MESSAGE);
    }

    public static void printInputTryCountMessage() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
    }

    public static void printScores(Map<String, Integer> scores) {
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.printf(PRINT_SCORES, entry.getKey(), REPEAT.repeat(entry.getValue()));
        }
    }
}

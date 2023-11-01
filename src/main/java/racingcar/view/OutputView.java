package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    private static final String DASH = "-";
    private static final String DELIMITER = ", ";
    private static final String INPUT_CAR_NAMES_MESSAGE ="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_GAME_TRY_COUNTS_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    private static StringBuilder stringBuilder;

    static void printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    static void printInputTryCountMessage() {
        System.out.println(INPUT_GAME_TRY_COUNTS_MESSAGE);
    }

    public static void printExecutionResultMessage() {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printExecutionResult(Map<String, Integer> carExecutionResult) {
        stringBuilder = new StringBuilder();

        for (Entry<String, Integer> entrySet : carExecutionResult.entrySet()) {
            stringBuilder.append(entrySet.getKey()).append(" : ");

            int idx = 0;
            while (idx < entrySet.getValue()) {
                stringBuilder.append(DASH);
                idx++;
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder);
    }

    public static void printFinalResult(List<String> winnerNames) {
        System.out.println(FINAL_WINNER_MESSAGE + joinCarNames(winnerNames));
    }

    private static String joinCarNames(List<String> carNames) {
        return String.join(DELIMITER, carNames);
    }
}

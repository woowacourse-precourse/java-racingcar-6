package racingcar.Console;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Output {

    private static StringBuilder stringBuilder;

    static void printInputCarNames() {
        System.out.println(Constants.INPUT_CAR_NAMES_MESSAGE);
    }

    static void printInputGameTryCounts() {
        System.out.println(Constants.INPUT_GAME_TRY_COUNTS_MESSAGE);
    }

    public static void printExecutionResultsMessage() {
        System.out.println(Constants.EXECUTION_RESULT_MESSAGE);
    }

    public static void printExecutionResult(HashMap<String, Integer> carExecutionResult) {
        stringBuilder = new StringBuilder();

        for (Entry<String, Integer> entrySet : carExecutionResult.entrySet()) {
            stringBuilder.append(entrySet.getKey()).append(" : ");

            int idx = 0;
            while (idx < entrySet.getValue()) {
                stringBuilder.append(Constants.MOVE);
                idx++;
            }
            stringBuilder.append('\n');
        }
        stringBuilder.append('\n');
        System.out.println(stringBuilder);
    }

    public static void printWinnerResult(List<String> winners) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.FINAL_WINNER_MESSAGE);

        int idx = 0;
        while (idx < winners.size()) {
            if (idx != 0) {
                stringBuilder.append(Constants.COMMAS).append(" ");
            }
            stringBuilder.append(winners.get(idx));
            idx++;
        }
        System.out.println(stringBuilder);
    }
}

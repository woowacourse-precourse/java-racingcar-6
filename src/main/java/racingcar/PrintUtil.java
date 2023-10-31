package racingcar;

import java.util.List;
import java.util.Map;

import static racingcar.MessageConst.*;

public class PrintUtil {
    private static StringBuilder sb = new StringBuilder();

    public static void printNameOfCarInputMsg() {
        System.out.println(NAMES_OF_CARS_INPUT_MESSAGE);
    }

    public static void printMoveCountInputMsg() {
        System.out.println(MOVE_COUNT_INPUT_MESSAGE);
    }

    public static void printResultMsg() {
        sb.append(LINE_BREAK).append(RESULT_MESSAGE).append(LINE_BREAK);
    }

    public static void printGameResultMsg(Map<String, String> raceScore) {
        raceScore.forEach((Key, Value) -> sb.append(Key).append(" : ").append(Value).append(LINE_BREAK));
        sb.append("\n");
    }

    public static void printWinnerMsg(Map<String, String> raceScore, List<String> winner) {
        sb.append(WINNER_MESSAGE);

        String winnerScore = raceScore.get(winner.get(0));
        sb.append(winner.get(0));
        for (int i = 1; i < winner.size(); i++) {
            if (winnerScore.equals(raceScore.get(winner.get(i)))) {
                sb.append(", ");
                sb.append(winner.get(i));
            }
        }
        System.out.print(sb);
    }

}

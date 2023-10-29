package racingcar;

import java.util.List;
import java.util.Map;

import static racingcar.MessageConst.*;

public class PrintUtil {

    public static void printNameOfCarInputMsg() {
        System.out.println(NAMES_OF_CARS_INPUT_MESSAGE);
    }

    public static void printMoveCountInputMsg() {
        System.out.println(MOVE_COUNT_INPUT_MESSAGE);
    }

    public static void printResultMsg() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public static void printGameResultMsg(Map<String, String> raceScore) {
        raceScore.forEach((Key, Value) -> System.out.println(Key + " : " + Value));
        System.out.println();
    }

    public static void printWinnerMsg(Map<String, String> raceScore, List<String> winner) {
        System.out.print(WINNER_MESSAGE);

        String winnerScore = raceScore.get(winner.get(0));
        System.out.print(winner.get(0));
        for (int i = 1; i < winner.size(); i++) {
            if (winnerScore.equals(raceScore.get(winner.get(i)))) {
                System.out.print(", ");
                System.out.print(winner.get(i));
            }
        }
    }

}

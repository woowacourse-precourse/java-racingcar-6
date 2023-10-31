package racingcar;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static racingcar.MessageConst.*;

public class PrintUtil {
    private static StringBuilder finalWinner, gameResult;

    public static void printNameOfCarInputMsg() {
        System.out.println(NAMES_OF_CARS_INPUT_MESSAGE);
    }

    public static void printMoveCountInputMsg() {
        System.out.println(MOVE_COUNT_INPUT_MESSAGE);
    }

    public static void printResultMsg() {
        gameResult = new StringBuilder();
        gameResult.append(LINE_BREAK).append(RESULT_MESSAGE).append(LINE_BREAK);
    }

    public static void printGameResultMsg(Map<String, String> raceScore) {

        raceScore.forEach((Key, Value) -> gameResult.append(Key).append(" : ").append(Value).append(LINE_BREAK));
        gameResult.append("\n");
    }

    public static void printFinalResultMsg() {
        System.out.print(gameResult);
    }

    public static void printWinnerMsg(Map<String, String> raceScore, List<String> winner) {
        finalWinner = new StringBuilder();
        finalWinner.append(WINNER_MESSAGE);

        String winnerScore = raceScore.get(winner.get(0));
        finalWinner.append(winner.get(0));

        String winnerList = winner.stream()
                .skip(1)
                .filter(name -> winnerScore.equals(raceScore.get(name)))
                .collect(Collectors.joining(", "));

        if (!winnerList.isEmpty()) {
            finalWinner.append(", ").append(winnerList);
        }

        System.out.print(finalWinner);
    }
}

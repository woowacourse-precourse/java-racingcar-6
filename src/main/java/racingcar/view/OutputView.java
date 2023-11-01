package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.constant.GameMessage;

public class OutputView {
    public static void printStartMessage() {
        System.out.println(GameMessage.GAME_START_MESSAGE.getMessage());
    }

    public static void printTryNumMessage() {
        System.out.println(GameMessage.TRY_NUMBER_MESSAGE.getMessage());
    }

    public static void printResultMessage() {
        System.out.println();
        System.out.println(GameMessage.RESULT_MESSAGE.getMessage());
    }

    public static void printCurrentPosition(String name, int moveCnt) {
        String currentPosition = IntStream.range(0, moveCnt)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
        System.out.println(name + " : " + currentPosition);
    }

    public static void printWinnerMessage() {
        System.out.print(GameMessage.WINNER_MESSAGE.getMessage());
    }

    public static void printWinner(List<String> winners) {
        String winner = String.join(", ", winners);
        System.out.println(winner);
    }
}

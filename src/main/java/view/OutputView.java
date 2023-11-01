package view;

import java.util.List;
import java.util.stream.Collectors;
import message.InputMessage;
import message.OutputMessage;

public class OutputView {
    public static void printInputRacingCarNamesMessage() {
        System.out.println(InputMessage.INPUT_RACING_CAR_NAMES_MESSAGE);
    }

    public static void printInputMoveCountMessage() {
        System.out.println(InputMessage.INPUT_MOVE_COUNT_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println();
        System.out.println(OutputMessage.RESULT_HEADER_MESSAGE);
    }

    public static void printResult(String[] racingCarNames, int[] distances) {
        for (int i = 0; i < racingCarNames.length; ++i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(racingCarNames[i]).append(" : ");
            for (int j = 0; j < distances[i]; ++j) {
                stringBuilder.append('-');
            }
            System.out.println(stringBuilder);
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OutputMessage.WINNER_MESSAGE);
        stringBuilder.append(winners.stream().collect(Collectors.joining(", ")));
        System.out.println(stringBuilder);
    }
}

package racingcar.View;

import java.util.ArrayList;
import java.util.stream.Collectors;
import racingcar.Constants;
import racingcar.Model.Cars;

public class OutputView {
    private final static String DASH = "-";

    public static void printStartMessage() {
        System.out.println(Constants.START_MESSAGE);
    }

    public static void printAskTryNumber() {
        System.out.println(Constants.ASK_TRY_NUMBER);
    }

    public static void printResultMessage() {
        System.out.println(Constants.TRY_RESULT);
    }

    public void printFinalWinner(ArrayList<String> winnerNames) {
        String winners = winnerNames.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.print(Constants.FINAL_WINNER + " : " + winners);
    }

    public void printSingleGame(ArrayList<Cars> players) {
        for (Cars player : players) {
            int distance = player.askDistance();
            String message = player.getName() + " : " + DASH.repeat(distance);
            System.out.println(message);
        }
    }
}

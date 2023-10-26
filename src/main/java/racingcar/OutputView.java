package racingcar;

import java.util.ArrayList;

public class OutputView {
    private final static String DASH = "-";

    public void printStartMessage() {
        System.out.println(Constants.START_MESSAGE);
    }

    public void printAskTryNumber() {
        System.out.println(Constants.ASK_TRY_NUMBER);
    }

    public void printResultMessage() {
        System.out.println(Constants.TRY_RESULT);
    }

    public void printFinalWinner(ArrayList<String> winnerNames) {
        System.out.print(Constants.FINAL_WINNER + " : ");
        for (String name : winnerNames) {
            System.out.print(name + ", ");
        }
        if (!winnerNames.isEmpty()) {
            System.out.println("\b\b"); // 마지막 순번이라면 쉼표와 공백 제거
        }
    }

    public static void printSingleGame(ArrayList<Cars> players) {
        for (Cars player : players) {
            int distance = player.askDistance();
            String message = player.getName() + " : " + DASH.repeat(distance);
            System.out.println(message);
        }
    }
}

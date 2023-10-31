package racingcar.view;

import racingcar.global.GeneralMessage;

import static racingcar.global.GeneralMessage.EXECUTION_RESULT;
import static racingcar.global.GeneralMessage.WINNER;

public class OutputView {
    public static void printGeneralMessage(GeneralMessage generalMessage) {
        System.out.println(generalMessage.getMessage());
    }

    public static void printResultTitle() {
        System.out.println("\n" + EXECUTION_RESULT.getMessage());
    }

    public static void printStatus(String status) {
        System.out.println(status + "\n");
    }

    public static void printWinner(String winner) {
        System.out.printf("%s : %s\n", WINNER.getMessage(), winner);

    }
}

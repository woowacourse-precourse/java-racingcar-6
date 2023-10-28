package racingcar.view;

import static racingcar.constant.GameMessage.RACING_RESULT;

import java.util.List;

public class OutputView {
    public static void printResultMessage() {
        System.out.println(RACING_RESULT);
    }

    public static void printRoundResult(List<String> roundResult) {
        for (String result : roundResult) {
            System.out.println(result);
        }
        printLineChanging();
    }

    public static void printLineChanging() {
        System.out.println();
    }
}

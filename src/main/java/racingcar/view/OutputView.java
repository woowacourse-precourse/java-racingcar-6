package racingcar.view;

import racingcar.global.GeneralMessage;

import static racingcar.global.GeneralMessage.EXECUTION_RESULT;

public class OutputView {
    public static void printGeneralMessage(GeneralMessage generalMessage) {
        System.out.println(generalMessage.getMessage());
    }

    public static void printResultTitle() {
        System.out.println();
        printGeneralMessage(EXECUTION_RESULT);
    }

    public static void printStatus(String status) {
        System.out.println(status + "\n");
    }
}

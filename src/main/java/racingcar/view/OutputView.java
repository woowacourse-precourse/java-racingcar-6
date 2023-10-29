package racingcar.view;

import racingcar.global.GeneralMessage;

public class OutputView {
    public static void printGeneralMessage(GeneralMessage generalMessage) {
        System.out.println(generalMessage.getMessage());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}

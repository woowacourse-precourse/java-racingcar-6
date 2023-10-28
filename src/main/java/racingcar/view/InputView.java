package racingcar.view;

import racingcar.enums.InputMessage;

public class InputView {
    public static void printCarNameMessage() {
        System.out.println(InputMessage.NAME_OF_THE_CAR.getMessage());
    }

    public static void printAttemptsNumberMessage() {
        System.out.println(InputMessage.NUMBER_OF_ATTEMPTS.getMessage());
    }
}

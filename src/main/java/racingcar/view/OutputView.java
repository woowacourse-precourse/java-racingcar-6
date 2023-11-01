package racingcar.view;

import racingcar.enums.Messages;

public class OutputView {
    static StringBuilder sb;
    public static void printInputRacingCar() {
        System.out.println(Messages.INPUT_RACING_CAR_MESSAGE.getMessage());
    }

    public static void printInputTryNumber() {
        System.out.println(Messages.INPUT_TRY_NUMBER_MESSAGE.getMessage());
    }
}

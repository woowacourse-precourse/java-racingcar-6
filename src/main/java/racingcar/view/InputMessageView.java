package racingcar.view;

import static racingcar.constants.Messages.*;

public class InputMessageView {

    public static void showCarNamesMessage() {
        System.out.println(CARS_INPUT_MESSAGE.show());
    }

    public static void showRacingTurnsMessage() {
        System.out.println(FORWARD_TRY_COUNT_INPUT_MESSAGE.show());
    }
}

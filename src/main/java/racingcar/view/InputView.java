package racingcar.view;

import static racingcar.constant.GameMessage.RACING_START;
import static racingcar.constant.GameMessage.REQUEST_ATTEMPT_COUNT;

public class InputView {
    public static void showRequestNames() {
        System.out.println(RACING_START);
    }

    public static void printRequestAttempt() {
        System.out.println(REQUEST_ATTEMPT_COUNT);
    }

    public static void printLineChanging() {
        System.out.println();
    }
}

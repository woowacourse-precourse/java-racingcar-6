package racingcar.module.view;

import static racingcar.global.constant.Game.MOVE;
import static racingcar.global.constant.GameMessage.ENTER_CAR_NAMES;
import static racingcar.global.constant.GameMessage.ENTER_TRIAL_NUMBER;
import static racingcar.global.constant.GameMessage.RESULT_CAR_NAME;
import static racingcar.global.constant.GameMessage.RESULT_INFO_MESSAGE;

public class Output {

    public static void printEnterCarNamesMessage() {
        System.out.println(ENTER_CAR_NAMES);
    }

    public static void printEnterTrialMessage() {
        System.out.println(ENTER_TRIAL_NUMBER);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_INFO_MESSAGE);
    }

    public static void printResult(String name, int moving) {
        System.out.print(String.format(RESULT_CAR_NAME, name));
        printMovingNumber(moving);
    }

    private static void printMovingNumber(int moving) {
        for (int i = 0; i < moving; i++) {
            System.out.println(MOVE);
        }
    }
}

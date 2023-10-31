package racingcar.view;

import static racingcar.constant.MessageConstant.USER_INPUT_CAR_NAME;
import static racingcar.constant.MessageConstant.USER_INPUT_TRIAL_NUMBER;

public class InputView {

    public static void requestCarNames() {
        System.out.println(USER_INPUT_CAR_NAME);
    }

    public static void requestTrialNumber() {
        System.out.println(USER_INPUT_TRIAL_NUMBER);
    }

}

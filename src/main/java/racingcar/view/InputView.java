package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.constants.InputViewConstants.ENTER_ATTEMPT_COUNT_MESSAGE;
import static racingcar.constants.InputViewConstants.ENTER_CAR_NAMES_MESSAGE;

public class InputView {

    public static String carNames() {
        System.out.println(ENTER_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public static String askForAttemptCount() {
        System.out.println(ENTER_ATTEMPT_COUNT_MESSAGE);
        return Console.readLine();
    }
}

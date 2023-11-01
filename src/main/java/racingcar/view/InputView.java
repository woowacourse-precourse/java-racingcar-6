package racingcar.view;

import static racingcar.constant.GameMessage.RACING_START;
import static racingcar.constant.GameMessage.REQUEST_ATTEMPT_COUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String printRequestName() {
        System.out.println(RACING_START);

        return Console.readLine();
    }

    public static String printRequestAttempt() {
        System.out.println(REQUEST_ATTEMPT_COUNT);

        return Console.readLine();
    }
}

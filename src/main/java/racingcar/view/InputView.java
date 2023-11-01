package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.utils.Constants.*;

public class InputView {

    public static String inputName() {
        System.out.println(INPUT_CAR_NAME.getValue());
        return Console.readLine();
    }

    public static String inputAttempt() {
        System.out.println(INPUT_ATTEMPTS.getValue());
        return Console.readLine();
    }
}

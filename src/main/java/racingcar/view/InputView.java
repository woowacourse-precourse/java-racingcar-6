package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.view.Constants.*;

public class InputView {

    public static String inputName() {
        System.out.println(INPUT_CAR_NAME.getMessage());
        return Console.readLine();
    }

    public static String inputAttempt() {
        System.out.println(INPUT_ATTEMPTS.getMessage());
        return Console.readLine();
    }
}

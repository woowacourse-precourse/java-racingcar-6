package view;

import static constant.ConstantString.ATTEMPT_COUNT_MESSAGE;
import static constant.ConstantString.ENTER_CAR_NAME_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String carNames() {
        System.out.println(ENTER_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public static int attemptCount() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}

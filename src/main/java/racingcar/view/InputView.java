package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constants;

public class InputView {
    public static String readCarNames() {
        System.out.println(Constants.INPUT_CAR_NAMES);
        return Console.readLine();
    }

    public static String readNumber() {
        System.out.println(Constants.INPUT_NUMBER);
        return Console.readLine();
    }
}

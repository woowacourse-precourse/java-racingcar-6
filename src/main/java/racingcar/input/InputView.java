package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Constants;

public class InputView {
    public static void greetingMessage() {
        System.out.println(Constants.GET_GREETING_MESSAGE.constant);
    }

    public static String inputCarsName() {
        return Console.readLine();
    }
}

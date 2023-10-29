package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Message;

public class InputView {

    public InputView() {
    }

    public static String readCarNames() {
        System.out.println(Message.CAR_NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String readAttemptCount() {
        System.out.println(Message.ATTEMPT_COUNT_MESSAGE);
        return Console.readLine();
    }
}

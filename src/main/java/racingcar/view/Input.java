package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Message;

public class Input {
    public static String inputCarNames() {
        System.out.println(Message.INPUT_CAR_NAMES);
        return Console.readLine();
    }

    public static String inputRunCount() {
        System.out.println(Message.INPUT_RUN_COUNT);
        return Console.readLine();
    }
}

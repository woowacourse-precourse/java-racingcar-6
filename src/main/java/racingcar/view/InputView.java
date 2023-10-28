package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Message;

public class InputView {
    private InputView() {
    }

    public static String enterCarNames() {
        System.out.println(Message.ENTER_CAR_NAMES);
        return Console.readLine();
    }

    public static String enterTryCount() {
        System.out.println(Message.ENTER_TRY_COUNT);
        return Console.readLine();
    }

    public static void closeScanner() {
        Console.close();
    }
}

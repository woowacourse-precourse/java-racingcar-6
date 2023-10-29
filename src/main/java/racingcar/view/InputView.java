package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ConsoleMessage;

public class InputView {
    private InputView() {
    }

    public static String enterCarNames() {
        System.out.println(ConsoleMessage.ENTER_CAR_NAMES);
        return Console.readLine();
    }

    public static String enterTryCount() {
        System.out.println(ConsoleMessage.ENTER_TRY_COUNT);
        return Console.readLine();
    }

    public static void closeScanner() {
        Console.close();
    }
}

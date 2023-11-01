package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ConsoleMessage;

public class InputView {
    private InputView() {
    }

    public static String enterCarNames() {
        System.out.println(ConsoleMessage.ENTER_CAR_NAMES.getMessage());
        return Console.readLine();
    }

    public static String enterCycle() {
        System.out.println(ConsoleMessage.ENTER_CYCLE.getMessage());
        return Console.readLine();
    }

    public static void closeScanner() {
        Console.close();
    }
}

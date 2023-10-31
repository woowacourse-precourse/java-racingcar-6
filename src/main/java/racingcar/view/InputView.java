package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getCarNames() {
        OutputView.displayCarNames();
        return readConsole();
    }

    public static String getTryCount() {
        OutputView.displayTryCount();
        return readConsole();
    }

    private static String readConsole() {
        return Console.readLine();
    }
}

package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static String readLine() {
        return Console.readLine();
    }

    public static void close() {
        Console.close();
    }
}

package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String playerInput() {
        return Console.readLine();
    }

    public static void closeScanner() {
        Console.close();
    }
}

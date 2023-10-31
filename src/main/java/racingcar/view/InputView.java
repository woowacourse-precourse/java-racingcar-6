package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String COMMA = ",";

    public static String[] promptForCarNames() {
        return Console.readLine().split(COMMA);
    }

    public static int promptNumberOfAttempts() {
        return Integer.parseInt(Console.readLine());
    }
}

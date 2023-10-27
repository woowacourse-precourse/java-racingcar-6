package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String[] promptForCarNames() {
        return Console.readLine().split(",");
    }

    public static int promptNumberOfAttempts() {
        return Integer.parseInt(Console.readLine());
    }
}

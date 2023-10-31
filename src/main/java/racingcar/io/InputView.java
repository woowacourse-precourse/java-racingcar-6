package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String carNamesInput() {
        return Console.readLine();
    }

    public static String tryCountInput() {
        return Console.readLine();
    }
}

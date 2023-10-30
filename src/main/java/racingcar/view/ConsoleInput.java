package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

    private static final String UNKNOWN_ERROR = "알 수 없는 에러";

    static String readLine() {
        try {
            return Console.readLine();
        } catch (OutOfMemoryError e) {
            throw new IllegalArgumentException(UNKNOWN_ERROR);
        }
    }
}

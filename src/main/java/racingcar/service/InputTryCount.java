package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.ErrorMessage;

public class InputTryCount {
    public static int setInputTryCount() {
        int tryCount = 0;
        String input = Console.readLine();
        isNumeric(input);
        tryCount = Integer.parseInt(input);
        checkNumber(tryCount);
        return tryCount;
    }

    public static void checkNumber(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUM_ERROR);
        }
    }

    public static void isNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUM_ERROR);
        }
    }
}

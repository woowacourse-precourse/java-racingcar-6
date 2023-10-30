package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.AppConfig;
import racingcar.InputConfig;

public class InputHandler {
    public static String readInput() {
        return Console.readLine();
    }

    public static String[] StringToArray(String string) {
        return string.split(InputConfig.NAME_DELIMITER, InputConfig.NAME_QUANTITY_MAX);
    }

    public static int StringToInteger(String input) {
        int round = validInteger(input);
        validateRange(round);
        return round;
    }

    private static void validateRange(int round) {
        if (round < InputConfig.RACE_INPUT_MIN) {
            throw new IllegalArgumentException(InputConfig.RACE_INPUT_MIN + " ~ " +
                    InputConfig.RACE_INPUT_MAX + "의 숫자를 입력하세요.");
        }
    }

    private static int validInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
    }
}

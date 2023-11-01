package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.config.InputConfig;

public class InputHandler {
    public static String readInput() {
        return Console.readLine();
    }

    public static String[] StringToNameArray(String string) {
        String[] names = string.split(InputConfig.NAME_DELIMITER, InputConfig.NAME_QUANTITY_MAX);
        validateLength(names);
        return names;
    }

    private static void validateLength(String[] names) {
        if (names.length < InputConfig.PARTICIPANT_MIN) {
            throw new IllegalArgumentException("참가자는 2명 이상 입력해주세요.");
        }
    }

    public static int StringToRoundNumber(String input) {
        int round = validInteger(input);
        validRange(round);
        return round;
    }

    private static void validRange(int round) {
        if (round < InputConfig.RACE_INPUT_MIN) {
            throw new IllegalArgumentException(InputConfig.RACE_INPUT_MIN + "이상의 숫자를 입력하세요.");
        }
    }

    private static int validInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputConfig.RACE_INPUT_MIN + " ~ " +
                    InputConfig.RACE_INPUT_MAX + "의 숫자를 입력하세요.");
        }
    }
}

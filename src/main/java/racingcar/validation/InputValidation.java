package racingcar.validation;

import java.util.List;

public class InputValidation {

    private static final int MAXIMUM_CAR_NAME_LIMIT = 5;
    private static final String INVALID_INPUT = "잘못된 입력입니다.";

    public static List<String> carNameValidate(List<String> input) {
        for (String s : input) {
            if (s.length() > MAXIMUM_CAR_NAME_LIMIT) {
                throw new IllegalArgumentException(INVALID_INPUT);
            }
        }
        return input;
    }

    public static String gameCountValidate(String input) {
        try {
            if (!isNaturalNumber(input)) {
                throw new IllegalArgumentException(INVALID_INPUT);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        return input;
    }

    private static boolean isNaturalNumber(String input) {
        return Integer.parseInt(input) > 0;
    }
}

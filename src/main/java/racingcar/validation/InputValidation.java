package racingcar.validation;

import java.util.List;

public class InputValidation {

    public static final int MAXIMUM_CAR_NAME_LIMIT = 5;
    public static final String INVALID_INPUT = "잘못된 입력입니다.";

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
            Integer.parseInt(input);
            return input;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}

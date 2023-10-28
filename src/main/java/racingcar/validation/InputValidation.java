package racingcar.validation;

import java.util.List;

public class InputValidation {

    public static List<String> carNameValidate(List<String> input) {
        for (String s : input) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        return input;
    }

    public static String gameCountValidate(String input) {
        try {
            Integer.parseInt(input);
            return input;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}

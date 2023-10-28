package racingcar.validation;

import java.util.List;

public class InputValidation {

    public static List<String> inputValidate(List<String> input) {
        for (String s : input) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        return input;
    }
}

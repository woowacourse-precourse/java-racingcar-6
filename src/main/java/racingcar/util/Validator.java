package racingcar.util;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static String[] isValidName(String[] inputs) {
        for (String input : inputs) {
            isEmpty(input);
            isLengthLessThanFive(input);
        }
        isDuplicateName(inputs);
        return inputs;
    }

    public static void isEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE);
        }
    }

    public static void isLengthLessThanFive(String input) {
        if (input.replaceAll("\\s", "").length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public static void isDuplicateName(String[] inputs) {
        List<String> names = new ArrayList<>();
        for (String input : inputs) {
            if (names.contains(input)) {
                throw new IllegalArgumentException("중복되지 않는 자동차 이름을 입력해주세요.");
            }
            names.add(input);
        }
    }
}

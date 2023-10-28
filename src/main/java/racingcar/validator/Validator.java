package racingcar.validator;

import java.util.List;

public class Validator {
    public static void validateUnderFiveLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하로 입력해야 합니다.");
        }
    }

    public static void validateIsBlank(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("자동차의 이름으로 공백은 사용할 수 없습니다.");
        }
    }

    public static void validateIsDuplicate(List<String> input) {
        long inputSize = input.size();
        long uniqueInputSize = input.stream()
                .distinct()
                .count();

        if (inputSize != uniqueInputSize) {
            throw new IllegalArgumentException("서로 다른 이름을 입력해야 합니다.");
        }
    }

    public static void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}

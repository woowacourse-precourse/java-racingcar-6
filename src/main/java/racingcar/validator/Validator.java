package racingcar.validator;

import java.util.List;

public class Validator {
    public static void validateAvailableLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("5자 이하로 입력해야 합니다.");
        }
    }

    public static void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백은 사용할 수 없는 입력입니다.");
        }
    }

    public static void validateIsDuplicate(List<String> input) {
        long inputSize = input.size();
        long uniqueInputSize = input.stream()
                .distinct()
                .count();

        if (inputSize != uniqueInputSize) {
            throw new IllegalArgumentException("중복되지 않게 입력해야 합니다.");
        }
    }

    public static void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
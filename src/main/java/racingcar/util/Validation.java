package racingcar.util;

import java.util.List;
import racingcar.model.Cars;

public class Validation {
    private static final String ERROR_NULL = "빈칸입니다.";
    private static final String ERROR_NAME_LENGTH =  "5자 이하의 이름만 입력 가능합니다.";
    private static final String ERROR_NAME_DUPLICATE = "이름이 중복되었습니다.";
    private static final String ERROR_NUMBER_FORMAT = "숫자가 아닙니다.";
    private static final String ERROR_NUMBER_RANGE = "음수는 입력 불가합니다.";

    public static void validateNameInput(String input) {
        validateNameNull(input);
        List<String> list = Cars.convertStringToList(input);
        validateNameLength(list);
        validateNameDuplicate(list);
    }

    private static void validateNameNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_NULL);
        }
    }

    private static void validateNameLength(List<String> list) {
        for (String input : list) {
            if (input.length() > 5) {
                throw new IllegalArgumentException(ERROR_NAME_LENGTH);
            }
        }
    }

    private static void validateNameDuplicate(List<String> list) {
        if (list.size() != list.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_NAME_DUPLICATE);
        }
    }

    public static void validateNumberInput(String input) {
        validateNumberNull(input);
        validateNumberRange(input);
        validateNumberFormat(input);
    }

    private static void validateNumberNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_NULL);
        }
    }

    private static void validateNumberRange(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
    }

    private static void validateNumberFormat(String input) {
        if(!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_NUMBER_FORMAT);
        }
    }
}

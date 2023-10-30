package racingcar.validator;

import java.util.List;

public class InputValidator {

    private static final String OUT_OF_RANGE = "자동차 이름의 길이는 5자 초과는 입력할 수 없습니다.";
    private static final String DUPLICATE = "중복된 자동차 이름을 입력할 수 없습니다.";
    private static final String NOT_EMPTY = "값을 입력해주세요.";
    private static final String NUMBER_OF_ATTEMPTS = "시도 횟수는 숫자만 입력 가능합니다.";
    private static final String NOT_NEGATIVE = "시도 횟수는 0이상입니다.";

    public static List<String> filterCarName(List<String> carNames) {
        if (NameValidator.isOutOfRange(carNames)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
        if (NameValidator.isDuplicated(carNames)) {
            throw new IllegalArgumentException(DUPLICATE);
        }
        if (NameValidator.isEmpty(carNames)) {
            throw new IllegalArgumentException(NOT_EMPTY);
        }
        return carNames;
    }

    public static int filterNumberOfAttempt(String input) {
        if (!CountValidator.isNumeric(input)) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS);
        }
        if (!CountValidator.isPositiveNumber(input)) {
            throw new IllegalArgumentException(NOT_NEGATIVE);
        }
        return Integer.parseInt(input);
    }
}

package racingcar.validator;

import java.util.List;

public class InputValidator {

    private static final String OUT_OF_RANGE = "자동차 이름의 길이는 5자 초과는 입력할 수 없습니다.";
    private static final String DUPLICATE = "중복된 자동차 이름을 입력할 수 없습니다.";
    private static final String NOT_EMPTY = "값을 입력해주세요.";

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
}

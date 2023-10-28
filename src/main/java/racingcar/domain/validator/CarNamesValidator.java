package racingcar.domain.validator;

import java.util.List;

public class CarNamesValidator implements InputValidator<List<String>> {

    private static final int MAX_LENGTH = 5;
    private static final String INVALID_LENGTH_ERROR_MESSAGE = "각 자동차 이름의 길이는 1-5사이여야 합니다.";

    @Override
    public void validate(List<String> target) {
        checkLength(target);
    }

    private void checkLength(List<String> target) {
        if (containsInvalidLength(target)) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean containsInvalidLength(List<String> target) {
        return target.stream().anyMatch(CarNamesValidator::invalidLength);
    }

    private static boolean invalidLength(String name) {
        return name.length() > MAX_LENGTH || name.length() == 1;
    }
}

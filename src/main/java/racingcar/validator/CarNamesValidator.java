package racingcar.validator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class CarNamesValidator {
    public static final int CAR_NAME_STANDARD_LENGTH = 5;
    public static final Pattern CAR_NAME_PATTERN = Pattern.compile("^([a-zA-Z],?)+$");
    private final String carNames;

    public CarNamesValidator(String carNames) {
        this.carNames = carNames;
        Arrays.stream(carNames.split(","))
                .forEach(carName -> validate(carName));
    }

    private void validate(String s) {
        isNullOrEmpty(s);
        isOverStandardLength(s);
        hasValidCharacters(s);
    }

    private void hasValidCharacters(String s) {
        if (!CAR_NAME_PATTERN.matcher(s).matches()) {
            throw new IllegalArgumentException("영문 이름을 작성해주세요.");
        }
    }

    private void isNullOrEmpty(String s) {
        if (Objects.isNull(s) || Objects.equals(s.length(), 0)) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다");
        }
    }

    private void isOverStandardLength(String s) {
        if (s.length() > CAR_NAME_STANDARD_LENGTH) {
            throw new IllegalArgumentException("5글자가 넘어갔습니다");
        }
    }
}

package racingcar.domain.car;

import java.util.function.Function;

public final class CarDtoValidator {
    private CarDtoValidator() {
    }

    static final String LENGTH_EXCEPTION_MESSAGE = "이름은 5자를 초과할 수 없습니다.";
    static final String NUMBER_EXCEPTION_MESSAGE = "이름에는 숫자가 들어갈 수 없습니다.";
    static final String SPECIAL_CHAR_EXCEPTION_MESSAGE = "이름에는 특수 문자를 입력하실 수 없다.";
    static final String EMOJI_EXCEPTION_MESSAGE = "이름에는 이모지를 입력하실 수 없다.";

    public static void validateCarDto(CarDto carDto) throws IllegalArgumentException {
        // 공백을 제거하고 ,을 통해 구분합니다.
        String carNamesWithCommas = carDto.carNamesWithCommas();
        String[] splittedCarNames = CarDtoParser.trimAndSplit(carNamesWithCommas);

        // 예외를 검증합니다.
        applyValidationsOverCarNames(splittedCarNames,
                validateNameLength, validateNumber, validateSpecialChar, validateEmoji);
    }

    // 자동차 이름 배열에 대해 여러 함수를 apply
    @SafeVarargs
    static void applyValidationsOverCarNames(String[] carNames, Function<String, Void>... validations)
            throws IllegalArgumentException {
        for (String carName : carNames) {
            applyValidationsOverCarName(carName, validations);
        }
    }

    // 자동차 이름에 대해 여러 함수를 apply
    static void applyValidationsOverCarName(String carName, Function<String, Void>[] functions)
            throws IllegalArgumentException {
        for (Function<String, Void> function : functions) {
            function.apply(carName);
        }
    }

    // 5자글자 초과 케이스
    static Function<String, Void> validateNameLength = carName -> {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
        return null;
    };

    // 숫자 입력 케이스
    static Function<String, Void> validateNumber = carName -> {
        if (carName.matches(".*[0-9].*")) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION_MESSAGE);
        }
        return null;
    };

    // 특수문자 입력 케이스
    static Function<String, Void> validateSpecialChar = carName -> {
        if (carName.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\\\"\\\\|,.<>\\/?].*")) {
            throw new IllegalArgumentException(SPECIAL_CHAR_EXCEPTION_MESSAGE);
        }
        return null;
    };

    // 이모지 입력 케이스
    static Function<String, Void> validateEmoji = carName -> {
        if (carName.matches("[\\uD83C-\\uDBFF\\uDC00-\\uDFFF]+")) {
            throw new IllegalArgumentException(EMOJI_EXCEPTION_MESSAGE);
        }
        return null;
    };
}

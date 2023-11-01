package racingcar.domain.round;

import java.util.function.Function;

public final class RoundDtoValidator {
    private RoundDtoValidator() {
    }

    static final String NULL_EXCEPTION_MESSAGE = "공백을 입력하실 수 없습니다.";
    static final String NOT_NUMBER_EXCEPTION_MESSAGE = "숫자가 아닌 문자는 입력하실 수 없습니다.";
    static final String NOT_POSITIVE_NUMBER_MESSAGE = "0이거나 음수인 숫자는 입력하실 수 없습니다.";
    static final String NOT_INTEGER_EXCEPTION_MESSAGE = "정수가 아닌 숫자는 입력하실 수 없습니다.";

    public static void validateRoundDto(RoundDto roundDto) throws IllegalArgumentException {
        String roundInput = roundDto.roundInput();

        applyValidationsOverRoundInput(roundInput,
                validateNull, validateNotNumber, validateNotPositiveNumber, validateNotInteger);
    }

    // 시도횟수 입력값에 대해 여러 함수를 apply
    @SafeVarargs
    static void applyValidationsOverRoundInput(String roundInput, Function<String, Void>... functions)
            throws IllegalArgumentException {
        for (Function<String, Void> function : functions) {
            function.apply(roundInput);
        }
    }

    // 공백 입력 케이스
    static Function<String, Void> validateNull = roundInput -> {
        if (roundInput.isEmpty() || roundInput.isBlank()) {
            throw new IllegalArgumentException(NULL_EXCEPTION_MESSAGE);
        }
        return null;
    };

    // 숫자가 아닌 문자 케이스
    static Function<String, Void> validateNotNumber = roundInput -> {
        if (roundInput.matches("^(?!-?\\+\\d+$|-?\\d+$).*")) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }
        return null;
    };

    // 0이거나 음수인 케이스
    static Function<String, Void> validateNotPositiveNumber = roundInput -> {
        if (roundInput.matches("^[-][0-9]*|0$")) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_MESSAGE);
        }
        return null;
    };

    // 정수가 아닌 케이스
    static Function<String, Void> validateNotInteger = roundInput -> {
        if (roundInput.matches("[+-]?([0-9]*[.])[0-9]+")) {
            throw new IllegalArgumentException(NOT_INTEGER_EXCEPTION_MESSAGE);
        }
        return null;
    };
}

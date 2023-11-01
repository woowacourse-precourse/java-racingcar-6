package racingcar.model;

import static racingcar.view.ExceptionMessage.NOT_KOREAN_OR_ENGLISH;
import static racingcar.view.ExceptionMessage.NOT_NULL;
import static racingcar.view.ExceptionMessage.NOT_OVER_FIVE_OR_LESS_ZERO;

import racingcar.view.ExceptionMessage;

public record CarName(String name) {
    private static final int NAME_MAX_LENGTH = 5;
    public static final int NAME_MIN_LENGTH = 1;

    public CarName {
        validateName(name);
    }

    private static void validateName(String name) {
        checkConditionAndThrowException(name == null, NOT_NULL);
        checkConditionAndThrowException(name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH,
                NOT_OVER_FIVE_OR_LESS_ZERO);
        checkConditionAndThrowException(!name.matches("^[a-zA-Z가-힣]*$"), NOT_KOREAN_OR_ENGLISH);
    }

    private static void checkConditionAndThrowException(boolean condition, ExceptionMessage message) {
        if (condition) {
            throw new IllegalArgumentException(message.getMessage());
        }
    }
}

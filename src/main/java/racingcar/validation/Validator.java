package racingcar.validation;

import racingcar.exception.ExceptionMessage;

public interface Validator {
    void validate(final String target);

    default void validateNotNull(final String target) {
        if (target == null) {
            throwFail(ExceptionMessage.NOT_MUST_BE_NULL.format());
        }
    }

    default void throwFail(final String exceptionMessage) {
        throw new IllegalArgumentException(exceptionMessage);
    }
}

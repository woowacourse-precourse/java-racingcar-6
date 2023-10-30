package racingcar.util.validator;

import racingcar.exception.ExceptionMessage;

public interface Validator {
    void validate(final String target);

    default <T> void validateNotNull(final T target) {
        if (target == null) {
            throwFail(ExceptionMessage.NOT_MUST_BE_NULL.format());
        }
    }

    default void throwFail(final String exceptionMessage) {
        throw new IllegalArgumentException(exceptionMessage);
    }
}

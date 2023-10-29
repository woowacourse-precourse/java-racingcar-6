package racingcar.validator;

import java.util.List;

public interface Validator<T> {
    void validate(T param);
    default void throwException(String exceptionMessage) throws IllegalArgumentException {
        throw new IllegalArgumentException(exceptionMessage);
    }
}

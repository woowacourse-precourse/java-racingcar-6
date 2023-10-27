package racingcar.validator;

public interface Validator {
    void validate(String object);
    default void throwException(String exceptionMessage) throws IllegalArgumentException {
        throw new IllegalArgumentException(exceptionMessage);
    }
}

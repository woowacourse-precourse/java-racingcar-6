package racingcar.validation;

public interface Validator {
    boolean support(Class<?> clazz);

    void validate(Object target);
}

package racingcar.validator;

public interface Validator<T> {
    T validate(T input);

}
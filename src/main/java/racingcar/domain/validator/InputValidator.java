package racingcar.domain.validator;

public interface InputValidator<T> {

    void validate(T target);
}

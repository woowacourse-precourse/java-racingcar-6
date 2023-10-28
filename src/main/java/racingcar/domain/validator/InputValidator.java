package racingcar.domain.validator;

@FunctionalInterface
public interface InputValidator {
    void validate(String input);
}

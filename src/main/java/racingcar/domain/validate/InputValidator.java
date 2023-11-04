package racingcar.domain.validate;

@FunctionalInterface
public interface InputValidator {
    void validate(String input);
}

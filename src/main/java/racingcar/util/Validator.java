package racingcar.util;

public interface Validator {
    static InputValidator generateInputValidator() {
        return new InputValidator();
    }
}

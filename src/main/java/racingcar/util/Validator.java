package racingcar.util;

public interface Validator {
    static Validator generateInputValidator() {
        return new InputValidator();
    }
}

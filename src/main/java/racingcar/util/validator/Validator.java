package racingcar.util.validator;

public interface Validator {
    static Validator generateInputValidator() {
        return new InputValidator();
    }
}

package racingcar.model;

import static racingcar.constant.Number.NAME_MAX_LENGTH;
import static racingcar.constant.Number.NAME_MIN_LENGTH;
import static racingcar.constant.Validation.INPUT_NAME_LENGTH_VALIDATION;

public class CarName {

    private final String name;

    public CarName(String name) {
        nameLengthValidation(name);
        this.name = name;
    }

    private void validation(String name) {
        nameLengthValidation(name);
    }

    private void nameLengthValidation(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(INPUT_NAME_LENGTH_VALIDATION);
        }
    }

    public String format() {
        return this.name;
    }
}

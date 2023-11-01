package racingcar.domain;

import static racingcar.constant.Constant.CAR_NAME_MAX_LENGTH;
import static racingcar.constant.Constant.START_POSITION;
import static racingcar.constant.ErrorMessage.CAR_NAME_BLANK_ERROR_MESSAGE;
import static racingcar.constant.ErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE;

public class car {

    public String name;
    public int position;

    public car(String name) {
        validate(name);
        this.name = name;
        this.position = START_POSITION;
    }

    private static void validate(String name) {
        validateCarNameLength(name);
        validateIsCarNameBlank(name);
    }

    private static void validateCarNameLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateIsCarNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(String.valueOf(CAR_NAME_BLANK_ERROR_MESSAGE));
        }
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

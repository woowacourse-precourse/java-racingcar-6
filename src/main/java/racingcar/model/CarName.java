package racingcar.model;

import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private final String carName;

    private CarName(String input) {
        carName = validate(input);
    }

    protected static CarName create(String input) {
        return new CarName(input);
    }

    private static String validate(String input) {
        if (input.isEmpty() || input.length() > MAX_LENGTH) {
            throw InvalidInputException.with(ErrorMessage.INVALID_LENGTH);
        }
        return input;
    }

    protected String getCarName() {
        return carName;
    }
}

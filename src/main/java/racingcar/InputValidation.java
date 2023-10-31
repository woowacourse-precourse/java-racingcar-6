package racingcar;

import static racingcar.Car.MAX_CAR_NAME_LENGTH;

public class InputValidation {

    void checkNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    int validNum(String input) {
        boolean matches = input.matches("^[0-9]+$");

        if (!matches) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }
}

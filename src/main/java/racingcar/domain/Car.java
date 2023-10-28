package racingcar.domain;

import racingcar.message.ErrorMessage;

public class Car {
    private final String name;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.OVER_FIVE_LENGTH.toString());
        }
    }
}

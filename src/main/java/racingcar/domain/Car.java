package racingcar.domain;

import static racingcar.common.Constants.MAX_LENGTH_OF_NAME;
import static racingcar.common.Constants.MIN_NUMBER_FOR_MOVEMENT;
import static racingcar.common.Constants.MOVEMENT_DISTANCE;

public class Car {

    String name;
    int meter;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.meter = 0;
    }

    public void move(int randomNumber) {
        if(randomNumber >= MIN_NUMBER_FOR_MOVEMENT) {
            meter += MOVEMENT_DISTANCE;
        }
    }

    private void validateLength(String name) {
        if(name.isEmpty() || name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("이름은 공백 하여 최소 1자 이상 5자 이하만 가능합니다.");
        }
    }

}

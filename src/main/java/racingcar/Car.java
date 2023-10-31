package racingcar;

import java.util.Objects;

public class Car {
    private final String car;

    public Car(String car) {
        validate_length(car);
        this.car = car;
    }

    private void validate_length(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
        }
    }

    public String getName(){
        return car;
    }

    public String toString() {
        return String.valueOf(this.car);
    }

}

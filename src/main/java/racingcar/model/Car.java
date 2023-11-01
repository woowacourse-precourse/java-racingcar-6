package racingcar.model;

import java.util.Objects;

public class Car {
    private String name;
    private int distance;
    private final int MAX_NAME_LENGTH = 5;
    private final String MAX_NAME_ERROR_MESSAGE = "자동차의 이름은 최대 5글자 입니다.";
    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            distance++;
        }
    }
    private void checkMaxNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_ERROR_MESSAGE);
        }
    }

}

package racingcar.domain;

import racingcar.constant.ExceptionMessage;
import racingcar.utils.RandomNumberGenerator;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private String name;
    private int distance;

    public Car(Car car) {
        this.name = car.name;
    }

    public Car(String name) {
        this.name = name;
        validateNameLenght();
    }

    public void increaseDistance() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void validateNameLenght() {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_NAME_LENGTH.getMessage());
        }
    }
}

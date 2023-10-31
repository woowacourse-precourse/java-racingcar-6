package racingcar;

import java.util.Objects;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ErrorMessage = "경주할 자동차의 이름은 5자 이하로 작성해 주세요.";
    private final String car;

    public Car(String car) {
        this.car = car;
    }

    public String getCar() {
        return car;
    }

    public static Car makeCar(String splitInput) {
        validateCar(splitInput);
        return new Car(splitInput);
    }

    private static void validateCar(String splitInput) {
        if (!isValid(splitInput)) {
            throw new IllegalArgumentException(ErrorMessage);
        }
    }

    private static boolean isValid(String splitInput) {
        return splitInput.length() <= MAX_NAME_LENGTH && splitInput.length() >= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car carObject = (Car) o;
        return car == carObject.car;
    }

    @Override
    public int hashCode() {
        return Objects.hash(car);
    }
}

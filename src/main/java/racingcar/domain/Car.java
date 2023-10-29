package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int NAME_MAX_LENGTH = 5;
    private static final int FORWARD_BASE_NUMBER = 4;
    private static final String CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "5자 이하의 이름만 가능합니다.";
    private static final String EMPTY_SPACE = "";
    private static final String FORWARD_MOVEMENT_INDICATOR = "-";
    private static final String SEPARATOR = " : ";
    private static final String BLNAK = " ";
    private static final String CAR_NAME_BLANK_EXCEPTION_MESSAGE = "자동차 이름에 공백이 있으면 안 됩니다.";

    private final String name;
    private String location = EMPTY_SPACE;

    public Car(String name) {
        validateCarNameHasBlank(name);
        validateCarNameLength(name);
        this.name = name;
    }

    public String move(int randomNumber) {
        if (isForward(randomNumber)) {
            location += FORWARD_MOVEMENT_INDICATOR;
        }
        return name + SEPARATOR + location;
    }

    public int getLocationLength() {
        return location.length();
    }

    public String getName() {
        return name;
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= FORWARD_BASE_NUMBER;
    }

    private void validateCarNameLength(String name) {
        if (name.isEmpty() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void validateCarNameHasBlank(String name) {
        if (name.contains(BLNAK)) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION_MESSAGE);
        }
    }
}

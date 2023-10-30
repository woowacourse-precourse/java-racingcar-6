package racingcar.domain;

import static racingcar.view.CommonMessage.ERROR_MESSAGE_PREFIX;

public class Car {

    private static final int MOVABLE_POINT = 3;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int movePosition(int number) {
        if (number >= MOVABLE_POINT) {
            return ++position;
        }
        return position;
    }

    public boolean lessMoveThan(Car car) {
        return position < car.position;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "자동차 이름은 5자 이하여야 한다.");
        }
    }
}
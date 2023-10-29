package racingcar.domain;

import racingcar.constant.CarPosition;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = CarPosition.INITIAL_POSITION.getValue();
    }

    public void move() {
            position++;
    }

    public CarDto toDto() {
        return new CarDto(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

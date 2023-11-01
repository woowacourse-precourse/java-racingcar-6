package racingcar.domain;

import racingcar.domain.dto.CarDto;

public class Car {

    private static final int MOVABLE_THRESHOLD = 3;

    private final Position position;
    private final Name name;

    private Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void move(int randomNumber) {
        if (isMovable(randomNumber)) {
            position.increase();
        }
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber > MOVABLE_THRESHOLD;
    }

    public CarDto toDto() {
        return new CarDto(name.getValue(), position.getValue());
    }
}

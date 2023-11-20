package racingcar.domain.car;

import racingcar.domain.Movement;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(Movement movement) {
        position.move(movement);
    }

    public int getPosition() {
        return position.getValue();
    }

    public CarDTO getCarDTO() {
        return new CarDTO(name.getValue(), position.getValue());
    }
}
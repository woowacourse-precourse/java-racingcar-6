package racingcar.domain;

import racingcar.dto.CarDto;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private final Name name;
    private final Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(final int randomNumber) {
        if (canMove(randomNumber)) {
            position.moveForward();
        }
    }

    private boolean canMove(final int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }

    public boolean isSamePosition(final Car car) {
        return this.position.equals(car.position);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public CarDto toCarDto() {
        return new CarDto(name.getName(), position.getPosition());
    }

}

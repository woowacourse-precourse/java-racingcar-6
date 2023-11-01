package racingcar.model;

import racingcar.dto.CarDto;

public class Car {
    private static final int INIT_POSITION = 0;

    private Name name;
    private Position position;

    public Car(final Name name) {
        this(name, new Position(INIT_POSITION));
    }

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }


    public boolean isSamePosition(int position) {
        return this.position.equals(new Position(position));
    }

    public boolean isSamePosition(Car car) {
        return position.equals(car.position);
    }

    public void move() {
        position = position.move();
    }

    public void moveUsingRandomNumber(NumberGenerator numberGenerator, MovingStrategy movingStrategy) {
        RandomNumber randomNumber = numberGenerator.generate();
        if (movingStrategy.movable(randomNumber)) {
            move();
        }
    }

    public boolean isFrontOf(Car car) {
        return position.isFrontOf(car.position);
    }

    public CarDto toDto() {
        return new CarDto(name.toDto(), position.toDto());
    }
}

package racingcar.model;

import racingcar.dto.CarDto;

public class Car {

    private static final int INIT_POSITION = 0;
    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    private int position;

    public Car(final String name) {
        this(name, INIT_POSITION);
    }

    public Car(final String name, final int position) {
        validate(name, position);
        this.name = name;
        this.position = position;
    }

    private void validate(final String name, final int position) {
        validateSize(name);
        validatePosition(position);
    }

    private void validatePosition(final int position) {
        if (position < INIT_POSITION) {
            throw new IllegalArgumentException("[Error] 초기위치값은 0보다 작을 수 없습니다.");
        }
    }

    private void validateSize(final String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("[Error] 이름 크기는 5이하여야 합니다.");
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    public void move() {
        this.position += 1;
    }

    public void moveUsingRandomNumber(NumberGenerator numberGenerator) {
        RandomNumber randomNumber = numberGenerator.generate();
        if (randomNumber.isGreaterThanFour()) {
            move();
        }
    }

    public boolean isFrontOf(Car car) {
        return this.position > car.position;
    }

    public CarDto toDto() {
        return new CarDto(this.name, this.position);
    }
}

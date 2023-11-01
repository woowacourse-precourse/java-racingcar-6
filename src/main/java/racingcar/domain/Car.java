package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private static final int DEFAULT_POSITION = 0;
    private static final String POSITION_SYMBOL = "-";
    private final Name name;
    private Position position;

    public Car(final Name name) {

        this(name, new Position(DEFAULT_POSITION));
    }

    public Car(final Name name, final Position position) {

        this.name = name;
        this.position = position;
    }

    public void tryMove(int randomNumber) {

        if (isMove(randomNumber)) {
            this.position = position.move();
        }
    }

    public boolean isAtPosition(Position position) {

        return this.position.equals(position);
    }

    public Name getName() {

        return name;
    }

    public Position getPosition() {

        return position;
    }
    public String getNameValue() {

        return name.value();
    }

    public String getPositionSymbol() {

        return POSITION_SYMBOL.repeat(position.value());
    }

    private boolean isMove(int randomNumber) {

        return randomNumber >= MOVE_CONDITION;
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
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}

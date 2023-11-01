package racingcar;

import racingcar.exception.InvalidCarNameException;

public class Car {
    private final String name;
    private final MoveStrategy moveStrategy;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.moveStrategy = new RandomMoveStrategy();
    }

    public Car(String name, MoveStrategy moveStrategy) {
        validateName(name);
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new InvalidCarNameException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return moveStrategy.determineMovable();
    }

    public boolean isPosition(int position) {
        return this.position == position;
    }
}

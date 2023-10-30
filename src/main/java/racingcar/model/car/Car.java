package racingcar.model.car;

import racingcar.model.RandomNumberGenerator;

public class Car implements Comparable<Car> {
    private static final int FORWARD_NUMBER = 4;

    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void race() {
        int number = RandomNumberGenerator.generate();
        if (FORWARD_NUMBER <= number) {
            this.position.plus();
        }
    }

    public boolean isSamePosition(Car other) {
        return getPosition() == other.getPosition();
    }

    @Override
    public int compareTo(Car other) {
        return getPosition() - other.getPosition();
    }

    public Name getName() {
        return name;
    }

    private int getPosition() {
        return this.position.get();
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(getPosition()) + "\n";
    }
}

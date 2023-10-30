package racingcar.model.car;

import racingcar.model.RandomNumberGenerator;

public record Car(Name name, Position position) implements Comparable<Car> {
    private static final int FORWARD_NUMBER = 4;

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

    private int getPosition() {
        return this.position.get();
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(getPosition());
    }
}

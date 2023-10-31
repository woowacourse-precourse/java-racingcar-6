package racingcar.model;

import static racingcar.controller.GameConstants.MIN_NUMBER_TO_MOVE;

import racingcar.util.NumberGenerator;

public class Car implements Comparable<Car> {
    private Name name;
    private Distance distance;
    private NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = new Name(name);
        distance = new Distance();
        this.numberGenerator = numberGenerator;
    }

    public void moveOrStay() {
        int decisionNumber = numberGenerator.generateNumber();

        if (decisionNumber >= MIN_NUMBER_TO_MOVE.getNumber()) {
            distance.move();
        }
    }

    @Override
    public int compareTo(Car otherCar) {
        return distance.compare(otherCar.distance);
    }

    public boolean isWinner(Car maxDistanceCar) {
        return isDistanceEqual(maxDistanceCar.distance);
    }

    private boolean isDistanceEqual(Distance distance) {
        return this.distance.compare(distance) == 0;
    }

    public String getName() {
        return name.name();
    }

    public Long getDistance() {
        return distance.getDistance();
    }
}
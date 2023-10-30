package racingcar.model;

import static racingcar.controller.GameConstants.MIN_NUMBER_TO_MOVE;

public class Car implements Comparable<Car> {
    private Name name;
    private Long distance;
    private NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = new Name(name);
        distance = 0L;
        this.numberGenerator = numberGenerator;
    }

    public void moveOrStay() {
        int decisionNumber = numberGenerator.generateNumber();

        if (decisionNumber >= MIN_NUMBER_TO_MOVE.getNumber()) {
            distance++;
        }
    }

    @Override
    public int compareTo(Car otherCar) {
        return Long.compare(this.distance, otherCar.distance);
    }

    public boolean isWinner(Car maxDistanceCar) {
        return distance.equals(maxDistanceCar.distance);
    }

    public String getName() {
        return name.name();
    }

    public Long getDistance() {
        return distance;
    }
}
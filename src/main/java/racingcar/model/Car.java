package racingcar.model;

import static racingcar.model.CriteriaValues.MOVE_CRITERIA;

public class Car implements Comparable<Car> {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void moveCar(int moveCondition) {
        if (moveCondition >= MOVE_CRITERIA.value) {
            distance++;
        }
    }

    public String getCarStatus() {
        return name + " : " + "-".repeat(distance);
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.distance - otherCar.distance;
    }

    public boolean isSameDistanceAs(Car car) {
        return distance == car.distance;
    }

    public String getCarName() {
        return name;
    }
}

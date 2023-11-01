package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

public class Car implements Comparable<Car> {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public Car move() {
        if (RandomNumberGenerator.canMove()) {
            this.distance++;
        }
        return new Car(name, distance);
    }

    @Override
    public int compareTo(Car o) {
        return this.distance - o.distance;
    }

    public boolean isSameDistance(Car o) {
        return this.distance == o.distance;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}

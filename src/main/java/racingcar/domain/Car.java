package racingcar.domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int distance;
    private static final String BASH = "-";

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public void updateDistance(int number) {
        if (isMoveForward(number)) {
            distance += 1;
        }
    }

    private boolean isMoveForward(int number) {
        return number >= 4;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car other) {
        return this.distance - other.distance;
    }

    @Override
    public String toString() {
        return name + " : " + BASH.repeat(distance);
    }
}

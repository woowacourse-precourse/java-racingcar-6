package racingcar.model;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int move() {
        distance += 1;
        return distance;
    }

    public int getMaxDistance(Car car, int max) {
        if (car.distance > max) {
            max = car.distance;
        }
        return max;
    }

    public boolean isSameDistance(Car car, int maxDistance) {
        if (car.distance == maxDistance) {
            return true;
        }
        return false;
    }
}

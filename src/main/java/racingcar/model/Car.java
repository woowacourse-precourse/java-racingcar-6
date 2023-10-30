package racingcar.model;

public class Car {
    private final String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move(int randomNumber) {
        if (isMovePossible(randomNumber)) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private boolean isMovePossible(int randomNumber) {
        return randomNumber >= 4;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}

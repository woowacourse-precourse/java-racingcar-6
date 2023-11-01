package racingcar;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move(int distanceToMove) {
        this.distance += distanceToMove;
    }

    public int getDistance() {
        return this.distance;
    }
}

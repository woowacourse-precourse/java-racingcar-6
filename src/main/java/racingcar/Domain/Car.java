package racingcar.Domain;

public class Car {

    private final String name;
    private int movingDistance;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        this.movingDistance++;
    }

    public String getName() {
        return this.name;
    }

    public int getMovingDistance() {
        return this.movingDistance;
    }
}

package racingcar;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public boolean canMove() {
        return false;
    }

    public void move() {

    }

    public int getDistance() {
        return 0;
    }
}

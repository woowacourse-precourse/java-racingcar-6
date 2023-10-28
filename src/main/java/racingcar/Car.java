package racingcar;

public class Car {

    private String name;
    private int distance = 0;

    public void moveForward() {
        this.distance ++;
    }

    @Override
    public String toString() {
        return this.name + " : "
                + "-".repeat(Math.max(0, this.distance));
    }
}

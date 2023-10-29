package racingcar.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void moveForward(int distance) {
        position += distance;
    }
    public int getPosition() {
        return position;
    }
}

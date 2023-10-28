package racingcar.domain;

public class Car {
    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    private String name;
    private int count;

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void moveForward() {
        this.count++;
    }
}

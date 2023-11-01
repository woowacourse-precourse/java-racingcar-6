package racingcar.domain;

public class Car {
    private String name;
    private int progress;

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public void moveForward() {
        this.progress += 1;
    }
}

package racingcar.domain;

public class Car {
    private Name name;
    private Progress progress;

    public Car(String name) {
        this.name = new Name(name);
        progress = new Progress();
    }

    public void move() {
        progress.move();
    }

    public String getNameToString() {
        return name.get();
    }

    public int getProgressToInt() {
        return progress.get();
    }
}

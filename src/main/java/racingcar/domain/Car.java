package racingcar.domain;

public class Car {
    public Name name;
    Progress progress;

    public Car(String name) {
        this.name = new Name(name);
        progress = new Progress();
    }

    public void move() {
        progress.move();
    }
}

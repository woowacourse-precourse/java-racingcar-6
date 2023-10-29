package racingcar.domain;

public class Car {

    private int location;
    private final Generator generator;

    public Car(Generator generator) {
        location = 0;
        this.generator = generator;
    }

    public void move() {
        if (generator.generate() < 4) {
            return;
        }
        location++;
    }

    public int getLocation() {
        return location;
    }
}

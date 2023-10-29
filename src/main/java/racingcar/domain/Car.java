package racingcar.domain;

public class Car {

    public static final int MOVE_BOUNDARY = 4;
    private final Generator generator;
    private int location;

    public Car(Generator generator) {
        location = 0;
        this.generator = generator;
    }

    public void move() {
        if (isMove()) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }

    private boolean isMove() {
        return MOVE_BOUNDARY <= generator.generate();
    }
}

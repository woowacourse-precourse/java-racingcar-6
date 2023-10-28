package racingcar.car;

public class Car {

    public static final int FORWARD_MOVE_INIT_COUNT = 0;
    private int forwardMoveCount;
    private final String name;

    private Car(String name) {
        this.name = name;
        this.forwardMoveCount = FORWARD_MOVE_INIT_COUNT;
    }

    public static Car of (String name) {
        return new Car(name);
    }

    public void move() {
        this.forwardMoveCount++;
    }

}

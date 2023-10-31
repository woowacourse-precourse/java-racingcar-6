package racingcar.Domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int START_POSITION = 0;
    private static final int TICK = 1;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public void moveForward() {
        if (RandomNumber.chooseRandomNumber() >= MOVE_THRESHOLD) {
            this.position += TICK;
        }
    }
}

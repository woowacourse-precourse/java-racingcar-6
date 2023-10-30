package racingcar;

public class Car {

    private static final int ACCELERATION_THRESHOLD = 4;

    public Car() {}

    public int accelerate() {
        return 1;
    }

    public int brake() {
        return 0;
    }

    public int respondToDriverInput(int input) {
        if (input >= ACCELERATION_THRESHOLD) {
            return accelerate();
        }
        return brake();
    }
}

package racingcar;

public class Car {

    private static final int ACCELERATION_THRESHOLD = 4;
    private static final int ACCELERATE_DISTANCE = 1;
    private static final int BREAK_DiSTANCE = 0;
    public Car(){}

    public int accelerate() {
        return ACCELERATE_DISTANCE;
    }

    public int brake() {
        return BREAK_DiSTANCE;
    }

    public int respondToDriverInput(int input) {
        if (input >= ACCELERATION_THRESHOLD) {
            return accelerate();
        }
        return brake();
    }
}

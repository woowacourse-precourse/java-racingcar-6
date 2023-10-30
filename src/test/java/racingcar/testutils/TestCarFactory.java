package racingcar.testutils;

import racingcar.domain.Car;

public class TestCarFactory {
    private static int sequence = 0;

    public static Car createCar() {
        return new Car(String.valueOf(sequence++));
    }

    public static Car createCar(boolean isAlwaysMove) {
        sequence++;
        if (isAlwaysMove) {
            return new Car(String.valueOf(sequence), () -> Car.MOVE_THRESHOLD);
        }
        return new Car(String.valueOf(sequence), () -> Car.MOVE_THRESHOLD - 1);
    }
}

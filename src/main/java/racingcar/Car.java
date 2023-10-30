package racingcar;

public class Car {
    private final String carName;
    private int progress;

    public Car(String carName) {
        this.carName = carName;
    }

    public void movable(int number) {
        if (number >= 4) {
            move(1);
        }
    }

    private void move(int moving) {
        progress += moving;
    }
}

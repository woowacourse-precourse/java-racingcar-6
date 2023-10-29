package racingcar.domain;

public class Car {
    private static final int RUN_THRESHOLD = 4;

    private String carName;
    private int count;

    public Car(String carName) {
        this.carName = carName;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public String getCarName() {
        return carName;
    }

    public void runOrStop(int randomNumber) {
        if (randomNumber >= RUN_THRESHOLD) {
            this.count++;
        }
    }
}
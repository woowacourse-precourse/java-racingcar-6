package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final String COLON = " : ";
    private static final String INDICATE = "-";
    private final CarName carName;
    private final Progress progress;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.progress = new Progress();
    }

    public void movable(int number) {
        progress.movable(number);
    }

    public boolean isLesser(Car car) {
        if (this.equals(car)) {
            return true;
        }

        if (this.getProgress() <= car.getProgress()) {
            return true;
        }
        return false;
    }

    public int getProgress() {
        return progress.getProgress();
    }

    public String indicate() {
        return carName.carName() + COLON
                + INDICATE.repeat(progress.getProgress());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(progress, car.progress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, progress);
    }
}

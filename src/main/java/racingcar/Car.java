package racingcar;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private final Progress progress;
    private int trial;
    public Car(String carName) {
        this.carName = new CarName(carName);
        this.progress = new Progress();
        this.trial = 0;
    }

    public void movable(int number) {
        trial++;
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
        return carName.carName() + " : "
                + "-".repeat(progress.getProgress());
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

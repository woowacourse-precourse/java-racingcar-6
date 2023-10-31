package racingcar;

import java.util.Objects;

public class Car {
    private final String carName;
    private int progress;
    private int trial;
    public Car(String carName) {
        this.carName = carName;
        this.trial = 0;
    }

    public void movable(int number) {
        trial++;
        if (number >= 4) {
            move(1);
        }
    }

    private void move(int moving) {
        progress += moving;
    }

    public boolean isLesser(Car car) {
        if (this.equals(car)) {
            return true;
        }

        if (this.progress <= car.progress) {
            return true;
        }
        return false;
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
        return progress == car.progress && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, progress);
    }


    public String indicate() {
        return carName + " : "
                + "-".repeat(progress);
    }


}

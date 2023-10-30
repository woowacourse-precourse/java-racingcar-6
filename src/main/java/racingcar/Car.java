package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void goForward() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.position += 1;
        }

    }

    @Override
    public int compareTo(Car o) {
        return o.position - this.position;
    }

    public boolean equalsPosition(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && carName.equals(car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

    public String getStatusMessage() {
        return carName.getName() + " : " + "-".repeat(position);
    }

    public String getCarName() {
        return carName.getName();
    }
}

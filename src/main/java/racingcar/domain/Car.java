package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int MINIMUM_MOVABLE_SYMBOL = 4;

    private final CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void goForward(int movableSymbol) {
        if (isMovable(movableSymbol)) {
            this.position += 1;
        }
    }

    private boolean isMovable(int movableSymbol) {
        return movableSymbol >= MINIMUM_MOVABLE_SYMBOL;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }

    public boolean isEqualPosition(Car car) {
        return this.position == car.position;
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

    public String getCarName() {
        return carName.getName();
    }

    public Integer getPosition() {
        return position;
    }
}

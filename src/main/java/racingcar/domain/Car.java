package racingcar.domain;

import java.util.Objects;
import racingcar.vo.CarName;

public class Car {

    private final CarName name;
    private int forwardCount;

    public Car(CarName name) {
        this.name = name;
        forwardCount = 0;
    }


    public void moveForward() {
        forwardCount++;
    }

    public int showForwardCount() {
        return forwardCount;
    }

    public String showName() {
        return name.show();
    }

    public void checkMoveForward(boolean isCarMove) {
        if (isCarMove) {
            this.moveForward();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car otherCar = (Car) o;
        return this.name.equals(otherCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

}

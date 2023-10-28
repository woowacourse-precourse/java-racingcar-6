package racingcar.domain;

import java.util.Objects;

public class Car {
    private final String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void forward(final int number) {
        if (isNumOverThree(number)) {
            forwardCount++;
        }
    }

    public boolean isLead(Car other) {
        if (this.forwardCount >= other.forwardCount) {
            return true;
        }
        return false;
    }

    private boolean isNumOverThree(final int number) {
        return number > 3;
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
        return forwardCount == car.forwardCount && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, forwardCount);
    }
}

package racingcar.domain.model;

import java.util.Objects;

public class Car {
    private final String name;
    private int postion = 0;

    public Car(String name) {
        this.name = name;
    }

    void move() {
        this.postion++;
    }

    public boolean isPositionEqualTo(int ohterPosition) {
        return postion == ohterPosition;
    }

    public String formattedProgress() {
        return name + " : " + "-".repeat(this.postion);
    }

    public String getName() {
        return name;
    }

    public int getPostion() {
        return postion;
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
        return postion == car.postion && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, postion);
    }
}

package racingcar.domain.car;

import java.util.Objects;

import static racingcar.Constant.*;

public class Car {
    private final String name;
    private int point;

    public Car(String name) {
        this.name = name;
    }

    void forward() {
        point++;
    }

    //==get 메서드==//
    /*같은 패키지로 범위 제한*/
    String getName() {
        return name;
    }

    int getPoint() {
        return point;
    }

    //==출력==//
    @Override
    public String toString() {
        return name +
                IS +
                LINE.repeat(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return point == car.point && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, point);
    }
}

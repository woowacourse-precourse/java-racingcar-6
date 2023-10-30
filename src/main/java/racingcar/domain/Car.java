package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {

    private String name;
    private int position;

    private Car() {
    }

    private Car(String name) {
        this.name = name;
    }

    public static Car of(String name) {
        validateName(name);
        return new Car(name);
    }

    public static Car of(String name, int position) {
        Car car = Car.of(name);
        car.position = position;
        return car;
    }

    public void move() {
        if (canMove()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber > 3;
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
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

        if (position != car.position) {
            return false;
        }
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + position;
        return result;
    }
}

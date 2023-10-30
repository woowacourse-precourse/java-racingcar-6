package racingcar.domain;

import racingcar.policy.MovingPolicy;
import racingcar.policy.NumberGeneratePolicy;

import java.util.Objects;

public class Car {

    private final CarName carName;
    private int position;

    public Car(CarName carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public void move(MovingPolicy movingPolicy, NumberGeneratePolicy numberGeneratePolicy) {
        if (movingPolicy.canMove(numberGeneratePolicy.generate())) {
            this.position++;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return position == car.position && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

}

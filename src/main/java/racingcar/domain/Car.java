package racingcar.domain;


import racingcar.policy.MovingPolicy;
import racingcar.policy.NumberGeneratePolicy;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private final Position position;

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public Car move(MovingPolicy movingPolicy, NumberGeneratePolicy numberGeneratePolicy) {
        if (movingPolicy.canMove(numberGeneratePolicy.generate())) {
            return new Car(this.carName, position.increase());
        }
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

    public String getCarName() {
        return this.carName.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public boolean isWinner(int maxPosition) {
        return this.position.equals(new Position(maxPosition));
    }

}

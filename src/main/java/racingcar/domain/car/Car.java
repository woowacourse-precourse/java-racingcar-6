package racingcar.domain.car;

import racingcar.domain.policy.MoveRule;
import racingcar.domain.policy.MovePolicy;

import java.util.List;
import java.util.Objects;

public class Car {
    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
    }

    public void move(MoveRule moveRule) {
        if (isMove(moveRule)) {
            position++;
        }
    }

    private boolean isMove(MoveRule moveRule) {
        return MovePolicy.canMove(moveRule);
    }

    public String printPosition() {
        return name.value() + " : " + "-".repeat(position) + "\n";
    }

    public String getWinner(List<Car> cars) {
        boolean isWinner = cars.stream()
                .noneMatch(c -> this.position < c.position);

        if (isWinner) {
            return this.name.value();
        }

        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
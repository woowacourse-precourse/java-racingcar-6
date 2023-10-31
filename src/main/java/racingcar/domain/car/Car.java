package racingcar.domain.car;

import exception.WrongNameException;
import racingcar.domain.policy.DriveRule;
import racingcar.domain.policy.MovePolicy;

import java.util.List;
import java.util.Objects;

public class Car {
    private final String name;
    private int position;

    private static final int NAME_LENGTH = 5;

    public Car(String name) {
        valid(name);
        this.name = name;
    }

    private void valid(String name) {
        if (isOver(name) || isEmpty(name)) {
            throw new WrongNameException("이름을 확인해주세요.");
        }
    }

    private boolean isOver(String name) {
        return name.length() > NAME_LENGTH;
    }

    private boolean isEmpty(String name) {
        return name.isEmpty();
    }

    public void move(DriveRule driveRule) {
        if (isMove(driveRule)) {
            position++;
        }
    }

    private boolean isMove(DriveRule driveRule) {
        return MovePolicy.canMove(driveRule);
    }

    public String printPosition() {
        return name + " : " + "-".repeat(position) + "\n";
    }

    public String getWinner(List<Car> cars) {
        boolean isWinner = cars.stream()
                .noneMatch(c -> this.position < c.position);

        if (isWinner) {
            return this.name;
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
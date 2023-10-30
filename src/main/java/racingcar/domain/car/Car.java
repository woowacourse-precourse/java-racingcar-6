package racingcar.domain.car;

import racingcar.domain.policy.DriveRule;
import racingcar.domain.policy.MovePolicy;

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
            throw new IllegalArgumentException("이름을 확인해주세요.");
        }
    }

    private boolean isOver(String name) {
        return name.length() < NAME_LENGTH;
    }

    private boolean isEmpty(String name) {
        return name.isEmpty();
    }

    public void move(DriveRule driveRule) {
        if (isMove(driveRule)) {
            position++;
        }
    }

    private static boolean isMove(DriveRule driveRule) {
        return MovePolicy.canMove(driveRule);
    }

    public String printPosition() {
        return name + " : " + "-".repeat(Math.max(0, position));
    }
}
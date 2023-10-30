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
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("차의 이름은 5글자 이하여야 합니다.");
        }
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
        return name + "-".repeat(Math.max(0, position));
    }
}
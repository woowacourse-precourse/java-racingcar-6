package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Constant;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void attemptToMove() {
        if (isMovable()) {
            move();
        }
    }

    private boolean isMovable() {
        return pickRandomNumber() >= Constant.STANDARD_NUMBER_MOVING_FORWARD;
    }

    private void move() {
        this.position++;
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(Constant.MIN_RANDOM_NUMBER, Constant.MAX_RANDOM_NUMBER);
    }


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

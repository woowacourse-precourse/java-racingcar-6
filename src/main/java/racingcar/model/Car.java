package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Const;

public class Car {
    private int position;
    private final String name;

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    protected void setPosition(int position) {
        this.position = position;
    }

    public void move() {
        if (pickRandomNumber() >= Const.BOUNDARY_VALUE) {
            position++;
        }
    }

    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(
                Const.RANDOM_RANGE_MIN_NUM,
                Const.RANDOM_RANGE_MAX_NUM
            );
    }

    @Override
    public String toString() {
        return name + Const.CAR_NAME_SEPARATE + Const.CAR_MOVING_SIGN.repeat(position);
    }
}

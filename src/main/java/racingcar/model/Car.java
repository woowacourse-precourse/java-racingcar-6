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

    public void move() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            position++;
        }
    }

    @Override
    public String toString() {
        return name + Const.CAR_NAME_SEPARATE + Const.CAR_MOVING_SIGN.repeat(position);
    }
}

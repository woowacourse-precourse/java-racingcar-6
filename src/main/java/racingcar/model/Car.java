package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.NumberConstant.*;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (Randoms.pickNumberInRange(MIN_RANDOM_BOUND, MAX_RANDOM_BOUND) >= MOVING_POSITION) {
            position++;
        }
    }
}
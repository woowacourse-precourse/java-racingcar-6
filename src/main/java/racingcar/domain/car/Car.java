package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.Constant.*;

public class Car {
    private final String name;
    private int point;

    public Car(String name) {
        checkValid(name);
        this.name = name;
    }

    //==비즈니스 로직==//
    public void move() {
        if (canForward())
            point++;
    }

    private boolean canForward() {
        int number = Randoms.pickNumberInRange(START, END);
        return number >= MOVING_FORWARD;
    }

    //==검증 로직==//
    private void checkValid(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException(ERROR_INPUT_NAME);
    }

    //==get 메서드==//
    /*같은 패키지로 범위 제한*/
    String getName() {
        return name;
    }

    int getPoint() {
        return point;
    }

    //==출력==//
    @Override
    public String toString() {
        return name +
                IS +
                LINE.repeat(point);
    }

}

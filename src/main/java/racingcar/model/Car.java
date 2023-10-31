package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int LENGTH_LIMITER = 5;
    private static final int FORWARD_STANDARD = 4;
    private static final int INCREASE_AMOUNT = 1;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final String name;
    private int point;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.point = 0;
    }

    private void validateLength(String name) {
        if (name.length() > LENGTH_LIMITER) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다");
        }
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void forward() {
        if (getRandomNumber() >= FORWARD_STANDARD) {
            point += INCREASE_AMOUNT;
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}

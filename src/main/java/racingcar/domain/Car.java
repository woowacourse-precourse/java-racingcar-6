package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;
    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;
    public static final int FORWARD_NUM = 4;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (getRandomNum() >= FORWARD_NUM) {
            position++;
        }
    }

    private int getRandomNum() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }
}

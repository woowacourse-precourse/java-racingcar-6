package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;
    private final String name;
    private int nowNum;

    public Car(String name) {
        this.name = name;
        this.nowNum = 0;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }

    public void move() {
        if (getRandomNumber() >= 4) {
            nowNum++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getNowNum() {
        return this.nowNum;
    }
}

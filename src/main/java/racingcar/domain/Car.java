package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int nowNum;

    public Car(String name) {
        this.name = name;
        this.nowNum = 0;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void move() {
        if (getRandomNumber() >= 4) {
            nowNum++;
        }
    }
}

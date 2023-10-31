package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int nowNum;

    public Car() {
        this.nowNum = 0;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}

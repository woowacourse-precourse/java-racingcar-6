package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.GameRule;

public class Car {
    private String name;
    private int moveCnt;

    public Car(String name) {
        this.name = name;
        this.moveCnt = 0;
    }
}

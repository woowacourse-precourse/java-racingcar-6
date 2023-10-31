package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {
    public boolean rollTheDice(){
        // TODO: 상수 교체
        return makeRandomNumber() >= 4;
    }

    private Integer makeRandomNumber(){
        // TODO: 상수 교체
        return Randoms.pickNumberInRange(0, 9);
    }
}

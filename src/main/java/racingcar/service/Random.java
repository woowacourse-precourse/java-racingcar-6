package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    protected int randomNumber() {

        return Randoms.pickNumberInRange(0, 9);
    }
}

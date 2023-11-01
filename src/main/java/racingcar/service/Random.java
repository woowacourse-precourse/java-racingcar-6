package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    public int randomNumber() {

        return Randoms.pickNumberInRange(0, 9);
    }
}

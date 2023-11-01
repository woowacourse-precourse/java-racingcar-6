package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    private int randomNumber() {

        return Randoms.pickNumberInRange(0, 9);
    }
}

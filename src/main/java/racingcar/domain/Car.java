package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}

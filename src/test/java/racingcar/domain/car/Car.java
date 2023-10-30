package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private Name name;

    private Distance distance;

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
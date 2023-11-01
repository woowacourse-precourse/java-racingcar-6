package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public boolean engine() {
        int power = Randoms.pickNumberInRange(0, 9);

        if (power >= 4) {
            return true;
        } else {
            return false;
        }
    }

}

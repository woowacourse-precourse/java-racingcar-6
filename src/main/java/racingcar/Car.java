package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    Information information;
    Car (String name) {
        information = new Information(name);
    }

    boolean moveSuccessfully() {
        int speed;

        speed = Randoms.pickNumberInRange(0,9);
        if (speed >= 4) {
            return (true);
        }
        return (false);
    }
}

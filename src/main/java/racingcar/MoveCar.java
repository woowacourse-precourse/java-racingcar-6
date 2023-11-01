package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveCar {

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public int moveCarByRandomNumber() {
        if (createRandomNumber() >= 4) {
            return 1;
        } else {
            return 0;
        }
    }
}

package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.Config.*;

public class Refree {
    public Refree() {
    }

    public int generateNum() {
        return Randoms.pickNumberInRange(0, 9);

    }

    public boolean ForwardJungement() {
        int randNum = generateNum();
        if (randNum >= CanForwardMin) {
            return true;
        } else {
            return false;
        }
    }
}

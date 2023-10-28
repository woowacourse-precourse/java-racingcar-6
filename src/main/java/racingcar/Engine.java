package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.Message.*;

public class Engine {

    public int makeRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    public StringBuilder moveForward(StringBuilder beforeScore) {
        return beforeScore.append("-");
    }

    public boolean isMovable() {
        return makeRandomNumber(DICE_MIN_RANGE, DICE_MAX_RANGE) >= FORWARD_ABLE_NUMBER;
    }
}

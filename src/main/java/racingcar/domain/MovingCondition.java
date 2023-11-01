package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MovingCondition {
    public boolean isMovingForward(int condition) {
        return condition > 3;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}

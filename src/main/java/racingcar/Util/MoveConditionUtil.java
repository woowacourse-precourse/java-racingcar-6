package racingcar.Util;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveConditionUtil {

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean checkMoveCondition() {
        int randomNumber = getRandomNumber();
        return randomNumber >= 4;
    }
}

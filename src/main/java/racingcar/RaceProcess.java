package racingcar;

import static racingcar.constant.Constant.DICE_MAX_RANGE;
import static racingcar.constant.Constant.DICE_MIN_RANGE;
import static racingcar.constant.Constant.FORWARD_ABLE_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class RaceProcess {

    public void oneRound(Map<String, StringBuilder> scoreBoard) {
        for (Map.Entry<String, StringBuilder> pair : scoreBoard.entrySet()) {
            if (isMovable()) {
                pair.getValue().append("-");
            }
        }
    }

    private int makeRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    public boolean isMovable() {
        return makeRandomNumber(DICE_MIN_RANGE, DICE_MAX_RANGE) >= FORWARD_ABLE_NUMBER;
    }

}

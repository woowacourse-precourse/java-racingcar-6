package basis;

import static constant.Constant.MAXIMUM_RANGE;
import static constant.Constant.MINIMUM_RANGE;
import static constant.Constant.MOVE_CRITERIA;
import static constant.Constant.MOVE_SYMBOL;
import static constant.Constant.STOP_SYMBOL;

import camp.nextstep.edu.missionutils.Randoms;

public class MovingStatus {
    public String decideMove() {
        return checkDecidingMove(getRandomNumber());
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_RANGE, MAXIMUM_RANGE);
    }

    private String checkDecidingMove(int number) {
        if (number >= MOVE_CRITERIA) {
            return MOVE_SYMBOL;
        }
        return STOP_SYMBOL;
    }
}
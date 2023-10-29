package basis;

import static constant.Constant.MOVE_CRITERIA;
import static constant.Constant.MOVE_SYMBOL;
import static constant.Constant.STOP_SYMBOL;

public class MovingStatus {
    public String checkDecidingMove(int number) {
        if (number >= MOVE_CRITERIA) {
            return MOVE_SYMBOL;
        }
        return STOP_SYMBOL;
    }
}
package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.variable.MagicVariable;

public class MoveStatus {
    private Boolean testMoveStatus = null;

    public void setTestMoveStatus(Boolean testMoveStatus) {
        this.testMoveStatus = testMoveStatus;
    }

    public boolean canMove() {
        if (testMoveStatus != null) {
            return testMoveStatus;
        }
        return Randoms.pickNumberInRange(MagicVariable.PICK_NUM_MIN,MagicVariable.PICK_NUM_MAX) >= MagicVariable.FORWARD_NUM;
    }
}




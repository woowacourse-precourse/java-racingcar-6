package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.variable.MagicVariable;

public class MoveStatus {
    MagicVariable magicVariable = new MagicVariable();
    private Boolean testMoveStatus = null;

    public void setTestMoveStatus(Boolean testMoveStatus) {
        this.testMoveStatus = testMoveStatus;
    }

    public boolean canMove() {
        if (testMoveStatus != null) {
            return testMoveStatus;
        }
        return Randoms.pickNumberInRange(magicVariable.PICK_NUM_MIN,magicVariable.PICK_NUM_MAX) >= magicVariable.FORWARD_NUM;
    }
}




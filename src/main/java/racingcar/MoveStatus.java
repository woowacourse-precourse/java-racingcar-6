package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveStatus {
    MagicVariable magicVariable = new MagicVariable();
    private Boolean testMoveStatus = null;

    public Boolean getTestMoveStatus() {
        return testMoveStatus;
    }

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




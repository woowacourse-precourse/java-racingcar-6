package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveStatus {
    MagicVariable magicVariable = new MagicVariable();
    private Boolean testMoveStatus = null;

    public void setTestMoveStatus(Boolean testMoveStatus) {
        this.testMoveStatus = testMoveStatus;
    }

    private final int randomNumber = Randoms.pickNumberInRange(magicVariable.PICK_NUM_MIN,magicVariable.PICK_NUM_MAX);

    public int getRandomNumber() {
        return randomNumber;
    }

    public boolean canMove(int randomNumber) {
        if (testMoveStatus != null) {
            return testMoveStatus;
        }
        return randomNumber >= magicVariable.FORWARD_NUM;
    }
}




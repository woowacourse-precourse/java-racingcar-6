package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveStatus {
    MagicVariable magicVariable = new MagicVariable();
    public boolean canMove() {
        return Randoms.pickNumberInRange(magicVariable.PICK_NUM_MIN,magicVariable.PICK_NUM_MAX) >= magicVariable.FORWARD_NUM;
    }
}

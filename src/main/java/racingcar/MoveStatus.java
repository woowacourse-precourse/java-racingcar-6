package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultMoveStatus implements MoveStatus {
    MagicVariable magicVariable = new MagicVariable();
    private final int randomNumber = Randoms.pickNumberInRange(magicVariable.PICK_NUM_MIN,magicVariable.PICK_NUM_MAX);

    public int getRandomNumber() {
        return randomNumber;
    }

    @Override
    public boolean canMove(int randomNumber) {
        return randomNumber >= magicVariable.FORWARD_NUM;
    }
}




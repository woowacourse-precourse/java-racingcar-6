package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveStatus {
    MagicVariable magicVariable = new MagicVariable();
    private final int randomNumber = Randoms.pickNumberInRange(magicVariable.PICK_NUM_MIN,magicVariable.PICK_NUM_MAX);

    public int getRandomNumber() {
        return randomNumber;
    }

    public boolean canMove(int randomNumber) {
        return randomNumber >= magicVariable.FORWARD_NUM;
    }
}


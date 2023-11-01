package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Move {

    public boolean canMove(int randomNumber) {
        if (randomNumber < Constant.MOVE_CONSTRAINT) {
            return false;
        }
        return true;
    }

    public int randomNumberGenerator() {
        return Randoms.pickNumberInRange(Constant.MIN_RANDOMNUMBER, Constant.MAX_RANDOMNUMBER);
    }
}

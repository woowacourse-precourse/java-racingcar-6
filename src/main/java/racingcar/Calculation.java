package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Calculation {

    public int generateRandomNumberInRange() {
        return Randoms.pickNumberInRange(MagicNumber.RANDOM_MIN.getValue(),MagicNumber.RANDOM_MAX.getValue());
    }

    public CarStatus judgeCarMoveOrStop(int randomNumber) {
        if (randomNumber >= MagicNumber.CAM_MOVE_MIN.getValue()) {
            return CarStatus.MOVE;
        }
        return CarStatus.STOP;
    }
}

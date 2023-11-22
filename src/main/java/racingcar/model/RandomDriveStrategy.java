package racingcar.model;

import static racingcar.constant.Constant.Four;
import static racingcar.constant.Constant.NINE;
import static racingcar.constant.Constant.ZERO;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDriveStrategy implements DriveStrategy {
    @Override
    public boolean determineDistance() {
        int randomNumber = Randoms.pickNumberInRange(ZERO.number, NINE.number);
        if (randomNumber >= Four.number) {
            return true;
        }
        return false;
    }
}

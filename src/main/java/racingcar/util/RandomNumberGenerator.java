package racingcar.util;

import static racingcar.controller.GameConstants.MAX_NUMBER;
import static racingcar.controller.GameConstants.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber());
    }
}
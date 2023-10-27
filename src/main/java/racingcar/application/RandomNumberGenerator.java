package racingcar.application;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.application.NumberConstraints.MAX_NUMBER;
import static racingcar.application.NumberConstraints.MIN_NUMBER;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue());
    }
}

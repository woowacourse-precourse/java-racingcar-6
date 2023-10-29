package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.CarRaceConstant;

public class RandomGenerator {

    private final int MIN_LENGTH = CarRaceConstant.MIN_LENGTH.getConstant();
    private final int MAX_LENGTH = CarRaceConstant.MAX_LENGTH.getConstant();

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_LENGTH, MAX_LENGTH);
    }
}

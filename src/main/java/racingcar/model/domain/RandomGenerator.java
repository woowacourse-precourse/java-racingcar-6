package racingcar.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.constant.CarRaceConstant;

public class RandomGenerator {

    private static final int MIN_LENGTH = CarRaceConstant.MIN_LENGTH.getConstant();
    private static final int MAX_LENGTH = CarRaceConstant.MAX_LENGTH.getConstant();

    private RandomGenerator() {}

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_LENGTH, MAX_LENGTH);
    }
}

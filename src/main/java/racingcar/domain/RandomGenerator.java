package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.CarRaceConstant;

public class RandomGenerator {

    private final static int MIN_LENGTH = CarRaceConstant.MIN_LENGTH.getConstant();
    private final static int MAX_LENGTH = CarRaceConstant.MAX_LENGTH.getConstant();

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_LENGTH, MAX_LENGTH);
    }
}

package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRandomNumberGenerator implements RandomNumberGenerator{
    private static final int RANDOM_START_INCLUSIVE = 1;
    private static final int RANDOM_END_INCLUSIVE = 9;

    @Override
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
    }
}

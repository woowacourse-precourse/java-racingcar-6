package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.FixedNumber;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
    private static final RandomNumberGeneratorImpl instance = new RandomNumberGeneratorImpl();

    private RandomNumberGeneratorImpl() {
    }

    public static RandomNumberGeneratorImpl getInstance() {
        return instance;
    }

    @Override
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(
                FixedNumber.MIN_RANDOM_NUMBER.getValue(),
                FixedNumber.MAX_RANDOM_NUMBER.getValue()
        );
    }
}


package racingcar.utils.randomGenerator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator{

    public static final int MIN_DIGIT = 0;
    public static final int MAX_DIGIT = 9;


    @Override
    public int generateRandomSingleDigit() {
        return Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT);
    }
}

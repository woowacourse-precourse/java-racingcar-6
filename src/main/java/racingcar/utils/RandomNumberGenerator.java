package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 9;


    @Override
    public int generateNumberInRange() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

        return randomNumber;
    }
}

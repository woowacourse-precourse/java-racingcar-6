package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomPickNumber {
    private final static int MIN_NUMBER = 0;
    private final static int MAX_NUMBER = 9;

    public static int getRandomPickNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}

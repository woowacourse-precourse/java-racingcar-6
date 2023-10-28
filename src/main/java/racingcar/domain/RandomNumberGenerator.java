package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int SIZE = 1;

    public Integer generate() {
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(MIN, MAX, SIZE);
        return randomNumber.get(0);
    }
}

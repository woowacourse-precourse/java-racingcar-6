package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.constant.NumberLimits;

public class RandomNumberGenerator {
    public static List<Integer> createRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < size) {
            randomNumbers.add(Randoms.pickNumberInRange(NumberLimits.MIN_RANDOM_NUM, NumberLimits.MAX_RANDOM_NUM));
        }
        return randomNumbers;
    }

}

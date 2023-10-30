package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNuberGenerator {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    public static List<Integer> createRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < size) {
            randomNumbers.add(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
        }
        return randomNumbers;
    }
    
}

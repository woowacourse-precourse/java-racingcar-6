package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static List<Integer> createRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            randomNumbers.add(Randoms.pickNumberInRange(0,9));
        }

        return randomNumbers;
    }
}

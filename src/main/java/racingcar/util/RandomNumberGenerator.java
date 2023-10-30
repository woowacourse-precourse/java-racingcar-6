package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public List<Integer> generateNumbersInRange(int startInclusive, int endInclusive, int count) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(Randoms.pickNumberInRange(startInclusive, endInclusive));
        }
        return result;
    }
}

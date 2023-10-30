package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public List<Integer> createRandomNumberListInRange(int startInclusive, int endInclusive, int count) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(createOneRandomNumberInRange(startInclusive, endInclusive));
        }
        return result;
    }

    protected int createOneRandomNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}

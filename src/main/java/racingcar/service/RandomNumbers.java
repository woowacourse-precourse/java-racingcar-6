package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private final List<Integer> randomValues;

    public RandomNumbers(int size) {
        this.randomValues = generateRandomValues(size);
    }

    public int size() {
        return randomValues.size();
    }

    private List<Integer> generateRandomValues(int size) {
        int RANDOM_RANGE_START = 0;
        int RANDOM_RANGE_END = 9;
        List<Integer> randomValues = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomValues.add(Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END));
        }
        return randomValues;
    }

    public Boolean isGreaterEqualThanValueOf(int index, int threshold) {
        return randomValues.get(index) >= threshold;
    }
}

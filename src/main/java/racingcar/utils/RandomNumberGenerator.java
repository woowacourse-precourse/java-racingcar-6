package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

public class RandomNumberGenerator {

    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MAX_NUMBER_RANGE = 9;

    public List<Integer> generateWithSize(final int size) {
        return Stream.generate(this::generateOne).limit(size).toList();
    }

    private int generateOne() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
    }
}

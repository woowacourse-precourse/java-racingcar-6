package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class RandomNumberGenerator {

    private static final int START_INDEX = 0;
    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MAX_NUMBER_RANGE = 9;

    public List<Integer> generateWithSize(final int size) {
        return IntStream.range(START_INDEX, size).map(i -> generateOne()).boxed().toList();
    }

    private int generateOne() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
    }
}

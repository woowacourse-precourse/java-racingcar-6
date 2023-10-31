package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class RandomNumberGenerator {
    public static final int RANGE_MIN_VALUE = 0;
    public static final int RANGE_MAX_VALUE = 9;

    public static List<Integer> generateRandomNumbers(int size) {
        return IntStream.generate(() -> Randoms.pickNumberInRange(RANGE_MIN_VALUE, RANGE_MAX_VALUE))
                .limit(size)
                .boxed()
                .toList();
    }
}

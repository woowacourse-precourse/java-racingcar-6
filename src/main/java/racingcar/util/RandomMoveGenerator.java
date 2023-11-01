package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.Supplier;

public class RandomMoveGenerator {
    private static final int SMALLEST_NUMBER_FOR_RANDOM = 0;
    private static final int LARGEST_NUMBER_FOR_RANDOM = 9;
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    public static Supplier<Boolean> randomCarMoveGenerator() {
        return () -> Randoms.pickNumberInRange(SMALLEST_NUMBER_FOR_RANDOM, LARGEST_NUMBER_FOR_RANDOM) >= MINIMUM_NUMBER_TO_MOVE;
    }
}

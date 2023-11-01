package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.Supplier;

public class RandomNumberGenerator {

    private static final int STARTING_RANGE = 0;
    private static final int END_RANGE = 9;

    private static final Supplier<Integer> supplier = RandomNumberGenerator::generateNumber;

    private RandomNumberGenerator() {
    }

    private static int generateNumber() {
        return Randoms.pickNumberInRange(STARTING_RANGE, END_RANGE);
    }

    public static Supplier<Integer> getGenerateSupplier() {
        return supplier;
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

class RandomIntegerListGenerator {
    static List<Integer> generate(final int startInclusive, final int endInclusive, int generateCount) {
        return IntStream.range(0, generateCount)
                .map(operand -> Randoms.pickNumberInRange(startInclusive, endInclusive))
                .boxed()
                .toList();
    }
}

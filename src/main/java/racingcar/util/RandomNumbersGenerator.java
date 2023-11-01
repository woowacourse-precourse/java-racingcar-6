package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGenerator {

    private static final int MIN = 0;
    private static final int MAX = 9;

    private RandomNumbersGenerator() {
    }

    public static List<Integer> generate(int limitSize) {
        return IntStream.range(0, limitSize)
                .map(i -> Randoms.pickNumberInRange(MIN, MAX))
                .boxed()
                .collect(Collectors.toList());
    }
}

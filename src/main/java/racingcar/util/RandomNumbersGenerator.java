package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGenerator {

    public static final int MIN = 0;
    public static final int MAX = 9;

    public static List<Integer> generate(int limitSize) {
        return IntStream.range(0, limitSize)
                .map(i -> Randoms.pickNumberInRange(MIN, MAX))
                .boxed()
                .collect(Collectors.toList());
    }
}

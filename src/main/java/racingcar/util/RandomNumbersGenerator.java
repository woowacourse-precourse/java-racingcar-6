package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGenerator {

    public static List<Integer> generate(int limitSize) {
        return IntStream.range(0, limitSize)
                .map(i -> Randoms.pickNumberInRange(0, 9))
                .boxed()
                .collect(Collectors.toList());
    }
}

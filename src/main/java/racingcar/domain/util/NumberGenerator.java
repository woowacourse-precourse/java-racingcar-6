package racingcar.domain.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {
    public List<Integer> createNumber(int totalCarNumber) {
        return IntStream.range(0, totalCarNumber)
                .mapToObj(number -> Randoms.pickNumberInRange(0,9))
                .collect(Collectors.toList());
    }
}

package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtils {
    private static final int RANDOM_NUMBER_START_INCLUSIVE = 0;
    private static final int RANDOM_NUMBER_END_INCLUSIVE = 9;
    public List<Integer> getRandomNumberList(int carListSize) {
        return IntStream.range(0, carListSize)
                .mapToObj(i -> Randoms.pickNumberInRange(RANDOM_NUMBER_START_INCLUSIVE, RANDOM_NUMBER_END_INCLUSIVE))
                .collect(Collectors.toList());
    }
}

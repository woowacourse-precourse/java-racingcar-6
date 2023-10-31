package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberGenerator {
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static List<Integer> createRandomNumber(int num) {
        return Stream.generate(() -> createRandomNumber()).limit(num).collect(Collectors.toList());
    }
}

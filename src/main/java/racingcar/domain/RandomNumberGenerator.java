package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    private final int START = 0;
    private final int END = 9;

    public int generate() {
        return Randoms.pickNumberInRange(START, END);
    }

    public List<Integer> generateNumbers(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(generate());
        }
        return Collections.unmodifiableList(result);
    }
}

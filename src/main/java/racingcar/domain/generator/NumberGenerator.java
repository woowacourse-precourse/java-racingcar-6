package racingcar.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<Integer> createListNumber(int listNumber) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < listNumber; i++) {
            int between0and9 = Randoms.pickNumberInRange(0, 9);
            result.add(between0and9);
        }
        return result;
    }
}

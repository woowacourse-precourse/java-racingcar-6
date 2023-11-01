package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public NumberGenerator() {
    }

    public List<Integer> createRandomNumber(int n) {// Application에서 호출하도록 변경
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = Randoms.pickNumberInRange(0,9);
            numbers.add(number);
        }
        return numbers;
    }
}

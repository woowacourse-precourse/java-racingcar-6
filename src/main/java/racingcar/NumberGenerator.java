package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public List<Integer> generateRandomNumbers(int carCount) {
        List<Integer> numbers = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            numbers.add(Randoms.pickNumberInRange(0, 9));
        }

        return numbers;
    }
}

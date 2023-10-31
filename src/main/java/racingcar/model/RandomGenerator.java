package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    public List<Integer> getNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(createNumber());
        }
        return numbers;
    }

    private int createNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}

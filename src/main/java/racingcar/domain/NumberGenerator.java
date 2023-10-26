package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public List<Integer> createRandomNumbers(int number) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            numbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        return numbers;
    }
}

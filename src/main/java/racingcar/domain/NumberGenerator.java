package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    int numberOfPeople;

    public NumberGenerator(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            validateNumberInRange(number);
            numbers.add(number);
        }
        return numbers;
    }

    private void validateNumberInRange(int number) {
        if (number < 0 || number > 9)
            throw new IllegalArgumentException("벗어난 범위");
    }
}

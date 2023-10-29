package racingcar.global.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN_RANGE_OF_DIGITS = 0;
    private static final int MAX_RANGE_OF_DIGITS = 9;

    @Override
    public List<Integer> generate(Integer numberOfGames) {

        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < numberOfGames) {
            int randomNumber = getRandomNumber();
            numbers.add(randomNumber);
        }
        return numbers;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(
                MIN_RANGE_OF_DIGITS,
                MAX_RANGE_OF_DIGITS
        );
    }
}


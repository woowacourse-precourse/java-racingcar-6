package racingcar.global.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN_RANGE_OF_DIGITS = 0;
    private static final int MAX_RANGE_OF_DIGITS = 9;

    @Override
    public List<List<Integer>> generate(Integer numberOfGames, Integer nameCount) {
        List<List<Integer>> numbers = new ArrayList<>();
        for (int index = 0; index < nameCount; index++) {
            List<Integer> innerNumbers = innerGenerate(numberOfGames);
            numbers.add(innerNumbers);
        }
        return numbers;
    }

    private List<Integer> innerGenerate(Integer numberOfGames) {
        List<Integer> innerNumbers = new ArrayList<>();
        while (innerNumbers.size() < numberOfGames) {
            int randomNumber = getRandomNumber();
            innerNumbers.add(randomNumber);
        }
        return innerNumbers;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(
                MIN_RANGE_OF_DIGITS,
                MAX_RANGE_OF_DIGITS
        );
    }
}


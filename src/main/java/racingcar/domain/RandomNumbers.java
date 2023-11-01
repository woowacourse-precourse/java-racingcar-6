package racingcar.domain;

import racingcar.global.utils.generator.NumberGenerator;

import java.util.Collections;
import java.util.List;

public class RandomNumbers {

    private final List<List<Integer>> numbers;

//    검증하는 코드로 수정
    public RandomNumbers(NumberGenerator numberGenerator, Integer numberOfGames, Integer nameCount) {
        numbers = numberGenerator.generate(numberOfGames, nameCount);
    }

    public List<List<Integer>> getRandomNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}

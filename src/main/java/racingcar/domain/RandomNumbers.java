package racingcar.domain;

import java.util.List;

public class RandomNumbers {

    List<Integer> randomNumbers;

    public RandomNumbers(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public int get(int index) {
        return randomNumbers.get(index);
    }

}

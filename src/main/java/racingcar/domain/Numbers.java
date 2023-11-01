package racingcar.domain;

import racingcar.global.utils.generator.NumberGenerator;

public class Numbers {

    private final RandomNumbers numbers;
    private int numerOfGames;
    private int nameCount;

    public Numbers(NumberGenerator numberGenerator, Integer numerOfGames, Integer nameCount) {
        numbers = new RandomNumbers(numberGenerator, numerOfGames, nameCount);
    }

    public RandomNumbers getNumbers() {
        return numbers;
    }

}

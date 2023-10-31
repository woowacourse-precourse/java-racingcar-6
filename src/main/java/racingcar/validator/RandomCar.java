package racingcar.validator;

import racingcar.util.RandomNumberGenerator;
import racingcar.util.ZeroToNineGenerator;

public class RandomCar {
    private String name;
    private int position = 0;
    private RandomNumberGenerator randomNumberGenerator;

    public RandomCar(String name) {
        this(name, new ZeroToNineGenerator());
    }

    public RandomCar(String name, RandomNumberGenerator randomGenerator) {
        this.name = name;
        this.randomNumberGenerator = randomGenerator;
    }

    public int move() {
        int randomNumber = randomNumberGenerator.generate();

        if (randomNumber >= 4) {
            position++;
        }

        return position;
    }
}
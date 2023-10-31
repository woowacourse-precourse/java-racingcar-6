package racingcar.domain;

import java.util.Random;

public class RandomNumbers {

    public int createRandomNumbers() {

        int randomNumber = new Random().nextInt(0, 10);

        return randomNumber;
    }
}

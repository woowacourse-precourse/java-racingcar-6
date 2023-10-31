package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbers {

    public List createRandomNumbers(int carsNameListSize) {

        RacingGame racingGame = new RacingGame();
        int inputTryCount = racingGame.inputTryCount();

        List<Integer> randomNumberList = new ArrayList<>();

        for (int i = 0; i < carsNameListSize; i++) {
            randomNumberList.add(new Random().nextInt(0, 10));
        }

        return randomNumberList;
    }
}

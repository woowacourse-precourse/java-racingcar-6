package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Random;

public class RacingGame {
    private int tryCount = 0;

    public int inputTryCount() {

        System.out.println("시도할 회수는 몇회인가요?");
        tryCount = Integer.parseInt(Console.readLine());

        return tryCount;
    }

    public String winner() {

        return null;
    }

    public void run() {
        Cars cars = new Cars();
        RandomNumbers randomNumbers = new RandomNumbers();

        List<String> carsNameList = cars.createCars();

        List randomNumberList = randomNumbers.createRandomNumbers(carsNameList.size());

        winner();
    }
}


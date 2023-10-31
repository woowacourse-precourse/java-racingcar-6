package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

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

        List<String> carsName = cars.createCars();
        int inputTryCount = inputTryCount();

        cars.sprint(carsName.toString(), inputTryCount);

        winner();
    }
}


package racingcar.io;

import racingcar.model.Cars;

import java.util.List;

public class Output {
    public void printResult(Cars cars) {
        List<String> carNames = cars.getName();
        for (String name : carNames) {
            int score = cars.getScore(name);
            String reach = "-".repeat(score);
            System.out.println(name + " : " + reach);
        }
        System.out.println();
    }
}

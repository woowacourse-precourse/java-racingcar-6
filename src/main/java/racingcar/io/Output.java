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

    public void printWinner(Cars cars) {
        List<String> winner = cars.getWinner();
        String result = String.join(",", winner);
        System.out.print("최종 우승자 : " + result);
    }
}

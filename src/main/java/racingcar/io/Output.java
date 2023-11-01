package racingcar.io;

import racingcar.model.Cars;

import java.util.List;

public class Output {
    public void printResult(Cars cars) {
        List<String> names = cars.getName();
        List<Integer> scores = cars.getScore();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            int score = scores.get(i);
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

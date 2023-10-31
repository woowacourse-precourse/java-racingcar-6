package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {
    public GameResult() {
    }

    public void printResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getLocation());
        }
        System.out.println();
    }

    public void findWinner(List<Car> carList) {
        List<Integer> locations = new ArrayList<>();
        int topScore;

        for (Car car : carList) {
            locations.add(car.getLocation().length());
        }
        locations.sort(Collections.reverseOrder());
        topScore = locations.get(0);
        printWinner(carList, topScore);
    }

    public void printWinner(List<Car> carList, int topScore) {
        String winner = "";
        int carScore = 0;

        for (Car car : carList) {
            carScore = car.getLocation().length();
            if (carScore == topScore && winner.equals("")) winner += car.getName();
            else if (carScore == topScore) winner += ", " + car.getName();
        }

        System.out.println("최종 우승자 : " + winner);
    }
}

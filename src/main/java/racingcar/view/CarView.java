package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarView {
    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
        System.out.println();
    }

    public void printWinner(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        int maxScore = getMaxScore(cars);

        for (Car car : cars) {
            if (car.getLocation() == maxScore) {
                winner.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        if (winner.size() == 1) {
            System.out.println(winner.get(0));
        } else if (winner.size() >= 2) {
            printWinners(winner);
        }
    }

    private int getMaxScore(List<Car> cars) {
        int max_score = 0;

        for (Car car : cars) {
            if (car.getLocation() > max_score) {
                max_score = car.getLocation();
            }
        }

        return max_score;
    }

    private void printWinners(List<String> winners) {
        System.out.print(winners.get(0));
        winners.remove(0);

        for (String winner : winners) {
            System.out.print(", " + winner);
        }
    }
}

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
        List<String> winners = getWinners(cars);
        System.out.print("최종 우승자 : ");
        if (winners.size() == 1) {
            System.out.println(winners.get(0));
        } else if (winners.size() >= 2) {
            printWinners(winners);
        }
    }

    private List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxLocation = getMaxLocation(cars);

        for (Car car : cars) {
            if (car.getLocation() == maxLocation) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int getMaxLocation(List<Car> cars) {
        int maxLocation = 0;

        for (Car car : cars) {
            if (car.getLocation() > maxLocation) {
                maxLocation = car.getLocation();
            }
        }

        return maxLocation;
    }

    private void printWinners(List<String> winners) {
        System.out.print(winners.get(0));
        winners.remove(0);

        for (String winner : winners) {
            System.out.print(", " + winner);
        }
    }
}

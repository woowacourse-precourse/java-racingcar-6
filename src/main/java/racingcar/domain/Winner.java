package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.view.PrintMessage;

public class Winner {
    private final List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public void printWinners() {
        List<String> winners = findWinners();
        PrintMessage.printRacingWinner(winners);
    }

    private List<String> findWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
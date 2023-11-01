package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.view.ConsoleView;

public class WinnersAnnouncer {
    private ConsoleView view;

    public WinnersAnnouncer() {
        view = new ConsoleView();
    }

    public String announceWinners(RacingCar[] cars) {
        int maxPosition = findMaxPosition(cars);
        StringBuilder winners = new StringBuilder();
        for (RacingCar car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.append(car.getName()).append(", ");
            }
        }
        return winners.substring(0, winners.length() - 2); // Remove trailing comma and space
    }

    private int findMaxPosition(RacingCar[] cars) {
        int max = 0;
        for (RacingCar car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }
}

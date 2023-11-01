package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<Car> cars;

    public void run() {
        cars = Controller.inputNames();
        int count = Controller.inputCount();

        Controller.printResultTitle();
        for (int i = 0; i < count; i++) {
            moveCars();
            Controller.printCarStates(cars);
        }

        printWinner();
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void printWinner() {
        List<Car> winners = getWinners();
        Controller.printWinners(winners);
    }

    public List<Car> getWinners() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        ArrayList<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }

        return winners;
    }
}

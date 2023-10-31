package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.ResultView;

public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void run() {
        for (int i = 0; i < rounds; i++) {
            runRound();
            ResultView.printRaceResult(cars);
        }
    }

    private void runRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return selectCarsInMaxPosition(maxPosition);
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private List<Car> selectCarsInMaxPosition(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}

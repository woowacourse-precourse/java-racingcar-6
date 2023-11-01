package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.ui.OutputView;

public class Game {
    private final List<Car> cars;
    private final int round;

    public Game(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void playAllRound() {
        for (int i = 0; i < round; i++) {
            System.out.print(OutputView.ENTER);
            playOneRound();
        }

        OutputView.printWinners(findWinners(findMaxDistance()));
    }

    private void playOneRound() {
        for (Car car : cars) {
            int number = NumberGenerator.generate();
            car.move(number);

            OutputView.printGameResult(car, car.getDistance());
        }
    }

    private int findMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getDistance() >= maxDistance) {
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }

    private List<Car> findWinners(int maxDistance) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }
}

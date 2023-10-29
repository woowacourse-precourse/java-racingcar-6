package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void run() {
        int racingCount = getRacingCount();
        for (int count = 0; count < racingCount; count++) {
            racing();
            getRacingResult(cars);
            System.out.println();
        }
    }

    private void racing() {
        for (Car car : cars) {
            if (Racing.isMovingForward()) {
                car.addPosition();
            }
        }
    }

    private int getRacingCount() {
        OutputView.printCarRacingCountMessage();
        return InputView.readRacingTryCount();
    }

    private void getRacingResult(List<Car> cars) {
        for (Car car : cars) {
            OutputView.printCarRacingResult(car.getName(), car.getPosition());
        }
    }


}
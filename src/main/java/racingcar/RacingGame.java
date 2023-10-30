package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Setting;
import racingcar.domain.Win;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private static int numberOfAttempts = 0;
    static List<Car> cars;

    public static void run() {
        cars = Setting.initCar();
        numberOfAttempts = Setting.initNumberOfAttempt();
        OutputView.executionMessage();
        racing();
    }

    private static void oneLap() {
        for (Car car : cars) {
            car.moveAdvance();
        }
    }

    private static void racing() {
        for (int i = 0; i < numberOfAttempts; i++) {
            oneLap();
            OutputView.executionResult(cars);
            System.out.println();
        }
        Win win = new Win(cars);
        OutputView.Winner(win.getWin());
    }
}

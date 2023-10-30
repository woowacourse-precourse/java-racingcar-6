package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Setting;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private static int numberOfAttempts = 0;
    static List<Car> cars;

    public static void run() {
        cars = Setting.initCar();
        numberOfAttempts = Setting.initNumberOfAttempt();
        OutputView.executionMessage();
    }
}

package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.OutputView;
import java.util.List;

public class RacingController {
    public static void racingStart(List<Car> cars, int racingCount) {
        for (int i = 0; i < racingCount; i++) {
            executeRacingRound(cars);
        }
    }

    private static void executeRacingRound(List<Car> cars) {
        for (Car car : cars) {
            manageCarMovement(car, makeCarRandomNumber());
        }
        showRacingRoundResult(cars);
    }

    private static void showRacingRoundResult(List<Car> cars) {
        for (Car car : cars) {
            OutputView.printRacingRoundResult(car.getName(), car.getPosition());
        }
    }

    private static int makeCarRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    private static void manageCarMovement(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.moveCar();
        }
    }
}

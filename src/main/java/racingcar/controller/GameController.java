package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public static void GameConsole() {
        List<Car> cars = InputView.getCarNames();
        int numberOfAttempts = InputView.getNumberOfAttempts();

        List<String> winners = startRace(cars, numberOfAttempts);

        OutputView.displayWinners(winners);
    }

    public static List<String> startRace(List<Car> cars, int numberOfAttempts) {
        System.out.println("실행 결과");
        for (int attempt = 0; attempt < numberOfAttempts; attempt++) {
            makeCarMovements(cars);
            OutputView.displayCarMovements(cars);
        }
        return announceWinners(cars);
    }

    private static void makeCarMovements(List<Car> cars) {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.incrementPosition();
            }
        }
    }

    private static List<String> announceWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}

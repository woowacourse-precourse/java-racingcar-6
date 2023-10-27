package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println();
    }

    private static int makeCarRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    private static void manageCarMovement(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.moveCar();
        }
    }

    public static void showRacingWinner(List<Car> cars) {
        List<String> winnerCars = computeRacingWinner(cars);
    }

    private static List<String> computeRacingWinner(List<Car> cars) {
        int winnerPosition = computeRacingWinnerPosition(cars);
        return cars.stream().filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int computeRacingWinnerPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }
}

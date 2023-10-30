package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {

    private static final int DECIDE_TO_NUMBER_MOVE_STOP = 4;

    public static void racingStart(List<Car> cars, int racingCount) {
        for (int i = 0; i < racingCount; i++) {
            executeRacingRound(cars);
        }
    }

    private static void executeRacingRound(List<Car> cars) {
        List<Integer> randomNumbers = generateRandomNumbers(cars.size());
        moveCars(cars, randomNumbers);
        showRacingRoundResult(cars);
    }

    private static void moveCars(List<Car> cars, List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            manageCarMovement(cars.get(i), randomNumbers.get(i));
        }
    }

    private static List<Integer> generateRandomNumbers(int count) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomNumbers.add(makeCarRandomNumber());
        }
        return randomNumbers;
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

    public static void manageCarMovement(Car car, int randomNumber) {
        if (randomNumber >= DECIDE_TO_NUMBER_MOVE_STOP) {
            car.moveCar();
        }
    }

    public static void showRacingWinner(List<Car> cars) {
        List<String> winnerCars = computeRacingWinner(cars);
        OutputView.printRacingWinner(winnerCars);
    }

    public static List<String> computeRacingWinner(List<Car> cars) {
        int winnerPosition = computeRacingWinnerPosition(cars);
        return cars.stream().filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int computeRacingWinnerPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }
}

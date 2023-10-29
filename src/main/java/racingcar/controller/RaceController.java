package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.utils.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.enums.Message;

public class RaceController {
    private List<Car> cars;
    private int totalRounds;

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void start() {
        OutputView.printStartMessage();
        cars = createCars(InputView.inputCarName());
        OutputView.printPlayRound();
        totalRounds = InputView.inputPlayRound();
        System.out.println();
        OutputView.printPlayResult();
        for (int round = 0; round < totalRounds; round++) {
            playRound();
            displayCurrentPositions(cars);
        }
        List<Car> winners = findWinners();
        displayWinners(winners);
    }

    private void playRound() {
        for (Car car : cars) {
            int randomNumber = RandomNumber.generator();
            car.move(randomNumber);
        }
    }

    public static void displayCurrentPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printPosition(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

    private List<Car> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public static void displayWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(Message.PLAY_WINNER_MESSAGE + winnerNames);
    }
}

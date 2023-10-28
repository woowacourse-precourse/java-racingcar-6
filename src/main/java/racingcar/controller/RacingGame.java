package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.util.InputValidator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final MoveStrategy moveStrategy;

    public RacingGame() {
        this.moveStrategy = new RandomMoveStrategy();
    }

    public void start() {
        String carNamesInput = inputAndValidateCarNames();
        String roundInput = inputAndValidateRound();

        System.out.println();

        List<Car> cars = createCars(carNamesInput);

        System.out.println("실행 결과");

        int roundCount = Integer.parseInt(roundInput);
        for (int currentRound = 0; currentRound < roundCount; currentRound++) {
            move(cars);
            printProgress(cars);
        }

        System.out.print("최종 우승자 : " + getWinners(cars));
    }

    private String inputAndValidateCarNames() {
        String carNamesInput = InputView.inputCarNames();
        InputValidator.validateCarNames(carNamesInput);

        return carNamesInput;
    }

    private String inputAndValidateRound() {
        String roundInput = InputView.inputRound();
        InputValidator.validateRound(roundInput);

        return roundInput;
    }

    private List<Car> createCars(String input) {
        List<Car> cars = new ArrayList<>();
        for (int carIndex = 0; carIndex < input.split(",").length; carIndex++) {
            Car car = new Car(input.split(",")[carIndex]);

            cars.add(car);
        }

        return cars;
    }

    private void move(List<Car> cars) {
        for (Car car : cars) {
            if (moveStrategy.isAbleToMove())
                car.move();
        }
    }

    private void printProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getProgress(car));
        }
        System.out.println();
    }

    private String getProgress(Car car) {
        return "-".repeat(Math.max(0, car.getPosition()));
    }

    private String getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
            }

            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return String.join(",", winners);
    }
}

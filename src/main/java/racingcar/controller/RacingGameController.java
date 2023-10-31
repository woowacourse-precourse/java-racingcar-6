package racingcar.controller;

import static racingcar.view.OutputView.printRacingWinner;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final List<Car> cars;

    public RacingGameController(List<Car> cars) {
        this.cars = cars;
    }

    public void run() {
        int racingCount = getRacingCount();
        for (int count = 0; count < racingCount; count++) {
            racing();
            getRacingResult(cars);
            System.out.println();
        }

        printRacingWinner(getRacingWinner(cars));
    }

    private void racing() {
        for (Car car : cars) {
            if (RacingService.isMovingForward()) {
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

    private List<String> getRacingWinner(List<Car> cars) {
        int maxCarPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        return cars.stream()
                .filter(car -> car.getPosition() == maxCarPosition)
                .map(Car::getName)
                .toList();
    }
}